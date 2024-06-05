package com.example.pearl.presentation.skin_progress

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.pearl.R
import com.example.pearl.presentation.common.BigCircleButton
import com.example.pearl.presentation.common.SkinCalenderView
import com.example.pearl.presentation.nav_graph.navigateToPreviousTab
import com.example.pearl.presentation.pearl_navigator.PearlNavEventFunction
import com.example.pearl.presentation.pearl_navigator.PearlNavState
import com.example.pearl.presentation.pearl_navigator.PearlNavigatorEvents

@Composable
fun SkinProgressScreen(
    navigateToPreviousTab : () -> Unit
){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)) {
        Column(
            Modifier.fillMaxSize(),
        ) {
            Row(
                Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
            ){
                Box(modifier = Modifier.fillMaxWidth()) {
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.padding(5.dp).clickable {
                            navigateToPreviousTab()
                        }
                    )

                    Text(
                        text = "Skin Progress",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Text(
                text = "November 2023",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000),
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(18.dp))

            SkinCalenderView(
                modifier = Modifier.padding(horizontal = 10.dp)
            )

            Spacer(modifier = Modifier.height(100.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(horizontal = 10.dp).fillMaxWidth()
            ) {
                Image(painter = painterResource(id = R.drawable.progress_camera), contentDescription = null )

                Spacer(modifier = Modifier.height(50.dp))

                val takePhotoText = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF7F7F7F),
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp
                        )
                    ){
                        append("Take photo diary for ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFFFF93AC),
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp
                        )
                    ){
                        append("2 more weeks ")
                    }

                    withStyle(
                        style = SpanStyle(
                            color = Color(0xFF7F7F7F),
                            fontWeight = FontWeight(500),
                            fontSize = 12.sp
                        )
                    ){
                        append("to\ngenerate your progress level!")
                    }
                }

                Text(text = takePhotoText , textAlign = TextAlign.Center)

                Spacer(modifier = Modifier.height(100.dp))

                BigCircleButton(icon = R.drawable.camera_button , onClick = {})

                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}

@Composable
@Preview
fun PreviewSkinProgressScreen(){
//    SkinProgressScreen()
}