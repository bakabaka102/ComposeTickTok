package hn.single.ticktok.ui.drawermenu.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

data class HomeTab(val title: String)

data class TabItem(
    val title: String, val unSelectedItem: ImageVector, val selectedIcon: ImageVector
)

val tabItem = listOf(
    TabItem(
        title = "Home", unSelectedItem = Icons.Outlined.Home, selectedIcon = Icons.Filled.Home
    ), TabItem(
        title = "Browse",
        unSelectedItem = Icons.Outlined.ShoppingCart,
        selectedIcon = Icons.Filled.ShoppingCart
    ), TabItem(
        title = "Settings",
        unSelectedItem = Icons.Outlined.Settings,
        selectedIcon = Icons.Filled.Settings
    )
)