package com.krillinator.compose_typesafe_navigation.ui.screen.loading

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.EaseOutQuart
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.krillinator.compose_typesafe_navigation.R
import com.krillinator.compose_typesafe_navigation.ui.composables.animation.AnimatedCircle
import com.krillinator.compose_typesafe_navigation.ui.screen.navigation.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun SplashScreen(navController: NavController) {

    val size = remember {
        Animatable(100f)
    }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {
            size.animateTo(
                targetValue = 200f,
                animationSpec = tween(
                    durationMillis = 2000,
                    easing = EaseOutQuart
                )
            )
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {

        AnimatedCircle()

        // Logo
        Image(
            painter = painterResource(id = R.drawable.treety_high_resolution_logo_white_transparent),
            contentDescription = "",
            modifier = Modifier.size(size.value.dp)
        )
    }

    LaunchedEffect(Unit) {
        delay(1000)
        navController.navigate(Screen.Home) {
            popUpTo<Screen.Splash> { inclusive = true } // Remove from backstack
        }
    }

}
