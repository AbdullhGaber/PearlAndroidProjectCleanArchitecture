package com.example.pearl.presentation.skin_quiz

data class QuizScreenState(
    val progressPercentage : Float = 0f,
    val currentStep : Int = 0,
    val currentQuestionIndex : Int = 0,
    val isAnswerChosen : Boolean = false,
    val chosenAnswer : String = "",
    val quizStage: QuizStage = QuizStage.GENDER_SELECTION,
)
