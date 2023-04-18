package com.anchormiles.exambank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.anchormiles.exambank.datalayer.models.login.LoginScreen
import com.anchormiles.exambank.datalayer.models.login.LoginViewModel
import com.anchormiles.exambank.datalayer.models.login.SignUpScreen
import com.anchormiles.exambank.presentation.dashboardviews.AcademicYearView
import com.anchormiles.exambank.presentation.dashboardviews.MainScreen
import com.anchormiles.exambank.presentation.paperviews.ExamPaperView
import com.anchormiles.exambank.presentation.paperviews.ExamPaperView2019
import com.anchormiles.exambank.presentation.welcomeviews.OnBoardScreen
import com.anchormiles.exambank.presentation.welcomeviews.SplashScreen
import com.example.exambank.viewscreens.AccountView

enum class LoginRoutes {
    SignIn,
    SignUp
}



@Composable
fun Navigator (
    navController: NavHostController = rememberNavController(),
    loginViewModel : LoginViewModel,
) {
    NavHost(
        navController =  navController,
        startDestination = Routes.OnBoardScreen.route,
    ){
        composable(route = LoginRoutes.SignIn.name){
            LoginScreen(onNavToHomePage = {
            /*TODO*/
                navController.navigate(Routes.MainScreen.route){
                    launchSingleTop = true
                    popUpTo(route = LoginRoutes.SignIn.name) {
                        inclusive = true
                    }

                }
            },
                loginViewModel = loginViewModel

            ) {
                navController.navigate(LoginRoutes.SignUp.name){
                    launchSingleTop = true
                    popUpTo(LoginRoutes.SignIn.name){

                        inclusive = true
                    }
                }

            }
        }

        composable(route = LoginRoutes.SignUp.name){
            SignUpScreen(onNavToHomePage = {
            /*TODO*/
                navController.navigate(Routes.MainScreen.route){
                    popUpTo(LoginRoutes.SignUp.name){
                        inclusive = true
                    }
                }

            },
                loginViewModel = loginViewModel
            ) {
                navController.navigate(LoginRoutes.SignIn.name)
            }
        }
        composable(route = Routes.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(route = Routes.OnBoardScreen.route){
            OnBoardScreen(navController = navController)
        }
        composable(route = Routes.MainScreen.route){
            MainScreen()
        }
        composable(route = Routes.Account.route){
            AccountView(navController = navController)
        }
        composable(route = Routes.AcademicYearView.route){
            AcademicYearView(navController = navController)
        }
        composable(route = Routes.FullExamPaper.route){
            ExamPaperView()
        }
        composable(route = Routes.JanApril2017.route){
            ExamPaperView()
        }
        composable(route = Routes.MayAug2017.route){
            ExamPaperView()
        }
        composable(route = Routes.SeptDec2019.route){
            ExamPaperView2019()
        }

    }
}