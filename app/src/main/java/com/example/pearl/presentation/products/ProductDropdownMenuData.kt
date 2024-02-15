package com.example.pearl.presentation.products

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R

data class ProductDropdownMenuData(
    @DrawableRes  val icon : Int,
    val title : String ,
    val content : @Composable () -> Unit
)



val productDropdownMenuData = listOf(
    ProductDropdownMenuData(
        icon = R.drawable.mingcute_question_fill,
        title = "How to use",
        content = {
            Text(
                text = "1. Wet Your Face:\n.",
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF7F7F7F)
                )

            Text(
                text = "\t \u2022 Begin by splashing your face with lukewarm water to prepare your skin for cleansing.",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "2. Apply Cleanser:\n",
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF7F7F7F)
                )

            Text(
                text = "\t \u2022 Gently massage the cleanser onto your damp face using circular motions. Avoid the eye area.",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "3. Rinse Thoroughly:\n",
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF7F7F7F)
                )

            Text(
                text = "\t \u2022 After cleansing, rinse your face with lukewarm water to remove all traces of the cleanser.",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "4. Pat Dry:\n",
                fontSize = 10.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF7F7F7F)
                )

            Text(
                text = "\t \u2022 Gently pat your face dry with a clean, soft towel. Avoid rubbing, as it can be harsh on the skin.",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))


        }
    ),

    ProductDropdownMenuData(
        icon = R.drawable.warning,
        title = "Warnings",
        content = {
            Text(
                text = "\t \u2022 Before using on the face, apply a small amount to a discreet area of skin to check for any adverse reactions or irritation.",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(Modifier.height(ExtraSmallPadding2))

            Text(
                text = "\t \u2022 This product may increase your skin's sensitivity to the sun. Apply sunscreen when going outdoors. ",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )
        }
    ),

    ProductDropdownMenuData(
        icon = R.drawable.good_ingr_icon,
        title = "Good Ingredients",
        content = {

            Text(
                text = "Good For Combinational skin",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000)
            )

            Spacer(Modifier.height(ExtraSmallPadding2))

            Text(
                text = "Glycerin",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Hyaluronic Acid",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Niacinamide",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Good For Dry skin",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Niacinamide",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Glycerin",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Anti-Acne",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding))

            Text(
                text = "Niacinamide",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Phytosphingosine",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

        }
    ),

    ProductDropdownMenuData(
        icon = R.drawable.bad_ingr_icon,
        title = "Bad Ingredients",
        content = {

            Text(
                text = "Fragrance",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000)
            )

            Spacer(Modifier.height(ExtraSmallPadding2))

            Text(
                text = "Propylparaben",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )


            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Paraben",
                fontSize = 12.sp,
                fontWeight = FontWeight(500),
                color = Color(0xFF000000)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Text(
                text = "Methylparaben",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = "Propylparaben",
                fontSize = 10.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF7F7F7F)
            )


        }
    )
)

