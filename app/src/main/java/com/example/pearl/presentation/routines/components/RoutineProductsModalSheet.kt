package com.example.pearl.presentation.routines.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.presentation.common.FeaturedProductCard
import com.example.pearl.presentation.home.recommendedProducts
import com.example.pearl.presentation.products.ProductType
import com.example.pearl.presentation.products.featuredProducts
import com.example.pearl.presentation.products.productTypes

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoutineProductsModalSheet(
    onDismissRequest : () -> Unit
){
    val modalSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismissRequest() },
        sheetState = modalSheetState,
        modifier = Modifier.height(650.dp),
        shape = RoundedCornerShape(10.dp),
        containerColor = Color.White
    ) {
        val state = rememberLazyStaggeredGridState()
        Text(
            text = "Recommended Products",
            fontSize = 12.sp,
            fontWeight = FontWeight(600),
            modifier = Modifier.align(CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(MediumPadding1))

        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .padding(horizontal = MediumPadding1)
                .height(650.dp),
            state = state,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            content = {
                items(featuredProducts.size) {
                    FeaturedProductCard(featuredProduct = featuredProducts[it])
                }
            }
        )
    }
}


@Composable
@Preview
fun RoutineProductsModalSheetPreview(){
    RoutineProductsModalSheet({})
}