package com.example.pearl.data.repositories

import com.example.pearl.data.remote.TwilioApiService
import android.util.Log
import com.example.pearl.data.remote.dto.TwilioMessageResponse
import com.example.pearl.domain.model.User
import com.example.pearl.domain.model.UserAddress
import com.example.pearl.domain.model.UserGender
import com.example.pearl.domain.repositories.AuthRepository
import com.example.pearl.util.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.UUID

class AuthRepositoryImpl(
    private val mFirebaseAuth: FirebaseAuth,
    private val mDatabase: FirebaseDatabase,
    private val mTwilioApiService: TwilioApiService
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String,
        onFailure : (Throwable) -> Unit
    ){
        mFirebaseAuth.signInWithEmailAndPassword(email , password)
            .addOnFailureListener {
                  onFailure(it)
            }
    }

    override suspend fun signUp(
        userDataMap : Map<String , Any>,
        email: String,
        password : String,
        onFailure : (Throwable) -> Unit
    ){
            mFirebaseAuth.createUserWithEmailAndPassword(email , password)
                .addOnSuccessListener {
                    val addressUUID = UUID.randomUUID().toString()

                    val address = UserAddress(
                        id = addressUUID,
                        street = userDataMap["street"] as String,
                        country = userDataMap["country"] as String,
                        state = userDataMap["state"] as String
                    )

                    val user = User(
                        uid = it.user!!.uid,
                        name = userDataMap["name"] as String,
                        email = email,
                        phoneNo = userDataMap["phoneNumber"] as String,
                        gender = userDataMap["gender"] as UserGender,
                        age = userDataMap["age"] as String,
                        address = address
                    )

                    setUserDataIntoDB(user)

                }.addOnFailureListener {
                    onFailure(it)
                }
    }

    override suspend fun signOut() {
        mFirebaseAuth.signOut()
    }

    override suspend fun resetPassword(
        email: String,
        onSuccess : () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        mFirebaseAuth.sendPasswordResetEmail(email)
            .addOnSuccessListener {
                onSuccess()
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override fun sendOTP(to: String, from: String, body : String) {
        val call = mTwilioApiService.sendOTP("+201010440206", from , body)
        call.enqueue(object : Callback<TwilioMessageResponse> {
            override fun onResponse(call: Call<TwilioMessageResponse>, response: Response<TwilioMessageResponse>) {
                // Handle successful response
                //display dialog that indicates that message was sent successfully
                Log.e("OTP TAG" , "OTP message was sent successfully")
            }

            override fun onFailure(call: Call<TwilioMessageResponse>, t: Throwable) {
                // Handle failure
                Log.e("OTP TAG" , "OTP message wasn't sent successfully")
            }
        })
    }


    private fun setUserDataIntoDB(
        user : User,
    ){
        mDatabase.getReference(Constants.USER_REFERENCE).child(user.uid).setValue(user)
    }

    override suspend fun deleteAccount(
        email: String,
        password: String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        val uid = mFirebaseAuth.currentUser!!.uid

        mFirebaseAuth.signInWithEmailAndPassword(email , password)
            .addOnSuccessListener {
                mFirebaseAuth.currentUser!!.delete()
                    .addOnSuccessListener {
                        mDatabase.getReference(Constants.USER_REFERENCE).child(uid).removeValue()
                        onSuccess()
                        Log.e("AUTH" , "Account deleted successfully")
                    }.addOnFailureListener {
                        onFailure(it)
                        Log.e("AUTH" , "something wrong happened : ${it.message}" )
                    }
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override suspend fun updatePassword(
        email : String,
        password: String ,
        newPassword : String,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        mFirebaseAuth.signInWithEmailAndPassword(email , password)
            .addOnSuccessListener {
                mFirebaseAuth.currentUser!!.updatePassword(newPassword)
                    .addOnSuccessListener {
                        onSuccess()
                        Log.e("AUTH" , "Password updated successfully")
                    }.addOnFailureListener {
                        onFailure(it)
                        Log.e("AUTH" , "something wrong happened : ${it.message}" )
                    }
            }.addOnFailureListener {
                onFailure(it)
            }
    }

    override suspend fun updateProfile(
        user : User,
        onSuccess: () -> Unit,
        onFailure: (Throwable) -> Unit
    ) {
        val uid = mFirebaseAuth.currentUser!!.uid

        val userRef = mDatabase.getReference(Constants.USER_REFERENCE).child(uid)

        userRef.get().addOnCompleteListener {
            var currentUser = it.result.getValue(User::class.java)

            currentUser = currentUser?.copy(name = user.name , gender = user.gender, age = user.age)

            userRef.setValue(currentUser).addOnSuccessListener {
                onSuccess()
                Log.e("Update Profile" , "profile updated successfully")
            }.addOnFailureListener {
                Log.e("Update Profile" , "Something went wrong : ${it.message}")
                onFailure(it)
            }
        }
    }

    override suspend fun getUser(
        onSuccess: (User) -> Unit,
        onFailure: (Throwable) -> Unit
    ){
        val uid = mFirebaseAuth.currentUser!!.uid

        val userRef = mDatabase.getReference(Constants.USER_REFERENCE).child(uid)

        userRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val currentUser = snapshot.getValue(User::class.java)
                onSuccess(currentUser!!)
            }

            override fun onCancelled(error: DatabaseError) {
                onFailure(error.toException())
            }
        })
    }
}