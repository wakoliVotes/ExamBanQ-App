package com.example.exambank.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.exambank.presentation.dashboardviews.HomeDashboard
import com.example.exambank.viewscreens.*

@Composable
fun BottomNavGraph(navController: NavHostController) {
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route = BottomBarScreen.Home.route){
            HomeDashboard()
        }
        composable(route = BottomBarScreen.Settings.route){
            SettingsView()
        }
        composable(route = BottomBarScreen.Explore.route){
            ExploreView()
        }

        composable(route = BottomBarScreen.Notifications.route){
            NotificationView()
        }

        composable(route = BottomBarScreen.Profile.route){
            ProfileView()
        }
    }

}