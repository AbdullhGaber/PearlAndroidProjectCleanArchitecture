package com.example.pearl.presentation.common


import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2


@Composable
fun SkinCalenderView(
    modifier : Modifier = Modifier
){
        Row(modifier = modifier.fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
            for(skinDate in skinDates){
                Column(Modifier.padding(horizontal = ExtraSmallPadding)){
                    Text(
                        text = skinDate.weekDay,
                        fontSize = 8.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )

                    Spacer(modifier = Modifier.height(ExtraSmallPadding2))

                    Text(
                        text = skinDate.monthDay,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                    )
                }
            }
        }
}

@Composable
@Preview
fun SkinCalenderViewPreview(){
    SkinCalenderView()
}