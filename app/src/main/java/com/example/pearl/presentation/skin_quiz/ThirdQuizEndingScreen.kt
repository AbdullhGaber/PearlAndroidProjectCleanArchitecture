package com.example.pearl.presentation.skin_quiz

import com.example.pearl.presentation.my_skin.issueCircleDataList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.SecondaryButton
import com.example.pearl.presentation.my_skin.components.IssuesCircle

@Composable
fun ThirdQuizEndingScreen(
    quizScreenState: QuizScreenState,
    questionEvent: (QuestionEvent) -> Unit,
    navigateToHome: () -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .verticalScroll(scrollState)
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Your Skin Type",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                Modifier
                    .padding(horizontal = 14.dp, vertical = 3.dp)
                    .clip(RoundedCornerShape(5.dp))
                    .background(Color(0xFFDED5FE))
            ){
                Text(
                    text = "Combination",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                )
            }

            Spacer(modifier = Modifier.height(33.dp))

            Image(
                painter = painterResource(id = R.drawable.face_analysis),
                contentDescription = null,
                modifier = Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .size(285.dp, 342.dp),
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = Modifier.height(26.dp))

            Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween){
                repeat(issueCircleDataList.size){
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.weight(1f)
                    ){
                        IssuesCircle(
                            percent = issueCircleDataList[it].percent,
                            backgroundColor = issueCircleDataList[it].backgroundColor,
                            edgeColor = issueCircleDataList[it].edgeColor
                        )

                        Spacer(modifier = Modifier.height(9.dp))

                        Text(
                            text = issueCircleDataList[it].issue,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Medium,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
            Box(modifier = Modifier
                .padding(10.dp)
            ){
                Column(
                    Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
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
}

@Composable
@Preview
fun PreviewThirdQuizEndingScreen(){
//    ThirdQuizEndingScreen()
}