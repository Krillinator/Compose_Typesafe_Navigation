package com.krillinator.compose_typesafe_navigation.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.krillinator.compose_typesafe_navigation.ui.theme.bodyFontFamily

enum class ButtonType {
    PRIMARY,
    SECONDARY,
    TERTIARY,
    ERROR,
    ON_PRIMARY,
    ON_SECONDARY,
    ON_TERTIARY,
    ON_ERROR,
    SURFACE,
    ON_SURFACE,
    INVERSE_PRIMARY

}

@Composable
fun CustomButton(
    buttonType: ButtonType,
    onClick: (() -> Unit) = {},
    innerContent: @Composable (() -> Unit) = {}
) {

    val colors = when (buttonType) {
        ButtonType.PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        )
        ButtonType.SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondary,
            contentColor = MaterialTheme.colorScheme.onSecondary
        )
        ButtonType.TERTIARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            contentColor = MaterialTheme.colorScheme.onTertiary
        )
        ButtonType.ERROR -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.error,
            contentColor = MaterialTheme.colorScheme.onError
        )

        ButtonType.ON_PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
        ButtonType.ON_SECONDARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.secondaryContainer,
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer
        )
        ButtonType.ON_TERTIARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            contentColor = MaterialTheme.colorScheme.onTertiaryContainer
        )
        ButtonType.ON_ERROR -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onError,
            contentColor = MaterialTheme.colorScheme.onErrorContainer
        )

        ButtonType.SURFACE -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
        ButtonType.ON_SURFACE -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.surfaceContainer
        )

        ButtonType.INVERSE_PRIMARY -> ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )

    }

    Button(
        onClick = onClick,
        colors = colors
    ) {
        innerContent()
    }

}

@Preview(showSystemUi = true)
@Composable
fun ButtonPreview(modifier: Modifier = Modifier) {
    Column {

    }
}