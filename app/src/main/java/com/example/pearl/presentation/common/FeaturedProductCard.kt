package com.example.pearl.presentation.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.End
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Alignment.Companion.TopEnd
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.pearl.R
import com.example.pearl.domain.model.Product
import com.example.pearl.presentation.products.featuredProducts

@Composable
fun FeaturedProductCard(
    modifier: Modifier = Modifier,
    featuredProduct: Product,
    onCardClick : () -> Unit,
    onFavoriteClick : (Product) -> Unit

){
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .background(color = Color.White)
            .padding(10.dp)
            .height(130.dp)
            .width(80.dp)
            .clickable{
                onCardClick()
            }
    ){
        Image(
            painter = painterResource(id = if(featuredProduct.isFavorite) R.drawable.favorite_filled_heart else R.drawable.heart_favorite),
            contentDescription = null,
            modifier = Modifier.align(TopEnd)
                .size(17.dp, 15.1579.dp)
                .clickable {
                    onFavoriteClick(featuredProduct)
                }
        )
        Column(
            Modifier.padding(5.dp).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(ExtraSmallPadding))

            Image(
                painter = painterResource(id = featuredProduct.image),
                contentDescription = null,
                modifier = Modifier.size(22.dp,74.dp)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Text(
                text = featuredProduct.name,
                maxLines = 2,
                fontWeight = FontWeight(500),
                fontSize = 8.sp,
                modifier = Modifier.align(Start)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding))

            Text(
                text = featuredProduct.description,
                fontWeight = FontWeight(400),
                fontSize = 6.sp,
                color = Color(0xFF7F7F7F),
                softWrap = true,
                textAlign = TextAlign.Start,
                modifier = Modifier.align(Start)
            )

            Spacer(modifier = Modifier.height(ExtraSmallPadding))

        }
    }
}

@Composable
@Preview
fun FeaturedProductCardPreview(){
    FeaturedProductCard(featuredProduct = featuredProducts[1] , onCardClick = {} , onFavoriteClick = {})
}