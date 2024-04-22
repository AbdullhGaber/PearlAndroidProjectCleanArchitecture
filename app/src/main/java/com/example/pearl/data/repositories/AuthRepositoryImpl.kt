package com.example.pearl.data.repositories

import com.example.pearl.data.remote.TwilioApiService
import android.content.Context
import android.telephony.SmsManager
import android.util.Log
import arrow.core.Either
import com.example.pearl.data.remote.dto.TwilioMessageResponse
import com.example.pearl.domain.model.User
import com.example.pearl.domain.repositories.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepositoryImpl(
    val mFirebaseAuth: FirebaseAuth,
    val mDatabase: FirebaseDatabase,
    val mTwilioApiService: TwilioApiService
) : AuthRepository {

    override suspend fun login(
        email: String,
        password: String,
    ) : Either<Throwable , Unit>{
        return Either.catch {
            mFirebaseAuth.signInWithEmailAndPassword(
                email , password
            ).addOnFailureListener {
               throw it
            }
        }
    }

    override suspend fun signUp(
        user: User,
        password : String,
    ) : Either<Throwable , Unit> {
        return Either.catch {
            mFirebaseAuth.createUserWithEmailAndPassword(user.email , password)
                .addOnSuccessListener {
                    setUserDataIntoDB(user)
                }.addOnFailureListener {
                    throw it
                }
        }
    }

    override suspend fun signOut() {
        mFirebaseAuth.signOut()
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


    fun setUserDataIntoDB(
        user : User,
    ) : Either<Throwable , Unit>{
        return Either.catch {
            mDatabase.getReference("user").push().setValue(user)
                .addOnFailureListener {
                    throw it
                }
        }
    }
}