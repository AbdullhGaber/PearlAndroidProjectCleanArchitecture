package com.example.pearl.presentation.routines

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding
import com.example.newsapp.presentation.Dimens.ExtraSmallPadding2
import com.example.newsapp.presentation.Dimens.MediumPadding1
import com.example.pearl.R
import com.example.pearl.presentation.common.PearlSwitch
import com.example.pearl.presentation.products.productTypes
import com.example.pearl.presentation.routines.components.AddRoutineSection
import com.example.pearl.presentation.routines.components.RoutineProductsModalSheet

typealias RoutineEventFunction = (RoutineEvents) -> Unit
@Composable
fun RoutineDetailsScreen(
    routineDetailsState: RoutineDetailsState,
    routineEvents: RoutineEventFunction,
    navigateToPrevious : () -> Unit,
    navigateToProductDetailsScreen : (String) -> Unit
){
    val isSheetShown = remember {
        mutableStateOf(false)
    }
    
    Box(modifier = Modifier.fillMaxSize()){
        Box(modifier = Modifier.fillMaxSize() ){
            Image(
                painter = painterResource(id = routineDetailsState.centerPosRoutineTime.bgImage) ,
                contentDescription = null,
                modifier = Modifier.matchParentSize(),
                contentScale = ContentScale.FillBounds
            )
        }
        
        Column{
            Row(Modifier.fillMaxWidth().padding(20.dp).fillMaxWidth()) {
                Box(modifier = Modifier.fillMaxWidth()){
                    Image(
                        painter = painterResource(id = R.drawable.arrow_back),
                        contentDescription = null,
                        modifier = Modifier
                            .padding(start = 10.dp, top = 10.dp)
                            .align(Alignment.TopStart)
                            .clickable {
                                navigateToPrevious()
                            }
                    )
                }
            }

            Spacer(modifier = Modifier.height(ExtraSmallPadding2))

            Row(
                Modifier
                    .padding(horizontal = 15.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(id = routineDetailsState.startPosRoutineTime.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(0.dp)
                        .wrapContentSize()
                        .size(24.dp)
                        .clickable {
                            routineEvents(
                                RoutineEvents.SwitchRoutineTime(routineDetailsState.startPosRoutineTime , RoutineTimePositions.START)
                            )
                        }
                )

                Column(verticalArrangement = Arrangement.Center , horizontalAlignment = Alignment.CenterHorizontally){

                    Image(
                        painter = painterResource(id = routineDetailsState.centerPosRoutineTime.icon),
                        contentDescription = null,
                        modifier = Modifier.padding(top = 30.dp)
                    )

                    Spacer(modifier = Modifier.height(MediumPadding1))

                    Text(
                        text = routineDetailsState.centerPosRoutineTime.title,
                        fontSize = 20.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                }

                Image(
                    painter = painterResource(id = routineDetailsState.endPosRoutineTime.icon),
                    contentDescription = null,
                    modifier = Modifier
                        .padding(0.dp)
                        .wrapContentSize()
                        .size(24.dp)
                        .clickable {
                            routineEvents(
                                RoutineEvents.SwitchRoutineTime(routineDetailsState.endPosRoutineTime,RoutineTimePositions.END)
                            )
                        }
                )
                
            }
            
            Spacer(modifier = Modifier.height(MediumPadding1))

            val scrollState = rememberScrollState()

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .background(Color.White)
                    .verticalScroll(scrollState)
            ){
                Column(Modifier.padding(MediumPadding1)) {
                    for (productType in productTypes ){
                        Text(
                            text = productType.name,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )

                        Spacer(modifier = Modifier.height(ExtraSmallPadding))


                        AddRoutineSection(
                            onAddClick = {
                                isSheetShown.value = true
                            },

                            onDeleteClick = {

                            }
                        )

                        Spacer(modifier = Modifier.height(MediumPadding1))

                    }

                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        Text(
                            text = "Remind me to do routine",
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )

                       PearlSwitch()

                        if(isSheetShown.value){
                            RoutineProductsModalSheet(
                                onDismissRequest = {isSheetShown.value = false},
                                navigateToProductDetailsScreen = {
                                    navigateToProductDetailsScreen(it)
                                }
                            )
                        }
                    }
                }
            }
        }

    }
}

@Composable
@Preview
fun RoutineDetailsScreenPreview(){
//    RoutineDetailsScreen()
}