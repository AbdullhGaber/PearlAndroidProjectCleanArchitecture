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
import androidx.compose.runtime.rememberCoroutineScope
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
import com.example.pearl.domain.model.Routine
import com.example.pearl.presentation.common.PearlSwitch
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.products.productTypes
import com.example.pearl.presentation.routines.components.AddRoutineSection
import com.example.pearl.presentation.routines.components.RoutineProductsModalSheet
import com.example.pearl.presentation.util.ConfirmDeleteMessageDialog
import com.example.pearl.presentation.util.ErrorDialog
import com.example.pearl.presentation.util.PrimaryDialog
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

typealias RoutineEventFunction = (RoutineEvents) -> Unit
@Composable
fun RoutineDetailsScreen(
    routineDetailsState: RoutineDetailsState,
    routineEvents: RoutineEventFunction,
    navigateToPrevious : () -> Unit,
    navigateToScreen : (String) -> Unit
){
    if(routineDetailsState.isFailureDialogShown){
        ErrorDialog(
            title = routineDetailsState.errorMessage,
            message ="Try again",
            onDismiss = {
                routineEvents(RoutineEvents.HideFailureDialog)
            }
        )
    }

    if(routineDetailsState.isDeleteConfirmDialogShown){
        ConfirmDeleteMessageDialog(
            onConfirm = {
                routineEvents(RoutineEvents.RemoveRoutine(routineDetailsState.routineIdToDelete))
            },
            onDismiss = {
                routineEvents(RoutineEvents.HideConfirmDeleteDialog)
            },

            message = "Are you sure you want to remove this product from your routine?"
        )
    }

    if(routineDetailsState.isSuccessDialogShown){
        PrimaryDialog(
            icon = {
                 Box(Modifier.fillMaxWidth()){
                     Image(
                         painter = painterResource(id = R.drawable.done_successfully),
                         contentDescription = null,
                         modifier = Modifier.align(Alignment.Center)
                     )
                 }
            },
            title = "Product has been added to your routine",
            message = "Don't miss to read the instructions and how to use the product.",
            onDismiss = {
                routineEvents(RoutineEvents.HideSuccessDialog)
            }
        )
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
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(20.dp)
                    .fillMaxWidth()) {
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
                                RoutineEvents.SwitchRoutineTime(
                                    routineDetailsState.startPosRoutineTime,
                                    RoutineTimePositions.START
                                )
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
                                RoutineEvents.SwitchRoutineTime(
                                    routineDetailsState.endPosRoutineTime,
                                    RoutineTimePositions.END
                                )
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
                        val routines = routineDetailsState.routines

                        val routine = routines.singleOrNull{
                            it.product.productType.name == productType.name
                                    && it.time == getRoutineTimeByString(routineDetailsState.centerPosRoutineTime.title)
                        }

                        Text(
                            text = productType.name,
                            fontSize = 12.sp,
                            fontWeight = FontWeight(600),
                            color = Color(0xFF000000),
                        )

                        Spacer(modifier = Modifier.height(ExtraSmallPadding))

                        AddRoutineSection(
                            onAddClick = {
                                if(routine == null){
                                    routineEvents(RoutineEvents.ShowBottomSheet)
                                }
                            },

                            onDeleteClick = {
                                if(routine != null){
                                    routineEvents(RoutineEvents.ShowConfirmDeleteDialog)
                                    routineEvents(RoutineEvents.SelectRoutineID(routine.id))
                                }
                            },

                            routine = routine
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

                        if(routineDetailsState.isSheetShown){
                            RoutineProductsModalSheet(
                                onDismissRequest = {
                                    routineEvents(RoutineEvents.HideBottomSheet)
                                    routineEvents(RoutineEvents.ObserveRoutineList)
                                },
                                navigateToProductDetailsScreen = { productName ->
                                    navigateToScreen("${Route.ProductDetailsScreen.route}/$productName")
                                },
                                onAddToRouteButtonClick = {
                                    routineEvents(RoutineEvents.AddProductToRoutine(
                                        it,
                                        routineDetailsState.centerPosRoutineTime.title
                                    ))
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
    RoutineDetailsScreen(RoutineDetailsState() ,{} , {} , {})
}