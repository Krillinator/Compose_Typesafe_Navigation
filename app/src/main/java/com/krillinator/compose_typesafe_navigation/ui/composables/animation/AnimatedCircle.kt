package com.krillinator.compose_typesafe_navigation.ui.composables.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun AnimatedCircle() {
    val circleRadius = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()
    val appThemeColor = MaterialTheme.colorScheme.inverseOnSurface


    LaunchedEffect(Unit) {
        scope.launch {
            circleRadius.animateTo(
                targetValue = 400f,
                animationSpec = androidx.compose.animation.core.spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )
        }
    }

    Canvas(modifier = Modifier.fillMaxSize()) {

        val paint = Paint().apply {
            color = appThemeColor
        }
        val center = Offset(size.width / 2, size.height / 2)
        drawIntoCanvas { canvas ->
            canvas.drawCircle(
                center = center,
                radius = circleRadius.value,
                paint = paint
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedCirclePreview() {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {

        AnimatedCircle()
    }
}
