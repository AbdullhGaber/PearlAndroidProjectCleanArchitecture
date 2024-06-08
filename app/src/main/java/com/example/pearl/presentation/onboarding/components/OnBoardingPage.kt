package com.example.pearl.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.newsapp.presentation.Dimens.ExtraPadding3
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.onboarding.Page
import com.example.newsapp.presentation.Dimens.MediumPadding2
import com.example.pearl.presentation.onboarding.pages

@Composable
fun OnBoardingPage(
    modifier: Modifier = Modifier,
    page : Page
){
    Column(
        modifier = modifier.padding(top = ExtraPadding3),
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(id = page.personImage),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth(),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.displaySmall.copy(fontWeight = FontWeight.Bold),
            color = if(page == pages[2]) Color.White else Color.Black
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        Text(
            modifier = Modifier.padding(horizontal = MediumPadding2),
            text = page.text,
            style = MaterialTheme.typography.bodyMedium,
            color = if(page == pages[2]) Color.White else Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnBoardingPagePreview() {
    OnBoardingPage(page = pages[1])
}