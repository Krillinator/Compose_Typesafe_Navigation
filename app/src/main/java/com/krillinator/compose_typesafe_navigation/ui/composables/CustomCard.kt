package com.krillinator.compose_typesafe_navigation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview
import com.krillinator.compose_typesafe_navigation.R

enum class CardStyle {
    OUTLINED,
    FILLED,
    ELEVATED
}

@Composable
fun CustomCard(
    modifier: Modifier = Modifier,
    style: CardStyle,
    backgroundColor: Color = MaterialTheme.colorScheme.surface,
    title: String,
    subhead: String,
    imageId: Int,
    body: String
) {

    // TODO LazyColumn might re-render and not apply my modifier - USE COIL INSTEAD

    when (style) {
        CardStyle.OUTLINED -> OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            CustomCardTemplate(modifier, title, subhead, imageId, body)
        }
        CardStyle.FILLED -> Card(
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            CustomCardTemplate(modifier, title, subhead, imageId, body)
        }
        CardStyle.ELEVATED -> Card(
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ) {
            CustomCardTemplate(modifier, title, subhead, imageId, body)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        CustomCard(
            style = CardStyle.FILLED,
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCard(
            style = CardStyle.OUTLINED,
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCard(
            style = CardStyle.ELEVATED,
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum"
        )
    }
}