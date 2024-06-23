package com.example.pearl.presentation.profile

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.BottomEnd
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.domain.model.User
import com.example.pearl.domain.model.UserGender
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.common.PrimaryTextField
import com.example.pearl.presentation.common.RadioButtonWithLabel
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.PrimaryDialog

@Composable
fun ProfileScreen(
    profileScreenState: ProfileScreenState,
    profileEvents: (ProfileEvents) -> Unit,
    navigateToPrevious : () -> Unit
){
    val scrollState = rememberScrollState()

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White)
        .verticalScroll(scrollState)
    ){
        if(profileScreenState.showErrorDialog){
            ErrorDialog(
                title = profileScreenState.errorMessage?.message!!,
                message = "Try again",
                onDismiss = {
                    profileEvents(ProfileEvents.HideErrorDialog)
                    profileEvents(ProfileEvents.UpdateErrorMessage(null))
                }
            )
        }

        if (profileScreenState.showSuccessDialog){
            PrimaryDialog(
                icon = {
                    Image(
                        painter = painterResource(id = R.drawable.done_successfully),
                        contentDescription = null
                    )
                },
                title ="Profile updated successfully",
                message = "Keep it in somewhere safe",
                onDismiss = {
                    profileEvents(ProfileEvents.HideSuccessDialog)
                }
            )
        }
        Column(modifier = Modifier.padding(20.dp)){
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = null,
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .clickable { navigateToPrevious() },
                    contentScale = ContentScale.FillBounds
                )

                Text(
                    text = "Profile",
                    fontSize = 18.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF000000),
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }

            Spacer(modifier = Modifier.height(36.dp))

            Box(
                modifier = Modifier.align(CenterHorizontally)
            ){
                Image(
                    painter = painterResource(id = R.drawable.profile_image),
                    contentDescription = null,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(120.dp)
                        .align(Center),
                    contentScale = ContentScale.FillWidth
                )

                Image(
                    painter = painterResource(id = R.drawable.edit_profile_icon),
                    contentDescription = null,
                    modifier = Modifier
                        .align(BottomEnd)
                        .clickable { }
                )
            }

            Spacer(modifier = Modifier.height(19.dp))

            Text(text = "Name" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(
                onValueChange = {
                      profileEvents(ProfileEvents.UpdateNameField(it))
                },
                value = profileScreenState.name,
                placeholder = profileScreenState.user.name,
                enabled = true,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Phone Number" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(
                placeholder = profileScreenState.user.phoneNo,
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Email" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(
                placeholder = profileScreenState.user.email,
                enabled = false,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Gender" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.padding(vertical = 16.dp)
            ){
                RadioButtonWithLabel(
                    label = "Male",
                    selected = UserGender.MALE == profileScreenState.gender,
                    onClick = {
                        profileEvents(ProfileEvents.UpdateGenderField(UserGender.MALE))
                    }
                )

                RadioButtonWithLabel(
                    label = "Female",
                    selected = UserGender.FEMALE == profileScreenState.gender,
                    onClick = {
                        profileEvents(ProfileEvents.UpdateGenderField(UserGender.FEMALE))
                    }
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "Age" , fontSize = 14.sp , fontWeight = FontWeight.Medium)
            Spacer(modifier = Modifier.height(8.dp))
            PrimaryTextField(
                onValueChange = {
                    profileEvents(ProfileEvents.UpdateAgeField(it))
                },
                placeholder = profileScreenState.user.age,
                value = profileScreenState.age,
                enabled = true,
                modifier = Modifier.fillMaxWidth(),
            )

            Spacer(modifier = Modifier.height(16.dp))

            PrimaryButton(
                modifier = Modifier.fillMaxWidth(),
                text ="Update Profile",
                onClick = {
                    val user = User(
                        name = profileScreenState.name,
                        age = profileScreenState.age,
                        gender = profileScreenState.gender,
                    )

                    profileEvents(ProfileEvents.UpdateProfile(user))
                }
            )
        }
    }
}

@Composable
@Preview
fun PreviewProfileScreen(){
    ProfileScreen(ProfileScreenState() ,{} , {})
}