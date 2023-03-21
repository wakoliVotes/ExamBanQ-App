package com.example.exambank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exambank.presentation.dashboardviews.AcademicYearView
import com.example.exambank.presentation.dashboardviews.HomeDashboard
import com.example.exambank.presentation.paperviews.ExamPaperView
import com.example.exambank.viewscreens.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeDashboard(navController = navController)
        }
        composable(route = BottomBarScreen.Papers.route){
            AcademicYearView(navController = navController)
        }
        composable(route = BottomBarScreen.Account.route){
           AccountView(navController = navController)
        }
        composable(route = Routes.AcademicYearView.route){
            AcademicYearView(navController = navController)
        }
        composable(route = Routes.FullExamPaper.route){
            ExamPaperView()
        }
    }

}