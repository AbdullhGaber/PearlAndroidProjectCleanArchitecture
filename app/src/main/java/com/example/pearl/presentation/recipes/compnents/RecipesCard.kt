package com.example.pearl.presentation.recipes.compnents

import androidx.compose.foundation.Image
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.presentation.recipes.RecipesData
import com.example.pearl.presentation.recipes.emojiList
import com.example.pearl.presentation.recipes.recipesList


@Composable
fun RecipesCard(
    recipeData: RecipesData,
    onClick : () -> Unit
){
    Box(Modifier
        .wrapContentSize()
        .padding(5.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White)
        .clickable {
            onClick()
        }
    ){
        Row(Modifier.padding(20.dp)) {
            Image(
                painter = painterResource(id = recipeData.icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(Modifier.wrapContentSize()){
                Text(
                    text = recipeData.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.height(ExtraSmallPadding))

                Text(
                    text = recipeData.body,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF7F7F7F),
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    horizontalArrangement = Arrangement.Center ,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    for(emoji in emojiList){
                        Row(
                            horizontalArrangement = Arrangement.Center ,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Image(
                                painter = painterResource(id = emoji.icon),
                                contentDescription = null,
                                modifier = Modifier.width(20.dp).height(20.dp)
                            )

                            Spacer(modifier = Modifier.width(ExtraSmallPadding))

                            val reactsNo = when(emoji.id){
                                1 -> recipeData.loves
                                2 -> recipeData.delicious
                                3 -> recipeData.dislikes
                                4 -> recipeData.unsatisfied
                                else -> 0
                            }

                            Text(
                                text = "$reactsNo",
                                fontSize = 8.sp,
                                fontWeight = FontWeight(400),
                                color = Color(0xFF000000),
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipesCard(){
    RecipesCard(recipeData = recipesList[0] , {})
}