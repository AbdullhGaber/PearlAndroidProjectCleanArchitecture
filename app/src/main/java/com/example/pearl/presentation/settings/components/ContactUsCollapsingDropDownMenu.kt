package com.example.pearl.presentation.settings.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.pearl.presentation.settings.CollapsingMenuData
import com.example.pearl.presentation.settings.collapsingMenuDataList

@Composable
fun ContactUsCollapsingDropDownMenu(
    collapsingMenuData: ContactUsCollapsingMenuData
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = !expanded },
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row{
                Image(
                    painter = painterResource(id = collapsingMenuData.icon),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(Dimens.ExtraSmallPadding2))

                Text(
                    text = collapsingMenuData.title,
                    fontSize = 12.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF000000),
                )
            }

            Icon(
                imageVector = if(expanded) Icons.Default.KeyboardArrowUp else Icons.Default.ArrowDropDown,
                contentDescription = "Dropdown Arrow"
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        AnimatedVisibility(
            visible = expanded,
            enter = expandVertically() + fadeIn(),
            exit = shrinkVertically() + fadeOut(),
            modifier = Modifier.animateContentSize()
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    text = "",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color(0xFF7F7F7F)
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewContactUsCollapsingDropDownMenu() {
    ContactUsCollapsingDropDownMenu(
        contactUsCollapsingMenuDataList[0]
    )
}
