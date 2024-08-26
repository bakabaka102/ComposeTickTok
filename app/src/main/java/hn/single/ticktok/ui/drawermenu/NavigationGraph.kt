package hn.single.ticktok.ui.drawermenu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import hn.single.ticktok.ui.drawermenu.screen.HomeScreen
import hn.single.ticktok.ui.drawermenu.screen.NotificationScreen
import hn.single.ticktok.ui.drawermenu.screen.ProfileScreen
import hn.single.ticktok.ui.drawermenu.screen.SettingScreen
import hn.single.ticktok.ui.drawermenu.screen.VideosScreen

@Composable
fun SetUpNavGraph(
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(Screens.Home.route) {
            HomeScreen(innerPadding = innerPadding)
        }
        composable(Screens.Notification.route) {
            NotificationScreen(innerPadding = innerPadding)
        }
        composable(Screens.Profile.route) {
            ProfileScreen(innerPadding = innerPadding)
        }

        composable(Screens.Setting.route) {
            SettingScreen(innerPadding = innerPadding)
        }

        composable(route = Screens.VideosScreen.route) {
            VideosScreen(innerPadding = innerPadding)
        }
    }
}


