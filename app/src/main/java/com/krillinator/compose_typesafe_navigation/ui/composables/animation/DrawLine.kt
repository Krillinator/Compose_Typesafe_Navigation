
package com.krillinator.compose_typesafe_navigation.ui.composables.animation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun DrawLine() {
    // Define animatable floats for x and y coordinates of start and end points
    val startX = remember { Animatable(0f) }
    val startY = remember { Animatable(0f) }
    val endX = remember { Animatable(0f) }
    val endY = remember { Animatable(0f) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        scope.launch {

            delay(1000L)

            endY.animateTo(
                targetValue = 700f,
                animationSpec = androidx.compose.animation.core.spring(
                    dampingRatio = Spring.DampingRatioMediumBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )

        }
    }

    val appThemeColor = MaterialTheme.colorScheme.tertiary

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Canvas(modifier = Modifier.fillMaxSize()) {
            val paint = Paint().apply {
                color = appThemeColor
                strokeWidth = 16.dp.toPx()

            }
            drawIntoCanvas { canvas ->
                canvas.drawLine(
                    p1 = Offset(startX.value, startY.value),
                    p2 = Offset(endX.value, endY.value),
                    paint = paint
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnimatedLinePreview() {
    DrawLine()
}
