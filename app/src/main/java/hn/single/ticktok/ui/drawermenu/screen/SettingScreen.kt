package hn.single.ticktok.ui.drawermenu.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hn.single.ticktok.ui.bottomnavigation.BottomNavigationBar
import hn.single.ticktok.ui.bottomnavigation.NavigationGraph

@Composable
fun SettingScreen(innerPadding: PaddingValues) {
    val navController: NavHostController = rememberNavController()

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
            .background(Color.Cyan),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Setting Screen",
            fontSize = 40.sp,
            color = Color.Black

        )
    }
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                modifier = Modifier
            )
        }) { paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            NavigationGraph(
                navController = navController,
            )
        }
    }
}