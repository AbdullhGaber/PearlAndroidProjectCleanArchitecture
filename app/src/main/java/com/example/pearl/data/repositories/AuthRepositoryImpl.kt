package com.example.pearl.data.repositories

import arrow.core.Either
import com.example.pearl.domain.model.User
import com.example.pearl.domain.repositories.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class AuthRepositoryImpl(
    val mFirebaseAuth: FirebaseAuth,
    val mDatabase: FirebaseDatabase
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