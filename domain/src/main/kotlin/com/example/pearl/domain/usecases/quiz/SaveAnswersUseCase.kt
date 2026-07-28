package com.example.pearl.domain.usecases.quiz

import com.example.pearl.domain.repositories.QuizRepository

class SaveAnswersUseCase(
    val quizRepository: QuizRepository
) {
    suspend operator fun invoke(questionAnswersMap : MutableMap<String,String>){
        quizRepository.saveAnswers(questionAnswersMap)
    }
}
