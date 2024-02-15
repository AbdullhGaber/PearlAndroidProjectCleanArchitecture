package com.example.pearl.presentation.common

import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R

@Composable
fun DialogBox(
    modifier: Modifier = Modifier,
    dialogBoxData: DialogBoxData
){
    Box(modifier = modifier
        .background(color = Color.White, shape = RoundedCornerShape(35.dp))
        .padding(vertical = MediumPadding1)
        .size(279.dp,386.dp)
    ){

        if(dialogBoxData.background != null){
            Box(modifier = Modifier.fillMaxSize() ){
                Image(
                    painter = painterResource(id = dialogBoxData.background) ,
                    contentDescription = null,
                    modifier = Modifier.matchParentSize(),
                    contentScale = ContentScale.FillBounds
                )
            }
        }

        Column(
            modifier = Modifier.padding(horizontal = MediumPadding1),
            horizontalAlignment = CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = dialogBoxData.icon),
                contentDescription = null,
                modifier = Modifier.size(110.dp , 122.dp)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))
            
            Text(text = dialogBoxData.title , fontSize = 22.sp , fontWeight = FontWeight.ExtraBold, textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(text = dialogBoxData.text , fontSize = 13.sp , fontWeight = FontWeight.Normal , textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(MediumPadding1))

            PrimaryButton(text = "Continue" , onClick = {})
        }
    }
}

@Composable
@Preview
fun DialogBoxPreview(){
    DialogBox(dialogBoxData = DialogBoxData(
        icon = R.drawable.done_bubble,
        background = null,
        title = "Password Updated Successfully!",
        text = "Your password has been updated successfully"
    ))
}

data class DialogBoxData(
  @DrawableRes val background : Int? ,
  @ColorInt val color : Color = Color.White,
  @DrawableRes val icon : Int,
  val title : String ,
  val text : String
)


