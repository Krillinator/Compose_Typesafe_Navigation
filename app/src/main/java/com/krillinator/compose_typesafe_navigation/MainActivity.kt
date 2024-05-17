package com.krillinator.compose_typesafe_navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.krillinator.compose_typesafe_navigation.ui.screen.HomeScreen
import com.krillinator.compose_typesafe_navigation.ui.screen.LoginScreen
import com.krillinator.compose_typesafe_navigation.ui.screen.Screen
import com.krillinator.compose_typesafe_navigation.ui.screen.UserScreen
import com.krillinator.compose_typesafe_navigation.ui.theme.Compose_Typesafe_NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Compose_Typesafe_NavigationTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background

                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.Home
                    ) {
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


