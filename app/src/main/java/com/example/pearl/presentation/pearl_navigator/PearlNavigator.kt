package com.example.pearl.presentation.pearl_navigator


import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.pearl.presentation.common.getBottomNavigationScreenRouteByIndex
import com.example.pearl.presentation.community.CommunityScreen
import com.example.pearl.presentation.favorites.FavoritesScreen
import com.example.pearl.presentation.home.HomeScreen
import com.example.pearl.presentation.home.HomeViewModel
import com.example.pearl.presentation.my_appointments.MyAppointmentsScreen
import com.example.pearl.presentation.my_skin.MySkinScreen
import com.example.pearl.presentation.pearl_navigator.component.PearlBottomNavigation
import com.example.pearl.presentation.pearl_navigator.component.navigationItems
import com.example.pearl.presentation.privacy_policy.PrivacyPolicy
import com.example.pearl.presentation.products.ProductsScreen
import com.example.pearl.presentation.qr_code.QrCodeScreen
import com.example.pearl.presentation.routines.RoutineScreen
import com.example.pearl.presentation.settings.SettingsScreen
import com.example.pearl.presentation.skin_progress.SkinProgressScreen
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Normal
import androidx.compose.ui.text.font.FontWeight.Companion.SemiBold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pearl.R
import com.example.pearl.presentation.authentication.AuthViewModel
import com.example.pearl.presentation.avoid_stick_routines.StickAvoidRoutineScreen
import com.example.pearl.presentation.book_appointment.BookAppointmentScreen
import com.example.pearl.presentation.book_appointment.MyAppointmentScreen
import com.example.pearl.presentation.common.HorizontalLine
import com.example.pearl.presentation.common.getDrawerNavigationScreenRouteByIndex
import com.example.pearl.presentation.common.getProductTypeFromString
import com.example.pearl.presentation.dermatologists.DermatologistDetailsScreen
import com.example.pearl.presentation.dermatologists.NearestDermatologistsScreen
import com.example.pearl.presentation.home.doctors
import com.example.pearl.presentation.home.sideMenuItems
import com.example.pearl.presentation.nav_graph.Route
import com.example.pearl.presentation.nav_graph.bottomNavRoutes
import com.example.pearl.presentation.nav_graph.navigateToPreviousTab
import com.example.pearl.presentation.notification.NotificationScreen
import com.example.pearl.presentation.products.AllProductCategoryScreen
import com.example.pearl.presentation.products.AllRecommendedProductCategoryScreen
import com.example.pearl.presentation.products.ProductDetailsScreen
import com.example.pearl.presentation.products.RecommendedProductsScreen
import com.example.pearl.presentation.products.featuredProducts
import com.example.pearl.presentation.nutrition_routine.NutritionRoutineScreen
import com.example.pearl.presentation.payments.PaymentMethodScreen
import com.example.pearl.presentation.payments.PaymentSuccessScreen
import com.example.pearl.presentation.payments.ReviewSummaryScreen
import com.example.pearl.presentation.profile.ProfileScreen
import com.example.pearl.presentation.recipes.RecipesDetailsScreen
import com.example.pearl.presentation.recipes.RecipesScreen
import com.example.pearl.presentation.recipes.recipesList
import com.example.pearl.presentation.routines.RoutineDetailsScreen
import com.example.pearl.presentation.routines.RoutineViewModel
import com.example.pearl.presentation.settings.DeleteAccountScreen
import com.example.pearl.presentation.settings.HelpCenterScreen
import com.example.pearl.presentation.settings.PasswordManagerScreen
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

typealias PearlNavEventFunction = (PearlNavigatorEvents) -> Unit
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun PearlNavigator(
    pearlNavState: PearlNavState,
    pearlNavEvent : PearlNavEventFunction
){

    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet{
                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(NavigationDrawerItemDefaults.ItemPadding)
                        .clickable {
                            runBlocking {
                                drawerState.close()
                            }
                            pearlNavEvent(
                                PearlNavigatorEvents.NavigateTo(
                                    Route.ProfileScreen.route,
                                    navController
                                )
                            )
                        }
                ){
                    Image(
                        painter = painterResource(id = R.drawable.profile_image),
                        contentDescription = null,
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(40.dp),
                        contentScale = ContentScale.FillBounds
                    )

                    Spacer(Modifier.width(12.dp))

                    Column{

                        Text("Salem Ahmed" , fontSize = 14.sp , fontWeight = SemiBold)

                        Spacer(Modifier.height(10.dp))

                        Row(verticalAlignment = Alignment.CenterVertically){

                            Image(
                                painter = painterResource(id = R.drawable.profile_edit_sidebar),
                                contentDescription = null,
                                modifier = Modifier.size(10.dp),
                                contentScale = ContentScale.FillBounds
                            )

                            Spacer(modifier = Modifier.width(4.dp))

                            Text(
                                "Edit Profile",
                                fontSize = 8.sp,
                                fontWeight = Normal,
                                color = Color(0xFF7E7E7E)
                            )
                        }
                    }
                }

                Spacer(Modifier.height(55.dp))

                sideMenuItems.forEachIndexed{
                        index, sideMenuItem ->
                    NavigationDrawerItem(
                        label = {
                            Text(
                                text = sideMenuItem.name,
                                fontSize = 14.sp,
                                fontWeight = SemiBold,
                                color = if(pearlNavState.currentBottomNavItemIndex == index) Color(0xFF6767F7) else Color(0xFF000000)
                            )
                        },
                        selected = pearlNavState.currentBottomNavItemIndex == index,
                        onClick = {
                            pearlNavEvent(PearlNavigatorEvents.UpdateSideNavItemIndex(index))
                            coroutineScope.launch {
                                drawerState.close()
                            }

                            val route = getDrawerNavigationScreenRouteByIndex(index)

                            if(route == Route.CommunityScreen.route) {
                                pearlNavEvent(PearlNavigatorEvents.UpdateBottomNavItemIndex(4))
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(route,navController))
                            }else{
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(route,navController))
                            }
                        },
                        icon = {
                            val selected = pearlNavState.currentBottomNavItemIndex == index

                            if(!selected){
                                Image(
                                    painter = painterResource(id = sideMenuItem.unSelectedIcon ),
                                    contentDescription = null
                                )
                            }

                            if(selected && sideMenuItem.selectedIcon != null){
                                Image(
                                    painter = painterResource(id = sideMenuItem.selectedIcon ),
                                    contentDescription = null
                                )
                            }

                        },
                        modifier = Modifier.padding(NavigationDrawerItemDefaults.ItemPadding)
                    )
                    if(index == 1 ){
                        Spacer(Modifier.height(44.dp))
                        HorizontalLine()
                    }
                }

            }
        },
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen
    ){
        Scaffold(
            topBar = {
                if(pearlNavState.showTopBar){
                    Row(horizontalArrangement = Arrangement.SpaceBetween , modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_menu_24),
                            contentDescription = null,
                            modifier = Modifier.clickable{
                                coroutineScope.launch {
                                    drawerState.open()
                                }
                            }
                        )

                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_notifications_none_24),
                            contentDescription = null
                        )
                    }
                }
            },
            bottomBar = {
                if(pearlNavState.showBottomNav){
                    PearlBottomNavigation(navMenuItems = navigationItems, selected = pearlNavState.currentBottomNavItemIndex) {
                        pearlNavEvent(PearlNavigatorEvents.UpdateBottomNavItemIndex(it))

                        val route = getBottomNavigationScreenRouteByIndex(it)

                        pearlNavEvent(PearlNavigatorEvents.NavigateTo(route , navController))
                    }
                }
            }
        ){ paddingValues ->

            BackHandler {
                val targetRoute = getBottomNavigationScreenRouteByIndex(pearlNavState.prevNavItemIndex)

                if(bottomNavRoutes.contains(targetRoute)){
                    pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousBottomTab(navController))
                }else{
                    pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                }
            }

            val bottomPadding = paddingValues.calculateBottomPadding()
            val routineViewModel : RoutineViewModel = hiltViewModel()
            val homeViewModel : HomeViewModel = hiltViewModel()
            NavHost(
                navController = navController ,
                startDestination = Route.HomeNavigation.route,
                modifier = Modifier.padding(bottom = bottomPadding)
            ){
                navigation(route = Route.HomeNavigation.route ,startDestination = Route.HomeScreen.route){
                    composable(route = Route.HomeScreen.route){
                        HomeScreen(
                            navigateToScreen = {route ->
                                if(route == Route.RoutineNavigation.route){
                                    pearlNavEvent(PearlNavigatorEvents.UpdateBottomNavItemIndex(3))
                                }else if(route == Route.ProgressScreen.route){
                                    pearlNavEvent(PearlNavigatorEvents.UpdateBottomNavItemIndex(1))
                                }
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(route = route , navController = navController))
                            },
                            homeScreenState = homeViewModel.mHomeScreenState.value,
                            homeScreenEvents = homeViewModel::onEvent
                        )
                    }
                }

                composable(route = Route.ProgressScreen.route){
                    SkinProgressScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousBottomTab(navController))
                        }
                    )
                }

                composable(route = Route.ProductsScreen.route){
                    ProductsScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousBottomTab(navController))
                        },
                        navigateToScreen = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo(it,navController))
                        }
                    )
                }

                composable(Route.AllProductCategoryScreen.route+"/{productTypeName}"){
                     val productTypeName = it.arguments?.getString("productTypeName")
                     val productType = getProductTypeFromString(productTypeName!!)
                     val products = featuredProducts.filter { it.type == productType }
                     AllProductCategoryScreen(
                         productType = productType,
                         products = products,
                         navigateToProductDetailsScreen = {
                             pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.ProductDetailsScreen.route}/$it", navController))
                         }
                     )
                }
                
                composable(route = Route.ProductDetailsScreen.route+"/{productName}"){
                    val productName = it.arguments?.getString("productName")
                    val product = (featuredProducts.single { product -> product.name == productName })
                    ProductDetailsScreen(
                        product = product ,
                        navigateToProductDetailsScreen = { name ->
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.ProductDetailsScreen.route}/$name", navController))
                        },
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }

                composable(route = Route.RecommendedProductsScreen.route){
                    RecommendedProductsScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        },
                        onProductTypeButtonClick = {productType ->
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.AllRecommendedProductCategoryScreen.route}/$productType", navController))
                        },
                        navigateToProductDetailsScreen = { productName ->
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.ProductDetailsScreen.route}/$productName", navController))
                        }
                    )
                }

                composable(route = Route.AllRecommendedProductCategoryScreen.route+"/{productType}"){
                    val argument = it.arguments?.getString("productType")
                    val productType = getProductTypeFromString(argument!!)
                    AllRecommendedProductCategoryScreen(
                        productType = productType,
                        products = featuredProducts.filter { it.type == productType},
                        navigateToProductDetailsScreen = { productName ->
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.ProductDetailsScreen.route}/$productName", navController))
                        }
                    )
                }

                composable(route = Route.NearestDermatologistsScreen.route){
                    NearestDermatologistsScreen(
                        navigateToPrevious = {
                           pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }

                composable(route = Route.DermatologistDetailsScreen.route+"/{doctorName}"){
                    val argument = it.arguments?.getString("doctorName")
                    val doctor = doctors.single{ it.name == argument}
                    DermatologistDetailsScreen(
                        doctor = doctor,
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        },
                        navigateToScreen = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo(Route.PaymentNavigation.route , navController))
                        }
                    )
                }

                navigation(startDestination = Route.RoutineScreen.route , route = Route.RoutineNavigation.route){
                    composable(route = Route.RoutineScreen.route){
                        RoutineScreen(
                            navigateToPreviousTab = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousBottomTab(navController))
                            },

                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(it,navController))
                            },

                            routineDetailsState = routineViewModel.mRoutineDetailsState.value,
                            routineEvents = routineViewModel::onEvent,
                        )
                    }

                    composable(route = Route.RoutineDetailsScreen.route){
                        RoutineDetailsScreen(
                            routineDetailsState = routineViewModel.mRoutineDetailsState.value,
                            routineEvents = routineViewModel::onEvent,
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                            },

                            navigateToProductDetailsScreen = { productName ->
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo("${Route.ProductDetailsScreen.route}/$productName", navController))
                            }
                        )
                    }
                }

                composable(route = Route.NutritionRoutineScreen.route){
                    NutritionRoutineScreen(
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        },
                        navigateToScreen = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo(it,navController))
                        }
                    )
                }

                composable(route = Route.StickAvoidRoutineScreen.route){
                    StickAvoidRoutineScreen(
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }

                composable(route = Route.RecipesScreen.route){
                     RecipesScreen(
                         navigateToPrevious = {
                             pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                         },
                         navigateToScreen = {
                             pearlNavEvent(PearlNavigatorEvents.NavigateTo(it,navController))
                         }
                     )
                }

                composable(route = Route.RecipesDetailsScreen.route+"/{recipeID}"){
                    val recipeID = it.arguments?.getString("recipeID")
                    val recipe = (recipesList.single { recipe -> recipe.id == recipeID?.toInt() })
                    RecipesDetailsScreen(
                        recipesData = recipe,
                        naviagteToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }

                composable(route = Route.CommunityScreen.route){
                    CommunityScreen(
                        navigateToTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = it))
                        }
                    )
                }

                navigation(startDestination = Route.BookAppointmentScreen.route , route = Route.PaymentNavigation.route){
                    composable(route = Route.BookAppointmentScreen.route){
                        BookAppointmentScreen(
                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = Route.PaymentMethodScreen.route))
                            },

                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController = navController))
                            }
                        )
                    }

                    composable(route = Route.PaymentMethodScreen.route){
                        PaymentMethodScreen(
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController = navController))
                            },

                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = Route.PaymentSuccessScreen.route))
                            }
                        )
                    }

                    composable(route = Route.PaymentSuccessScreen.route){
                        PaymentSuccessScreen(
                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = it))
                            }
                        )
                    }

                    composable(route = Route.ReviewSummaryScreen.route){
                        ReviewSummaryScreen(
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController = navController))
                            },
                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = it))
                            }
                        )
                    }

                    composable(route = Route.MyAppointmentScreen.route){
                        MyAppointmentScreen(
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController = navController))
                            },
                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(navController = navController , route = it))
                            }
                        )
                    }
                }

                composable(route = Route.NotificationScreen.route){
                    NotificationScreen(
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }

                composable(route = Route.MySkinScreen.route){
                    MySkinScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                        }
                    )
                }

                composable(route = Route.MyAppointmentsScreen.route){
                    MyAppointmentsScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                        }
                    )
                }

                composable(route = Route.FavoritesScreen.route){
                    FavoritesScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                        },
                        navigateToScreen = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateTo(it,navController))
                        }
                    )
                }

                composable(route = Route.PrivacyPolicyScreen.route){
                    PrivacyPolicy(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                        }
                    )
                }

                navigation(route = Route.SettingsNavigation.route, startDestination = Route.SettingsScreen.route){
                    composable(route = Route.SettingsScreen.route){
                        SettingsScreen(
                            navigateToScreen = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateTo(it , navController))
                            },
                            navigateToPreviousTab = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                            }
                        )
                    }

                    composable(route = Route.HelpCenterScreen.route){
                        HelpCenterScreen(
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                            }
                        )
                    }

                    composable(route = Route.PasswordManagerScreen.route){
                        val authViewModel : AuthViewModel = hiltViewModel()
                        PasswordManagerScreen(
                            authEvent = authViewModel::onEvent,
                            authState = authViewModel.mAuthState.value,
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                            }
                        )
                    }

                    composable(route = Route.DeleteAccountScreen.route){
                        DeleteAccountScreen(
                            navigateToPrevious = {
                                pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                            }
                        )
                    }
                }

                composable(route = Route.QrCodeScreen.route){
                    QrCodeScreen(
                        navigateToPreviousTab = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPreviousSideTab(navController))
                        }
                    )
                }

                composable(route = Route.ProfileScreen.route){
                    ProfileScreen(
                        navigateToPrevious = {
                            pearlNavEvent(PearlNavigatorEvents.NavigateToPrevious(navController))
                        }
                    )
                }
            }
        }
    }
}


@Composable
@Preview
fun PreviewPearlNavigator(){
//    PearlNavigator()
}