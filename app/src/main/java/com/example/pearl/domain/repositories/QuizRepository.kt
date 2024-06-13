package com.example.pearl.domain.repositories

interface QuizRepository {
    suspend fun saveAnswers(questionAnswersMap: MutableMap<String , String>)
}