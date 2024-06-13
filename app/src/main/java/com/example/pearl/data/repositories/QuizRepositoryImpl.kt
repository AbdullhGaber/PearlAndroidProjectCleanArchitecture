package com.example.pearl.data.repositories

import com.example.pearl.domain.repositories.QuizRepository
import com.example.pearl.util.Constants
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class QuizRepositoryImpl(
    val mDatabase: FirebaseDatabase,
    val mFirebaseAuth : FirebaseAuth
) : QuizRepository {
    override suspend fun saveAnswers(questionAnswersMap: MutableMap<String, String>) {
        mDatabase.getReference(Constants.USER_REFERENCE).
        child(mFirebaseAuth.currentUser!!.uid).
        child("questionAnswers").
        setValue(questionAnswersMap)
    }
}