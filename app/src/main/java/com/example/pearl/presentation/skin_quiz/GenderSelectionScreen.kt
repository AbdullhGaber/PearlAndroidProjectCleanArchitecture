package com.example.pearl.presentation.skin_quiz

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.skin_quiz.components.QuestionButton

@Composable
fun GenderSelectionScreen(
    quizScreenState: QuizScreenState,
    questionEvent: (QuestionEvent) -> Unit,
){
    Box(
        modifier = Modifier.background(colorResource(id = R.color.primary_background))
    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(10.dp)
        ){
            Text(text = "What's your gender ?" , fontSize = 22.sp , fontWeight = FontWeight.Medium)

            Spacer(modifier = Modifier.height(40.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
            ){

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    val buttonBackground = if(quizScreenState.chosenAnswer == "male") colorResource(id = R.color.quiz_selection)
                    else Color.White
                    Image(
                        painter = painterResource(id = R.drawable.boy_question),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        alpha = if(quizScreenState.chosenAnswer == "female") 0.2f else 1f
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    QuestionButton(
                        text = "Male",
                        background = buttonBackground
                    ){
                        if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer == "male") {
                            questionEvent(QuestionEvent.UncheckAnswer)
                            return@QuestionButton
                        }

                        if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer != "male") {
                            questionEvent(QuestionEvent.CheckAnotherAnswer("male"))
                            return@QuestionButton
                        }

                        questionEvent(QuestionEvent.CheckAnswer("male"))
                    }
                }

                Column(
                    modifier = Modifier.weight(1f),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    val buttonBackground = if(quizScreenState.chosenAnswer == "female") colorResource(id = R.color.quiz_selection)
                    else Color.White
                    Image(
                        painter = painterResource(id = R.drawable.girl_question),
                        contentDescription = null,
                        contentScale = ContentScale.FillBounds,
                        alpha = if(quizScreenState.chosenAnswer == "male") 0.2f else 1f
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    QuestionButton(
                        text = "Female",
                        background = buttonBackground
                    ) {
                        //female is already clicked
                        if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer == "female") {
                            questionEvent(QuestionEvent.UncheckAnswer)
                            return@QuestionButton
                        }

                        //male is clicked before
                        if (quizScreenState.chosenAnswer.isNotEmpty() && quizScreenState.chosenAnswer != "female") {
                            questionEvent(QuestionEvent.CheckAnotherAnswer("female"))

                            return@QuestionButton
                        }

                        questionEvent(QuestionEvent.CheckAnswer("female"))
                    }
                }
            }
        }

    }
}

@Composable
@Preview
fun PreviewGenderSelectionScreen(){
    GenderSelectionScreen(QuizScreenState() , {})
}