package com.example.pearl.presentation.recipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R

@Composable
fun RecipesDetailsScreen(
    recipesData: RecipesData,
    naviagteToPrevious : () -> Unit
){
    Box(modifier = Modifier.fillMaxSize()) {
        val state = rememberScrollState()
        Column(
            Modifier
                .fillMaxSize()
                .verticalScroll(state),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Row(Modifier
                .padding(20.dp)
                .fillMaxWidth()){
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier.padding(5.dp)
                    )

                    Text(
                        text = "Grilled Salmon & Quinoa",
                        fontSize = 18.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Image(
                painter = painterResource(id = R.drawable.baked_salamon),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.clip(RoundedCornerShape(topStart = 10.dp , topEnd = 10.dp))
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Column(
                modifier = Modifier
                    .align(Start)
                    .padding(horizontal = 20.dp)
            ){
                Text(
                    text = "Ingredients:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.height(10.dp))

                for(ingredient in recipesData.ingredients){
                    Text(
                        text = ingredient+"\n",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF7F7F7F),
                        modifier = Modifier.padding(bottom = ExtraSmallPadding2)
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "Instructions:",
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.height(10.dp))

                for(index in recipesData.instructions.indices){
                    Text(
                        text = "${index+1}. ${recipesData.instructions[index]}\n",
                        fontSize = 12.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF7F7F7F),
                        modifier = Modifier.padding(bottom = ExtraSmallPadding2)
                    )
                }

                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ){
                    for(emoji in emojiList){
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ){
                            Image(painter = painterResource(id = emoji.icon), contentDescription = null)

                            Spacer(modifier = Modifier.padding(1.dp))

                            Text(
                                text = emoji.name,
                                fontSize = 6.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF7F7F7F)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipesDetails(){
    RecipesDetailsScreen(recipesList[0] , {})
}