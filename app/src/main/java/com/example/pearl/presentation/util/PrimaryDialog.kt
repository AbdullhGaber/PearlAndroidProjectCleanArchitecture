package com.example.pearl.presentation.util

import android.os.Build.VERSION.SDK_INT
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.example.pearl.R
import com.example.pearl.presentation.common.PrimaryButton
import com.example.pearl.presentation.settings.SettingsEvent


@Composable
fun PrimaryDialog(
    icon : @Composable () -> Unit,
    title: String,
    message: String,
    onDismiss: () -> Unit,
){

    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            Box(Modifier.fillMaxWidth()){
                PrimaryButton(
                    text = "Continue",
                    onClick = { onDismiss() },
                    modifier = Modifier.align(
                        Alignment.Center
                    )
                )
            }
        },
        titleContentColor = Color.Black,
        textContentColor = Color.Black,
        icon = icon,
        title = {
            Text(text = title , fontWeight = FontWeight.Bold , textAlign = TextAlign.Center)
        },
        text = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                Text(text = message , fontSize = 10.sp)
            }
        }
    )
}

@Composable
@Preview
fun PreviewPrimaryDialog(){
//    val imageLoader = ImageLoader.Builder(LocalContext.current)
//        .components {
//            if ( SDK_INT >= 28 ) {
//                add(ImageDecoderDecoder.Factory())
//            } else {
//                add(GifDecoder.Factory())
//            }
//        }.build()
//
//    PrimaryDialog(
//        icon = {
//            Box(Modifier.fillMaxWidth()){
//                AsyncImage(
//                    model = ImageRequest.Builder(LocalContext.current)
//                        .data(R.drawable.success_gif)  // Replace with your drawable GIF resource
//                        .size(Size.ORIGINAL)  // Use the original size of the GIF
//                        .build(),
//                    imageLoader = imageLoader,
//                    contentDescription = "Your GIF",
//                    modifier = Modifier.size(150.dp).align(Alignment.Center)
//                )
//            }
//        },
//        title = "Welcome To Pearl !",
//        message = "Your account has been created successfully,\nthe first step of your healthy skin journey",
//        onDismiss = {}
//    )

    PrimaryDialog(
        icon = {
            Image(
                painter = painterResource(id = R.drawable.done_successfully),
                contentDescription = null
            )
        },
        title ="Password updated successfully",
        message = "Keep it in somewhere safe",
        onDismiss = {

        }
    )
}