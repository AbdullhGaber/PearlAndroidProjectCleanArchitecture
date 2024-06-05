package com.example.pearl.presentation.recipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import com.example.pearl.R

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
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.recipes.compnents.RecipesCard


@Composable
fun RecipesScreen(
    navigateToPrevious : () -> Unit,
    navigateToScreen : (String) -> Unit
) {
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .verticalScroll(scrollState)) {
        Column(
            Modifier.fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ){
            Row(
                Modifier
                    .padding(20.dp)
                    .fillMaxWidth()){
                Box(modifier = Modifier.fillMaxWidth()) {
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
                        text = "Recipes for you",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Box(modifier = Modifier.wrapContentSize()) {
                Column(
                    Modifier.padding(30.dp),
                    Arrangement.Center,
                    Alignment.CenterHorizontally
                ) {
                    for (recipeData in recipesList){
                        RecipesCard(
                            recipeData = recipeData,
                            onClick = {
                                navigateToScreen(Route.RecipesDetailsScreen.route + "/${recipeData.id}")
                            }
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipesScreen(){
  RecipesScreen({},{})
}