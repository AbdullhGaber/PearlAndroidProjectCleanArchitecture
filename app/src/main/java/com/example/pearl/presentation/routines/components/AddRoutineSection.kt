package com.example.pearl.presentation.routines.components

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
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.pearl.R
import com.example.pearl.domain.model.Routine

@Composable
fun AddRoutineSection(
    onAddClick : () -> Unit ,
    routine : Routine? = null,
    onDeleteClick : () -> Unit
){
    Box(modifier = Modifier.fillMaxWidth().background(Color.White)){
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(verticalAlignment = Alignment.CenterVertically){
                Image(
                    painter = painterResource(id = R.drawable.trash_outline),
                    contentDescription = null,
                    modifier = Modifier.clickable { onDeleteClick() }
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Box(
                    Modifier
                    .clip(RoundedCornerShape(size = 10.dp))
                    .size(57.dp)
                    .background(color = Color(0xFFF4F1FF))
                    .clickable {  }
                ){
                    Image(
                        painter = painterResource(
                            id = routine?.product?.image ?: R.drawable.plus_add_icon
                        ),
                        contentDescription = null,
                        modifier = Modifier.align(Alignment.Center).clickable { onAddClick() }
                    )
                }

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = routine?.product?.description ?: "Add a product",
                    fontSize = 10.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF7F7F7F),
                    modifier = Modifier.clickable { onAddClick() }
                )
            }
        }
    }
}

@Composable
@Preview
fun AddRoutineSectionPreview(){
    AddRoutineSection(onAddClick = {} , onDeleteClick = {})
}