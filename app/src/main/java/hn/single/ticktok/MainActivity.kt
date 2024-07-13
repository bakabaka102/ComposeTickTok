@file:OptIn(ExperimentalMaterial3Api::class)

package hn.single.ticktok

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import hn.single.ticktok.ui.drawermenu.DrawerMenuItem
import hn.single.ticktok.ui.drawermenu.NavBarBody
import hn.single.ticktok.ui.drawermenu.NavBarHeader
import hn.single.ticktok.ui.drawermenu.Screens
import hn.single.ticktok.ui.drawermenu.SetUpNavGraph
import hn.single.ticktok.ui.theme.ComposeTickTokTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTickTokTheme {
                val items = listOf(
                    DrawerMenuItem(
                        title = "Home",
                        route = Screens.Home.route,
                        selectedIcon = Icons.Filled.Home,
                        unSelectedIcon = Icons.Outlined.Home,
                    ),
                    DrawerMenuItem(
                        title = "Profile",
                        route = Screens.Profile.route,
                        selectedIcon = Icons.Filled.Person,
                        unSelectedIcon = Icons.Outlined.Person,
                    ),
                    DrawerMenuItem(
                        title = "Notification",
                        route = Screens.Notification.route,
                        selectedIcon = Icons.Filled.Notifications,
                        unSelectedIcon = Icons.Outlined.Notifications,
                        badgeCount = 9
                    ),
                    DrawerMenuItem(
                        title = "Setting",
                        route = Screens.Setting.route,
                        selectedIcon = Icons.Filled.Settings,
                        unSelectedIcon = Icons.Outlined.Settings,
                    ),
                    DrawerMenuItem(
                        title = "Share",
                        route = "share",
                        selectedIcon = Icons.Filled.Share,
                        unSelectedIcon = Icons.Outlined.Share,
                    ),
                )

                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                val context = LocalContext.current
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val topBarTitle = if (currentRoute != null) {
                    items[items.indexOfFirst {
                        it.route == currentRoute
                    }].title
                } else {
                    items[0].title
                }
                ModalNavigationDrawer(
                    gesturesEnabled = drawerState.isOpen,
                    drawerContent = {
                        ModalDrawerSheet() {
                            NavBarHeader()
                            Spacer(modifier = Modifier.height(8.dp))
                            NavBarBody(
                                items = items,
                                currentRoute = currentRoute
                            ) { currentNavigationItem ->
                                if (currentNavigationItem.route == "share") {
                                    Toast.makeText(context, "Share", Toast.LENGTH_LONG).show()
                                } else {
                                    navController.navigate(currentNavigationItem.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        navController.graph.startDestinationRoute?.let { startDestinationRoute ->
                                            // Pop up to the start destination, clearing the back stack
                                            popUpTo(startDestinationRoute) {
                                                // Save the state of popped destinations
                                                saveState = true
                                            }
                                        }

                                        // Configure navigation to avoid multiple instances of the same destination
                                        launchSingleTop = true

                                        // Restore state when re-selecting a previously selected item
                                        restoreState = true
                                    }
                                }

                                scope.launch {
                                    drawerState.close()
                                }
                            }
                        }
                    }, drawerState = drawerState
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Text(text = topBarTitle)
                            },
                                navigationIcon = {
                                    IconButton(onClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    }) {
                                        Icon(
                                            imageVector = Icons.Default.Menu,
                                            contentDescription = "menu"
                                        )
                                    }
                                })
                        }
                    ) { innerPadding ->
                        SetUpNavGraph(navController = navController, innerPadding = innerPadding)
                    }
                }


                /* Surface(
                     modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                 ) {

                 }*/
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTickTokTheme {

    }
}