package com.example.pearl.presentation.products.components

import androidx.compose.animation.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.pearl.presentation.products.ProductDropdownMenuData
import com.example.pearl.presentation.products.productDropdownMenuData

@Composable
fun CollapsingDropdownMenu(
    productDropdownMenuData: ProductDropdownMenuData
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
                    painter = painterResource(id = productDropdownMenuData.icon),
                    contentDescription = null
                )

                Spacer(modifier = Modifier.width(ExtraSmallPadding2))

                Text(
                    text = productDropdownMenuData.title,
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
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                productDropdownMenuData.content()
            }
        }
    }
}

@Preview
@Composable
fun PreviewCollapsingDropdownMenu() {
    CollapsingDropdownMenu(productDropdownMenuData[0])
}
