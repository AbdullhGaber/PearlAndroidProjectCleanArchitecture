package com.example.pearl.presentation.pearl_navigator.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R


@Composable
fun PearlBottomNavigation(
    navMenuItems : List<BottomNavigationItem>,
    selected : Int,
    onItemClick : (Int) -> Unit
){
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp , vertical = 15.dp)
            .clip(RoundedCornerShape(30.dp)),
        containerColor = colorResource(id = R.color.grey),
        tonalElevation = 10.dp,
    ){
        navMenuItems.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selected == index,
                onClick = {
                    onItemClick(index)
                },
                icon = {
                    Column(horizontalAlignment = CenterHorizontally){
                        Icon(
                            painter = painterResource(id = if(index == selected) bottomNavigationItem.filledIcon else bottomNavigationItem.unfilledIcon),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Text(
                            text = bottomNavigationItem.text ,
                            fontSize = 12.sp,
                            fontWeight = if(index == selected) FontWeight.Bold else FontWeight.Normal
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedTextColor = Color.Black,
                    selectedIconColor = Color.Black,
                    unselectedIconColor = Color.Black,
                    unselectedTextColor = Color.Black,
                    indicatorColor = colorResource(id = R.color.grey)
                )
            )
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigation(){
    PearlBottomNavigation(
        navigationItems,
        0,
        {}
    )
}
data class BottomNavigationItem(
    @DrawableRes val unfilledIcon : Int,
    @DrawableRes val filledIcon : Int,
    val text : String
)

val navigationItems = listOf(
    BottomNavigationItem(
        unfilledIcon = R.drawable.unfilled_side_menu_home,
        filledIcon = R.drawable.filled_side_menu_home,
        text = "Home"
    ),
    BottomNavigationItem(
        unfilledIcon = R.drawable.unfilled_bottom_nav_progress_icon_,
        filledIcon = R.drawable.filled_bottom_nav_progress_icon_,
        text = "Progress"
    ),
    BottomNavigationItem(
        unfilledIcon = R.drawable.unfilled_bottom_nav_products_icon_,
        filledIcon = R.drawable.filled_bottom_nav_products_icon_,
        text = "Products"
    ),
    BottomNavigationItem(
        unfilledIcon = R.drawable.unfilled_bottom_nav_routine_icon_,
        filledIcon = R.drawable.filled_bottom_nav_routine_icon_,
        text = "Routine"
    ),
    BottomNavigationItem(
        unfilledIcon = R.drawable.unfilled_bottom_nav_community_icon_,
        filledIcon = R.drawable.filled_bottom_nav_community_icon_,
        text = "Community"
    ),
)