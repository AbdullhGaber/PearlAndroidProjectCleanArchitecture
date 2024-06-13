package com.example.pearl.presentation.skin_quiz

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pearl.domain.usecases.quiz.QuizUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(
    val quizUseCases: QuizUseCases
) : ViewModel(){
    val quizScreenState = mutableStateOf(QuizScreenState())
    private val mAnswersTracker = MutableList(18){""}
    private val mQuestionAnswersMap : MutableMap<String , String> = mutableMapOf()

    fun onEvent(event : QuestionEvent){
        when(event){
            is QuestionEvent.NextQuestion -> {
                if(quizScreenState.value.currentQuestionIndex != questions.lastIndex){

                    if(questions[quizScreenState.value.currentQuestionIndex].questionText.isNotBlank()){
                        //store answer in answers list
                        mAnswersTracker[quizScreenState.value.currentQuestionIndex] = event.answer

                        //store answer in map
                        mQuestionAnswersMap[questions[quizScreenState.value.currentQuestionIndex].questionText] = event.answer
                    }

                    //update question index
                    quizScreenState.value = quizScreenState.value.copy(currentQuestionIndex = event.currentQuestionIndex + 1)

                    //clear answer
                    onEvent(QuestionEvent.UncheckAnswer)
                }

                when(quizScreenState.value.currentStep){
                    0 -> {
                        //update progress
                        if(quizScreenState.value.progressPercentage < 1f){
                            onEvent(QuestionEvent.UpdateProgress(1f/9f))
                        }
                    }

                    1 -> {
                        if(quizScreenState.value.quizStage != QuizStage.NUTRITION_START){
                            //update progress
                            onEvent(QuestionEvent.UpdateProgress(1f/4f))
                        }
                    }

                    2 -> {
                        //update progress
                        quizScreenState.value = quizScreenState.value.copy(
                            progressPercentage = event.currentProgress + if(quizScreenState.value.quizStage == QuizStage.QUIZ_ENDING) 0f else 1f/4f
                        )
                    }
                }
            }

            is QuestionEvent.UpdateProgress -> {
                quizScreenState.value = quizScreenState.value.copy(
                    progressPercentage = quizScreenState.value.progressPercentage + event.percentage
                )
            }

            is QuestionEvent.UpdateCurrentStep -> {
                quizScreenState.value = quizScreenState.value.copy(currentStep = event.step)
            }

            is QuestionEvent.CheckAnswer -> {
                if(quizScreenState.value.isAnswerChosen){
                    onEvent(QuestionEvent.UncheckAnswer)
                }else{
                    quizScreenState.value = quizScreenState.value.copy(isAnswerChosen = true, chosenAnswer = event.answer)
                }
            }

            is QuestionEvent.CheckAnotherAnswer -> {
                onEvent(QuestionEvent.UncheckAnswer)
                onEvent(QuestionEvent.CheckAnswer(event.answer))
            }

            is QuestionEvent.UncheckAnswer -> {
                quizScreenState.value = quizScreenState.value.copy(isAnswerChosen = false , chosenAnswer = "")
            }

            is QuestionEvent.UpdateStage -> {
                onEvent(QuestionEvent.UncheckAnswer)

                quizScreenState.value = quizScreenState.value.copy(
                    quizStage = event.stage,
                )

                when(event.stage){
                    QuizStage.GENERAL_QUESTIONS -> {
                       onEvent(QuestionEvent.UpdateProgress(1f/9f))
                    }

                    QuizStage.NUTRITION_START -> {
                        quizScreenState.value = quizScreenState.value.copy(
                            progressPercentage = 0f,
                        )
                        onEvent(QuestionEvent.UpdateCurrentStep(1))
                    }

                    QuizStage.QUIZ_ENDING -> {
                        quizScreenState.value = quizScreenState.value.copy(
                            progressPercentage = 0f
                        )
                        onEvent(QuestionEvent.UpdateCurrentStep(2))
                    }

                    else -> {}
                }
            }

            is QuestionEvent.SaveAnswers -> {
                viewModelScope.launch {
                    saveAnswersInDB()
                }
            }

            is QuestionEvent.PreviousQuestion -> {
                if(quizScreenState.value.currentQuestionIndex > 0){
                    val currentIndex = quizScreenState.value.currentQuestionIndex
                    val prevQuestionIndex =  currentIndex - 1
                    val progress = quizScreenState.value.progressPercentage
                    val currentStep = quizScreenState.value.currentStep
                    val quizStage = quizScreenState.value.quizStage
                    val quizStages = QuizStage.values()
                    val ordinal = quizStage.ordinal

                    val progressMinus = when (currentStep) {
                        0 -> {
                            1f/9f
                        }
                        1 -> {
                            1f/4f
                        }
                        else -> {
                            1f/4f
                        }
                    }

                    quizScreenState.value = quizScreenState.value.copy(
                        currentQuestionIndex =  prevQuestionIndex,
                        chosenAnswer =  mAnswersTracker[prevQuestionIndex],
                        isAnswerChosen = true,
                        progressPercentage = if(progress > 0.0f) progress - progressMinus else 1.0f,
                        currentStep = if(progress == 0f) currentStep - 1 else currentStep,
                        quizStage = if(progress == 0f || currentStep == 2 || progress - progressMinus == 0f ) quizStages[ordinal - 1] else quizStage
                    )
                }
            }
        }
    }

    private suspend fun saveAnswersInDB() {
        quizUseCases.saveAnswersUseCase(mQuestionAnswersMap)
    }
}