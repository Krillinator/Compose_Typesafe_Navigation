package com.krillinator.compose_typesafe_navigation.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.krillinator.compose_typesafe_navigation.R

@Composable
fun CustomCardTemplate(
    modifier: Modifier = Modifier,
    title: String,
    subhead: String,
    imageId: Int,
    body: String
) {

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column(
            modifier = modifier.padding(horizontal = 8.dp)
        ) {

            Row(
                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {

                    Text(text = title,
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = subhead,
                        style = MaterialTheme.typography.titleMedium,
                        fontStyle = FontStyle.Italic
                    )

                }

                Column {
                    Text(text = "Test")
                }
            }
        }

        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageId)
                .build(),
            contentDescription = "",
            contentScale = ContentScale.FillWidth,
            modifier = modifier
                .heightIn(min = 256.dp, max = 256.dp)
                .padding(vertical = 16.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Text(
            text = truncateText(
                text = body,
                maxLength = 100
            ),
            style = MaterialTheme.typography.bodyMedium
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 16.dp)
        ) {

            CustomButton(buttonType = ButtonType.PRIMARY) {
                Text(text = "Read", style = MaterialTheme.typography.bodyLarge)
            }

            CustomButton(buttonType = ButtonType.SECONDARY) {
                Text(text = "Message", style = MaterialTheme.typography.bodyLarge)
            }

        }
    }
}



@Preview(showSystemUi = true)
@Composable
fun CustomCardPreview(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
        CustomCardTemplate(
            title = "Title",
            subhead = "Subhead",
            imageId = R.drawable.ic_launcher_background,
            body = "body text etc.."
        )
    }
}

fun truncateText(text: String, maxLength: Int): String {
    return if (text.length > maxLength) {
        text.substring(0, maxLength) + "..."
    } else {
        text
    }
}