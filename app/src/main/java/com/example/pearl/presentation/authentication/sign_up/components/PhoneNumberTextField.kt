package com.example.pearl.presentation.authentication.sign_up.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pearl.presentation.authentication.AuthEvent
import com.example.pearl.presentation.authentication.AuthState
import com.simon.xmaterialccp.component.MaterialCountryCodePicker
import com.simon.xmaterialccp.data.ccpDefaultColors
import com.simon.xmaterialccp.data.utils.getDefaultLangCode
import com.simon.xmaterialccp.data.utils.getLibCountries

@Composable
fun PhoneNumberTextField(
    authState : AuthState,
    authEvent: (AuthEvent) -> Unit
) {

    val context = LocalContext.current
    val defaultLang by rememberSaveable{ mutableStateOf(getDefaultLangCode(context)) }

    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .fillMaxWidth()
    ) {

        MaterialCountryCodePicker(
            pickedCountry = {
               authEvent(AuthEvent.UpdatePhoneCodeDefaultLang(it))
            },
            defaultCountry = getLibCountries().single { it.countryCode == defaultLang  },
            error = !authState.isValidPhone,
            text = authState.phoneNo,
            onValueChange = { authEvent(AuthEvent.UpdatePhoneNumber(it)) },
            searchFieldPlaceHolderTextStyle = MaterialTheme.typography.bodyMedium,
            searchFieldTextStyle = MaterialTheme.typography.bodyMedium,
            phonenumbertextstyle =  MaterialTheme.typography.bodyMedium,
            countrytextstyle =  MaterialTheme.typography.bodyMedium,
            countrycodetextstyle =  MaterialTheme.typography.bodyMedium,
            showErrorText = true,
            showCountryCodeInDIalog = true,
            showDropDownAfterFlag = true,
            textFieldShapeCornerRadiusInPercentage = 40,
            searchFieldShapeCornerRadiusInPercentage = 40,
            appbartitleStyle = MaterialTheme.typography.titleLarge,
            countryItemBgShape = RoundedCornerShape(5.dp),
            showCountryFlag = true,
            showCountryCode = true,
            isEnabled = true,
            colors  = ccpDefaultColors(
                primaryColor =MaterialTheme.colorScheme.primary,
                errorColor =MaterialTheme.colorScheme.error,
                backgroundColor =MaterialTheme.colorScheme.background,
                surfaceColor =MaterialTheme.colorScheme.surface,
                outlineColor =MaterialTheme.colorScheme.outline,
                disabledOutlineColor =MaterialTheme.colorScheme.outline.copy(0.1f),
                unfocusedOutlineColor =MaterialTheme.colorScheme.onBackground.copy(0.3f),
                textColor =MaterialTheme.colorScheme.onBackground.copy(0.7f),
                cursorColor =MaterialTheme.colorScheme.primary,
                topAppBarColor =MaterialTheme.colorScheme.surface,
                countryItemBgColor =MaterialTheme.colorScheme.surface,
                searchFieldBgColor =MaterialTheme.colorScheme.surface,
                dialogNavIconColor =MaterialTheme.colorScheme.onBackground.copy(0.7f),
                dropDownIconTint =MaterialTheme.colorScheme.onBackground.copy(0.7f)

            )
        )
    }
}



@Preview
@Composable
fun PhoneNumberTextFieldPreview() {
//    PhoneNumberTextField()
}
