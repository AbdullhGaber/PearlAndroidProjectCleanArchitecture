package com.example.pearl.presentation.nutrition_routine

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.nutrition_routine.components.DynamicWaterCircle
import com.example.pearl.presentation.nutrition_routine.components.NutritionRoutineCard

@Composable
fun NutritionRoutineScreen(
    navigateToPrevious : () -> Unit,
    navigateToScreen : (String) -> Unit
){
    val scrollState = rememberScrollState()
    Box(
        modifier = Modifier.fillMaxSize().verticalScroll(scrollState)
    ){
        Column(
            Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Row(Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(5.dp)
                            .clickable {
                                navigateToPrevious()
                            }
                    )

                    Text(
                        text = "Water Intake",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.
                        align(Alignment.Center)
                    )
                }
            }
            
            Spacer(modifier = Modifier.height(15.dp))

            DynamicWaterCircle()

            Text(
                text = "Nutrition Routine",
                fontSize = 18.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF000000),
            )

            Spacer(modifier = Modifier.height(20.dp))

            NutritionRoutineCard(
                nutritionRoutineBoxData = nutritionRoutineBoxDataList[0],
                onClick = {
                    navigateToScreen(Route.StickAvoidRoutineScreen.route)
                }
            )

            Spacer(modifier = Modifier.height(5.dp))

            NutritionRoutineCard(
                nutritionRoutineBoxData = nutritionRoutineBoxDataList[1],
                onClick = {
                    navigateToScreen(Route.RecipesScreen.route)
                }
            )
        }
    }
}

@Composable
@Preview
fun NutritionRoutinePreview(){
    NutritionRoutineScreen({} , {})
}