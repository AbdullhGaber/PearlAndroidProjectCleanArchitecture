package com.example.pearl.presentation.settings

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pearl.R
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.nav_graph.navigateToPreviousTab
import com.example.pearl.presentation.pearl_navigator.PearlNavEventFunction
import com.example.pearl.presentation.pearl_navigator.PearlNavigatorEvents

@Composable
fun SettingsScreen(
    navigateToScreen : (String) -> Unit,
    navigateToPreviousTab : () -> Unit
){
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ){
        Column(modifier = Modifier.padding(20.dp)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clickable {
                            navigateToPreviousTab()
                        },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Settings",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(55.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable {
                        navigateToScreen(Route.HelpCenterScreen.route)
                    },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row{
                    Image(painter = painterResource(id = R.drawable.help_center), contentDescription = null)

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(text = "Help Center" , fontSize = 16.sp , fontWeight = FontWeight.Medium)
                }

                Icon(
                    painter = painterResource(id = R.drawable.ad_right_arrow),
                    tint = colorResource(id =  R.color.pearl_color),
                    modifier = Modifier.size(24.dp),
                    contentDescription = null
                )

            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { navigateToScreen(Route.PasswordManagerScreen.route) },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row{
                    Image(painter = painterResource(id = R.drawable.key_change_password), contentDescription = null)

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(text = "Password Manager" , fontSize = 16.sp , fontWeight = FontWeight.Medium)
                }

                Icon(
                    painter = painterResource(id = R.drawable.ad_right_arrow),
                    tint = colorResource(id =  R.color.purple_500),
                    modifier = Modifier.size(24.dp),
                    contentDescription = null
                )
            }

            Spacer(modifier = Modifier.height(25.dp))

            Row(
                Modifier
                    .fillMaxWidth()
                    .clickable { navigateToScreen(Route.DeleteAccountScreen.route) },
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row{
                    Image(painter = painterResource(id = R.drawable.credit_card), contentDescription = null)

                    Spacer(modifier = Modifier.width(13.dp))

                    Text(text = "Delete Account" , fontSize = 16.sp , fontWeight = FontWeight.Medium)
                }

                Icon(
                    painter = painterResource(id = R.drawable.ad_right_arrow),
                    tint = colorResource(id =  R.color.purple_500),
                    modifier = Modifier.size(24.dp),
                    contentDescription = null
                )
            }

        }
    }
}

@Composable
@Preview
fun PreviewSettingsScreen(){
    SettingsScreen({},{})
}