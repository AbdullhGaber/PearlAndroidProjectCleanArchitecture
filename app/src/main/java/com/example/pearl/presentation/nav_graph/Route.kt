package com.example.pearl.presentation.nav_graph

sealed class Route(val route : String){
    object AppStartNavigation : Route("appStartNavigation")
    object IntroductionScreen : Route("introductionScreen")
    object OnBoardingScreen : Route("onBoardingScreen")
    object AuthNavigation : Route("authNav")
    object SignInScreen : Route("signInScreen")
    object SignUpScreen : Route("signUpScreen")
    object ForgotPasswordByEmailScreen : Route("forgotPasswordByEmailScreen")
    object ForgotPasswordByPhoneScreen : Route("forgotPasswordByPhoneScreen")
    object ChangePasswordScreen : Route("changePasswordScreen")
    object OTPScreen : Route("otpScreen")
    object QuizScreen : Route("quizScreen")
    object QuizEndingNavigation : Route("quizEndingNavigation")
    object FirstQuizEndingScreen : Route("firstQuizEndingScreen")
    object LastQuizEndingScreen : Route("lastQuizEndingScreen")
    object PearlNavigation : Route("pearlNavigation")
    object HomeNavigation : Route("homeNavigation")
    object HomeScreen : Route("homeScreen")
    object ProgressScreen : Route("progressScreen")
    object ProductsScreen : Route("productsScreen")
    object RecommendedProductsScreen : Route("recommendedProductsScreen")
    object AllRecommendedProductCategoryScreen : Route("allRecommendedProductCategoryScreen")
    object AllProductCategoryScreen : Route("allProductCategoryScreen")
    object NearestDermatologistsScreen : Route("nearestDermatologistsScreen")
    object DermatologistDetailsScreen : Route("dermatologistDetailsScreen")
    object ProductDetailsScreen : Route("productDetailsScreen")
    object RoutineNavigation : Route("routineNavigation")
    object RoutineScreen : Route("routineScreen")
    object RoutineDetailsScreen : Route("routineDetailsScreen")
    object NutritionRoutineScreen : Route("nutritionRoutineScreen")
    object StickAvoidRoutineScreen : Route("stickAvoidRoutineScreen")
    object RecipesScreen : Route("recipesScreen")
    object RecipesDetailsScreen : Route("recipesDetailsScreen")
    object CommunityScreen : Route("communityScreen")
    object PaymentNavigation : Route("paymentNavigation")
    object BookAppointmentScreen : Route("bookAppointmentScreen")
    object PaymentMethodScreen : Route("paymentMethodScreen")
    object PaymentSuccessScreen : Route("paymentSuccessScreen")
    object ReviewSummaryScreen : Route("reviewSummaryScreen")
    object MyAppointmentScreen : Route("myAppointmentScreen")
    object NotificationScreen : Route("notificationScreen")
    object ProfileScreen : Route("profileScreen")
    object MySkinScreen : Route("mySkinScreen")
    object MyAppointmentsScreen : Route("myAppointmentsScreen")
    object FavoritesScreen : Route("favoritesScreen")
    object PrivacyPolicyScreen : Route("privacyPolicyScreen")
    object SettingsNavigation : Route("settingsNavigation")
    object SettingsScreen : Route("settingsScreen")
    object PasswordManagerScreen : Route("passwordManagerScreen")
    object HelpCenterScreen : Route("helpCenterScreen")
    object DeleteAccountScreen : Route("deleteAccountScreen")
    object QrCodeScreen : Route("qrCodeScreen")
}


val bottomNavRoutes = listOf(
    Route.HomeScreen.route,
    Route.ProgressScreen.route,
    Route.ProductsScreen.route,
    Route.RoutineScreen.route,
    Route.CommunityScreen.route
)