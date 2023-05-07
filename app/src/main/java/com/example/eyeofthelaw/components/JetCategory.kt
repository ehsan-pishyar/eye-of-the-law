package com.example.eyeofthelaw.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.min
import com.example.eyeofthelaw.R

@Composable
fun JetCategory(
    modifier: Modifier = Modifier,
    title: String,
    image: Int,
    titleSize: Int = 12,
    onClick: () -> Unit
) {
    Box {
        Column {
            Card(
                modifier = modifier
                    .wrapContentWidth()
                    .height(145.dp)
                    .clickable { onClick() },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFF1F1F1)
                )
            ) {
                Column(
                    modifier = modifier
                        .padding(10.dp)
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = image),
                        contentDescription = null,
                        modifier = modifier.size(80.dp)
                    )

                    JetText(
                        text = title,
                        fontSize = titleSize,
                        textAlign = TextAlign.Center,
                        maxLines = 3,
                        lineHeight = 1.5
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewJetCategory() {
    JetCategory(
        title = "احسان پیش یار",
        image = R.drawable.secret
    ) {}
}