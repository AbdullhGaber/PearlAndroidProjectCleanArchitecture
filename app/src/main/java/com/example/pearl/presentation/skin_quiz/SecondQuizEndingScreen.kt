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
            .fillMaxSize()
            .verticalScroll(scrollState)
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(20.dp)
        ){
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Main Skin Concerns",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF000000),
                modifier = Modifier.align(CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween){
                Image(
                    painter = painterResource(id = R.drawable.face_analysis),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .size(151.65.dp, 177.35.dp),
                    contentScale = ContentScale.FillBounds
                )

                Column {
                    Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween){
                        repeat(2){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(1f)
                            ){
                                IssuesCircle(
                                    percent = skinConcernsCircleDataList[it].percent,
                                    backgroundColor = skinConcernsCircleDataList[it].backgroundColor,
                                    edgeColor = skinConcernsCircleDataList[it].edgeColor
                                )

                                Spacer(modifier = Modifier.height(9.dp))

                                Text(
                                    text = skinConcernsCircleDataList[it].issue,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Row(Modifier.fillMaxWidth() , Arrangement.SpaceBetween){
                        for(index in 2..3 ){
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(1f)
                            ){
                                IssuesCircle(
                                    percent = skinConcernsCircleDataList[index].percent,
                                    backgroundColor = skinConcernsCircleDataList[index].backgroundColor,
                                    edgeColor = skinConcernsCircleDataList[index].edgeColor
                                )

                                Spacer(modifier = Modifier.height(9.dp))

                                Text(
                                    text = skinConcernsCircleDataList[index].issue,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                )
                            }
                        }
                    }
                }
            }


            Spacer(modifier = Modifier.height(37.4.dp))

            repeat(issueBoxDataList.size){
                IssuesBox(
                    modifier = Modifier.padding(8.dp),
                    background = issueBoxDataList[it].backgroundColor,
                    borderColor = issueBoxDataList[it].edgeColor
                ) {
                    Column(
                        Modifier.padding(horizontal = 16.dp , vertical = 8.dp)
                    ){
                        Text(text = issueBoxDataList[it].issue  , fontSize = 14.sp , fontWeight = FontWeight.Bold)

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = issueBoxDataList[it].description,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Normal,
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(modifier = Modifier
                .padding(10.dp)
            ){
                Column(
                    Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter),
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
                            questionEvent(QuestionEvent.UpdateStage(QuizStage.THIRD_QUIZ_ENDING_SCREEN))
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
fun PreviewSecondQuizEndingScreen(){
//    SecondQuizEndingScreen()
}