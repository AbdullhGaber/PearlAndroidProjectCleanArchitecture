package com.example.pearl.presentation.skin_quiz

import com.example.pearl.presentation.my_skin.issueBoxDataList
import com.example.pearl.presentation.my_skin.skinConcernsCircleDataList
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.SecondaryButton
import com.example.pearl.presentation.my_skin.components.IssuesBox
import com.example.pearl.presentation.my_skin.components.IssuesCircle

@Composable
fun SecondQuizEndingScreen(
    quizScreenState: QuizScreenState,
    questionEvent: (QuestionEvent) -> Unit,
    navigateToHome: () -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color(0xFFFAF6FF))
            .verticalScroll(scrollState)
    ){

        Column(
            Modifier.fillMaxSize().padding(20.dp),
            verticalArrangement = Arrangement.Center,
        ){
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Your Acne Severity",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

                Image(
                    painter = painterResource(id = R.drawable.face1),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(250.dp, 270.dp)
                        .align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.FillBounds
                )

            Spacer(modifier = Modifier.height(37.4.dp))


                IssuesBox(
                    modifier = Modifier.padding(8.dp),
                    background = issueBoxDataList[0].backgroundColor,
                    borderColor = issueBoxDataList[0].edgeColor
                ) {
                    Column(
                        Modifier.padding(horizontal = 16.dp , vertical = 8.dp)
                    ){
                        Text(text = issueBoxDataList[0].issue  , fontSize = 14.sp , fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = issueBoxDataList[0].description,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }


            Spacer(modifier = Modifier.height(20.dp))


            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = CenterHorizontally
            ){
                PrimaryButton(
                    text = "Next",
                    onClick = {
                        questionEvent(QuestionEvent.NextQuestion(
                            currentQuestionIndex = quizScreenState.currentQuestionIndex,
                            answer = "",
                            currentStep = quizScreenState.currentStep,
                            currentProgress = quizScreenState.progressPercentage
                        ))
                        questionEvent(QuestionEvent.UpdateStage(QuizStage.LAST_QUIZ_ENDING_SCREEN))
                    },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(17.dp))

                SecondaryButton(
                    text = "Skip",
                    onClick = {navigateToHome() },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }


    }
}

@Composable
@Preview
fun PreviewSecondQuizEndingScreen(){
    SecondQuizEndingScreen(quizScreenState = QuizScreenState() , {} , {})
}