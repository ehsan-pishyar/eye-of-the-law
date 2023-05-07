package com.example.eyeofthelaw.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.eyeofthelaw.R

@Composable
fun JetCoilImage(
    modifier: Modifier = Modifier,
    imageUrl: String? = null
) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl!!)
            .placeholder(R.mipmap.ic_launcher)
            .crossfade(300)
            .build(),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}