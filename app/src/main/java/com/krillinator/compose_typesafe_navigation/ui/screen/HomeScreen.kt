package com.krillinator.compose_typesafe_navigation.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.krillinator.compose_typesafe_navigation.R
import com.krillinator.compose_typesafe_navigation.ui.composables.CardStyle
import com.krillinator.compose_typesafe_navigation.ui.composables.CustomCard
import com.krillinator.compose_typesafe_navigation.ui.screen.navigation.Screen

@Composable
fun HomeScreen(navController: NavController, modifier: Modifier = Modifier) {

    val items = remember { 10 }

    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()    // TODO - Talk about this
    ) {

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            // TODO - Bottom Navigation
            /*
            Text(
                text = "Home",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Icon(
                Icons.Outlined.AccountCircle,
                contentDescription = "",
                Modifier
                    .clip(CircleShape)
                    .size(46.dp)
                    .clickable { }

            )

             */

        }

        LazyColumn(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(items, key = {it}) {
                CustomCard(
                    style = CardStyle.ELEVATED,
                    title = "Trees",
                    subhead = "Life without Oxygen",
                    imageId = R.drawable.nature_stock_image,
                    body =
                    "It's hard imagining a life without oxygen however, it isn't without " +
                            "challenge that we've successfully travelled to the moon and back. " +
                            "Playing with the idea of oxygen canisters needing " +
                            "to be distributed to the population in order for them to survive outside gives " +
                            "us just the right image of what that would be like.."
                )
            }

        }

        Button(
            onClick = { navController.navigate(Screen.Login) },
            modifier = modifier.padding(16.dp)
        ) {
            Text(text = "NAVIGATE TO ${Screen.Login}")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewHome(modifier: Modifier = Modifier) {

    HomeScreen(navController = rememberNavController())

}