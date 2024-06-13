package com.example.pearl.presentation.skin_quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.SecondaryButton
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.skin_quiz.components.StepsProgressBar

@Composable
fun QuizScreen(
    quizScreenState: QuizScreenState,
    questionEvent: (QuestionEvent) -> Unit,
    navigateToHome: () -> Unit
){
    val backgroundColor = if(quizScreenState.quizStage == QuizStage.NUTRITION_QUESTIONS) {
        colorResource(id = R.color.secondary_background)
    }else {
        colorResource(id = R.color.primary_background)
    }

   Box(
       modifier = Modifier
           .background(backgroundColor)
           .fillMaxSize()
   ){
       Column(
           Modifier.fillMaxSize(),
           horizontalAlignment = Alignment.CenterHorizontally,
       ){
           Box(
               modifier = Modifier
                   .padding(10.dp)
                   .fillMaxWidth()
           ){
               Image(
                   painter = painterResource(id = R.drawable.arrow_back),
                   contentDescription = null,
                   modifier = Modifier.
                   align(Alignment.CenterStart).
                   clickable {
                        questionEvent(QuestionEvent.PreviousQuestion)
                   }
               )

               Text(
                   text = "Skin quiz",
                   fontSize = 14.sp,
                   fontWeight = FontWeight.Medium,
                   modifier = Modifier.align(Alignment.TopCenter)
               )
           }
           
           Spacer(modifier = Modifier.height(16.dp))

           StepsProgressBar(
               progressPercent = quizScreenState.progressPercentage,
               numberOfSteps = 2,
               currentStep = quizScreenState.currentStep,
           )

           when(quizScreenState.quizStage){

               QuizStage.GENDER_SELECTION -> {
                    GenderSelectionScreen(quizScreenState = quizScreenState, questionEvent = questionEvent )
               }

               QuizStage.GENERAL_QUESTIONS , QuizStage.NUTRITION_QUESTIONS -> {
                   QuestionScreen(questions[quizScreenState.currentQuestionIndex],quizScreenState,questionEvent)
               }

               QuizStage.NUTRITION_START -> {
                    NutritionQuestionsStartingScreen()
               }

               QuizStage.QUIZ_ENDING -> {
                    QuizEndingScreen()
               }

               QuizStage.FIRST_QUIZ_ENDING_SCREEN -> {
                    FirstQuizEndingScreen()
               }

               QuizStage.SECOND_QUIZ_ENDING_SCREEN -> {
                    SecondQuizEndingScreen(
                        quizScreenState,
                        questionEvent,
                        navigateToHome
                    )
               }

               QuizStage.THIRD_QUIZ_ENDING_SCREEN -> {
                    ThirdQuizEndingScreen(
                        quizScreenState,
                        questionEvent,
                        navigateToHome
                    )
               }

               QuizStage.LAST_QUIZ_ENDING_SCREEN -> {
                    LastQuizEndingScreen()
               }
           }
       }

       when(quizScreenState.quizStage){
           QuizStage.GENERAL_QUESTIONS , QuizStage.GENDER_SELECTION  -> {
               if(quizScreenState.isAnswerChosen){
                   Box(
                       modifier = Modifier
                           .padding(10.dp)
                           .align(Alignment.BottomCenter)
                   ){
                       PrimaryButton(
                           text = "Next",
                           onClick = {
                               if(quizScreenState.quizStage == QuizStage.GENDER_SELECTION){
                                   questionEvent(QuestionEvent.UpdateStage(QuizStage.GENERAL_QUESTIONS))
                               }else{
                                   if(quizScreenState.currentQuestionIndex == 7){
                                       questionEvent(
                                           QuestionEvent.NextQuestion(
                                               quizScreenState.currentQuestionIndex,
                                               quizScreenState.chosenAnswer,
                                               quizScreenState.currentStep,
                                               quizScreenState.progressPercentage
                                           )
                                       )
                                       questionEvent(QuestionEvent.UpdateStage(QuizStage.NUTRITION_START))
                                       return@PrimaryButton
                                   }

                                   questionEvent(
                                       QuestionEvent.NextQuestion(
                                           quizScreenState.currentQuestionIndex,
                                           quizScreenState.chosenAnswer,
                                           quizScreenState.currentStep,
                                           quizScreenState.progressPercentage
                                       )
                                   )
                               }
                           },
                           modifier = Modifier.fillMaxWidth()
                       )
                   }
               }
           }

           QuizStage.NUTRITION_QUESTIONS -> {
               Box(
                   modifier = Modifier
                       .padding(10.dp)
                       .align(Alignment.BottomCenter)
               ){
                   Column(
                       Modifier.fillMaxWidth(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       if(quizScreenState.isAnswerChosen){
                           PrimaryButton(
                               text = "Next",
                               onClick = {
                                   if(quizScreenState.currentQuestionIndex == 12){
                                       questionEvent(
                                           QuestionEvent.NextQuestion(
                                               quizScreenState.currentQuestionIndex,
                                               quizScreenState.chosenAnswer,
                                               quizScreenState.currentStep,
                                               quizScreenState.progressPercentage,
                                           )
                                       )
                                       questionEvent(QuestionEvent.UpdateStage(QuizStage.QUIZ_ENDING))
                                       return@PrimaryButton
                                   }
                                   questionEvent(
                                       QuestionEvent.NextQuestion(
                                           quizScreenState.currentQuestionIndex,
                                           quizScreenState.chosenAnswer,
                                           quizScreenState.currentStep,
                                           quizScreenState.progressPercentage,
                                       )
                                   )
                               },
                               modifier = Modifier.fillMaxWidth()
                           )
                       }

                       SecondaryButton(
                           text = "Skip",
                           onClick = {
                               questionEvent(QuestionEvent.SaveAnswers)
                               navigateToHome()
                           },
                           modifier = Modifier.fillMaxWidth()
                       )
                   }
               }
           }

           QuizStage.NUTRITION_START , QuizStage.QUIZ_ENDING -> {
               Box(modifier = Modifier
                   .padding(10.dp)
                   .align(Alignment.BottomCenter)
               ){
                   Column(
                       Modifier.fillMaxWidth(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       PrimaryButton(
                           text = "Continue",
                           onClick = {
                               if(quizScreenState.quizStage == QuizStage.NUTRITION_START){
                                   questionEvent(QuestionEvent.UpdateStage(QuizStage.NUTRITION_QUESTIONS))
                               }else{
                                   questionEvent(QuestionEvent.UpdateStage(QuizStage.FIRST_QUIZ_ENDING_SCREEN))
                                   questionEvent(
                                       QuestionEvent.NextQuestion(
                                           quizScreenState.currentQuestionIndex,
                                           quizScreenState.chosenAnswer,
                                           quizScreenState.currentStep,
                                           quizScreenState.progressPercentage,
                                       )
                                   )
                                   return@PrimaryButton
                               }

                               questionEvent(QuestionEvent.NextQuestion(
                                   currentQuestionIndex = quizScreenState.currentQuestionIndex,
                                   answer = "",
                                   currentStep = quizScreenState.currentStep,
                                   currentProgress = quizScreenState.progressPercentage
                               ))

                           },
                           modifier = Modifier.fillMaxWidth()
                       )

                       Spacer(modifier = Modifier.height(17.dp))

                       SecondaryButton(
                           text = "Skip",
                           onClick = {
                               navigateToHome()
                               questionEvent(QuestionEvent.SaveAnswers)
                           },
                           modifier = Modifier.fillMaxWidth()
                       )
                   }
               }
           }

           QuizStage.FIRST_QUIZ_ENDING_SCREEN -> {
               Box(modifier = Modifier
                   .padding(10.dp)
                   .align(Alignment.BottomCenter)
               ){
                   Column(
                       Modifier.fillMaxWidth(),
                       verticalArrangement = Arrangement.Center,
                       horizontalAlignment = Alignment.CenterHorizontally
                   ){
                       PrimaryButton(
                           text = "Take a selfie",
                           onClick = {
                               questionEvent(QuestionEvent.NextQuestion(
                                   currentQuestionIndex = quizScreenState.currentQuestionIndex,
                                   answer = "",
                                   currentStep = quizScreenState.currentStep,
                                   currentProgress = quizScreenState.progressPercentage
                               ))
                               questionEvent(QuestionEvent.UpdateStage(QuizStage.SECOND_QUIZ_ENDING_SCREEN))
                            },
                           modifier = Modifier.fillMaxWidth()
                       )

                       Spacer(modifier = Modifier.height(17.dp))

                       SecondaryButton(
                           text = "Skip",
                           onClick = {
                               navigateToHome()
                               questionEvent(QuestionEvent.SaveAnswers)
                           },
                           modifier = Modifier.fillMaxWidth()
                       )
                   }
               }
           }

           QuizStage.LAST_QUIZ_ENDING_SCREEN -> {
               Box(
                   modifier = Modifier
                       .padding(10.dp)
                       .align(Alignment.BottomCenter)
               ){
                   PrimaryButton(
                       text = "Let's get started",
                       onClick = {
                           navigateToHome()
                           questionEvent(QuestionEvent.SaveAnswers)
                       },
                       modifier = Modifier.fillMaxWidth()
                   )
               }
           }

           else -> {}

       }
   }
}

@Composable
@Preview
fun PreviewQuizScreen(){
//    QuizScreen(QuizScreenState())
}
