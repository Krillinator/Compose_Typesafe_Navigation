package com.krillinator.compose_typesafe_navigation.ui.composables

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import com.krillinator.compose_typesafe_navigation.ui.theme.bodyFontFamily

enum class ButtonType {
    ERROR,
    SUBMIT,
    NAVIGATION,
    DATA_REQUEST,
}

@Composable
fun ActionButton(
    text: String,
    buttonType: ButtonType,
    onClick: () -> Unit,
) {

    val colors = when (buttonType) {
        ButtonType.ERROR -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )
        ButtonType.SUBMIT -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        ButtonType.NAVIGATION -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )
        ButtonType.DATA_REQUEST -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
    }

    Button(
        onClick = onClick,
        colors = colors
    ) {
        Text(
            text = text,
            fontFamily = bodyFontFamily,
            fontWeight = FontWeight.Bold
        )
    }

}