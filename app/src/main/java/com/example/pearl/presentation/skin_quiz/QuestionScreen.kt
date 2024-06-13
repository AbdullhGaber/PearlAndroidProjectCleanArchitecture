package com.example.pearl.presentation.skin_quiz

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.skin_quiz.components.QuestionButton

@Composable
fun QuestionScreen(
    question: Question,
    quizScreenState: QuizScreenState,
    questionEvent: (QuestionEvent) -> Unit,
){
    Box{
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = question.questionText , fontSize = 22.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(40.dp))

            for(ans in question.options){
                val answerColor = if(quizScreenState.chosenAnswer == ans)  colorResource(id = R.color.quiz_selection)
                else Color.White

                QuestionButton(
                    text = ans,
                    background = answerColor
                ) {
                    if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer == ans) {
                        questionEvent(QuestionEvent.UncheckAnswer)
                        return@QuestionButton
                    }

                    if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer != ans) {
                        questionEvent(QuestionEvent.CheckAnotherAnswer(ans))
                        return@QuestionButton
                    }

                    questionEvent(QuestionEvent.CheckAnswer(ans))
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewQuestionScreen(){
    QuestionScreen(questions[0] , QuizScreenState()){}
}