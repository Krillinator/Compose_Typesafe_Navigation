package com.krillinator.compose_typesafe_navigation.ui.composables.animation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krillinator.compose_typesafe_navigation.ui.composables.CustomButton
import com.krillinator.compose_typesafe_navigation.ui.composables.ButtonType

@Preview(showSystemUi = true)
@Composable
fun ExampleCard(modifier: Modifier = Modifier) {
Column {
    ElevatedCardExample()
    Spacer(modifier = modifier.size(16.dp))
    FilledCardExample()
}
}

@Composable
fun ElevatedCardExample() {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Elevated",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
fun FilledCardExample() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Filled",
            modifier = Modifier
                .padding(16.dp),
            textAlign = TextAlign.Center,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ExamplePreviewRow(modifier: Modifier = Modifier) {
    Row {
        ChildA()
        ChildB()
        ChildC()
    }
}

@Preview
@Composable
fun PreviewActionButton(modifier: Modifier = Modifier) {

}

@Composable
fun ChildA() {
    Text(text = "Child A")
}

@Composable
fun ChildB() {
    Text(text = "Child B")
}

@Composable
fun ChildC() {
    Text(text = "Child C")
}

