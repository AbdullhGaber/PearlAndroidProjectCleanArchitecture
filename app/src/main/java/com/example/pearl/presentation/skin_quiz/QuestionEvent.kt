package com.example.pearl.presentation.skin_quiz

sealed class QuestionEvent{

    data class NextQuestion(
        val currentQuestionIndex : Int ,
        val answer : String,
        val currentStep : Int,
        val currentProgress : Float
    ) : QuestionEvent()

    data class CheckAnswer(val answer : String) : QuestionEvent()
    data class CheckAnotherAnswer(val answer: String) : QuestionEvent()
    object UncheckAnswer : QuestionEvent()
    data class UpdateProgress(val percentage : Float) : QuestionEvent()
    data class UpdateCurrentStep(val step : Int) : QuestionEvent()
    data class UpdateStage(val stage : QuizStage) : QuestionEvent()

    object PreviousQuestion : QuestionEvent()

}
