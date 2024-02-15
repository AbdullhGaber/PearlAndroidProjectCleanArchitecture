package com.example.pearl.presentation.sign_in.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsapp.presentation.Dimens.MediumPadding1


@Composable
fun CenteredTextBetweenTwoLines(
    text : String
) {
    val lineColor = Color.Gray
    val lineHeight = 1.dp // Adjust height as needed
    val spaceWidth = 16.dp // Adjust space width

    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(horizontal = MediumPadding1),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Left line with space
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(lineHeight)
                    .width(spaceWidth)
                    .background(color = lineColor)
            )

            // Centered text
            Text(
                text = text,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = spaceWidth),
                // Add other text styling here if needed
            )

            // Right line with space
            Spacer(
                modifier = Modifier
                    .weight(1f)
                    .height(lineHeight)
                    .width(spaceWidth)
                    .background(color = lineColor)
            )
        }
    }
}

@Preview
@Composable
fun TextBetweenLinesPreview() {
    CenteredTextBetweenTwoLines("Or continue with")
}
