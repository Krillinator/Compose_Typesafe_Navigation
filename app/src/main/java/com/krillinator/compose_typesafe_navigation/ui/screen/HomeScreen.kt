package com.krillinator.compose_typesafe_navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.krillinator.compose_typesafe_navigation.ui.composables.ActionButton
import com.krillinator.compose_typesafe_navigation.ui.composables.ButtonType

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(text = "Home")
        Button(onClick = { navController.navigate(Screen.Login) }) {
            Text(text = "NAVIGATE TO ${Screen.Login}")
        }

        ActionButton(
            text = "SUBMIT",
            buttonType = ButtonType.SUBMIT,
            onClick = { navController.navigate(Screen.Login) }
        )

        ActionButton(
            text = "ERROR",
            buttonType = ButtonType.ERROR,
            onClick = { navController.navigate(Screen.Login) }
        )

        ActionButton(
            text = "Navigate",
            buttonType = ButtonType.NAVIGATION,
            onClick = { navController.navigate(Screen.Login) }
        )

        ActionButton(
            text = "DATA_REQUEST",
            buttonType = ButtonType.DATA_REQUEST,
            onClick = { navController.navigate(Screen.Login) }
        )

    }
}