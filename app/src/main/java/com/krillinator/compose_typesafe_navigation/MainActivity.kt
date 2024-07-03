package com.krillinator.compose_typesafe_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.krillinator.compose_typesafe_navigation.ui.screen.loading.SplashScreen
import com.krillinator.compose_typesafe_navigation.ui.screen.HomeScreen
import com.krillinator.compose_typesafe_navigation.ui.screen.LoginScreen
import com.krillinator.compose_typesafe_navigation.ui.screen.navigation.Screen
import com.krillinator.compose_typesafe_navigation.ui.screen.UserScreen
import com.krillinator.compose_typesafe_navigation.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {

                    val navController = rememberNavController()

                    // Bottom Nav
                    ScaffoldWithBottomNavigation(navController = navController) {
                        NavHost(
                            navController = navController,
                            startDestination = Screen.Splash
                        ) {
                            composable<Screen.Splash> {
                                SplashScreen(navController)
                            }
                            composable<Screen.Home> {
                                HomeScreen(navController)
                            }
                            composable<Screen.Login> {
                                LoginScreen(navController)
                            }
                            composable<Screen.User> {
                                val args = it.toRoute<Screen.User>()
                                UserScreen(args.username, args.password, navController)
                            }
                        }
                    }

                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldWithBottomNavigation(navController: NavController, content: @Composable () -> Unit) {

    val colors = NavigationBarItemDefaults.colors(
        selectedIconColor = MaterialTheme.colorScheme.tertiary,
        unselectedIconColor = MaterialTheme.colorScheme.onPrimary,
        selectedTextColor = MaterialTheme.colorScheme.secondary,
        unselectedTextColor = MaterialTheme.colorScheme.onSecondary
    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("My App", style = MaterialTheme.typography.headlineLarge)
                },
                actions = @Composable {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "More Options",
                            modifier = Modifier.fillMaxSize()

                        )
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
                    actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.primaryContainer
            ) {
                // Define BottomNavigationItems here
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "${Screen.Home}", Modifier.size(32.dp)) },
                    label = { Text("Home") },
                    selected = navController.currentDestination?.route == Screen.Home.toString(),
                    onClick = {
                        navController.navigate(Screen.Home)
                    },
                    colors = colors
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "${Screen.Login}", Modifier.size(32.dp)) },
                    label = { Text("Favorites") },
                    selected = navController.currentDestination?.route == Screen.Login.toString(),
                    onClick = {
                        navController.navigate(Screen.Login)
                    },
                    colors = colors
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.AccountBox, contentDescription = "${Screen.User}", Modifier.size(32.dp)) },
                    label = { Text("User") },
                    selected = navController.currentDestination?.route == Screen.User.toString(),
                    onClick = {
                        navController.navigate(Screen.User("", ""))
                    },
                    colors = colors,
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Search, contentDescription = "${Screen.User}", Modifier.size(32.dp)) },
                    label = { Text("Search") },
                    selected = navController.currentDestination?.route == Screen.User.toString(),
                    onClick = {
                        navController.navigate(Screen.User("", ""))
                    },
                    colors = colors,
                )
            }
        }
    ) {

        Column(modifier = Modifier.padding(it)) {
            content()
        }

    }
}
