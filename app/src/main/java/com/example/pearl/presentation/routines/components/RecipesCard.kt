package com.example.pearl.presentation.routines.components

import androidx.compose.foundation.Image
import com.example.pearl.R
import androidx.compose.foundation.background
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
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.pearl.presentation.routines.RecipesData
import com.example.pearl.presentation.routines.recipesList


@Composable
fun RecipesCard(recipesData: RecipesData){
    Box(Modifier
        .wrapContentSize()
        .padding(5.dp)
        .clip(RoundedCornerShape(10.dp))
        .background(Color.White)){
        Row(Modifier.padding(20.dp)) {
            Image(
                painter = painterResource(id = recipesData.icon),
                contentDescription = null
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column(Modifier.wrapContentSize()){
                Text(
                    text = recipesData.title,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )

                Spacer(modifier = Modifier.height(ExtraSmallPadding))

                Text(
                    text = recipesData.body,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF7F7F7F),
                )

                Spacer(modifier = Modifier.height(10.dp))

                Row(horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.CenterVertically){
                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.love_emoji),
                            contentDescription = null,
                            modifier = Modifier.width(10.dp).height(8.97.dp)
                        )

                        Spacer(modifier = Modifier.width(ExtraSmallPadding))

                        Text(
                            text = "${recipesData.loves}",
                            fontSize = 6.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.delicious),
                            contentDescription = null,
                            modifier = Modifier.width(10.dp).height(10.dp)
                        )

                        Spacer(modifier = Modifier.width(ExtraSmallPadding))

                        Text(
                            text = "${recipesData.unsatisfied}",
                            fontSize = 6.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.dislike),
                            contentDescription = null,
                            modifier = Modifier.width(8.95.dp).height(10.dp)
                        )

                        Spacer(modifier = Modifier.width(ExtraSmallPadding))

                        Text(
                            text = "${recipesData.dislikes}",
                            fontSize = 6.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Row{
                        Image(
                            painter = painterResource(id = R.drawable.unsatisfied_emoji),
                            contentDescription = null,
                            modifier = Modifier.width(10.dp).height(10.dp)
                        )

                        Spacer(modifier = Modifier.width(ExtraSmallPadding))

                        Text(
                            text = "${recipesData.unsatisfied}",
                            fontSize = 6.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFF000000),
                        )
                    }

                }

            }
        }
    }
}

@Composable
@Preview
fun PreviewRecipesCard(){
    RecipesCard(recipesData = recipesList[0])
}