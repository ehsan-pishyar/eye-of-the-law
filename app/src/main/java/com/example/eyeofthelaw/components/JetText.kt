package com.example.eyeofthelaw.components

import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.eyeofthelaw.ui.theme.Black
import com.example.eyeofthelaw.ui.theme.Yekanbakh

@Composable
fun JetText(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Black,
    lineHeight: Double = 1.0,
    textAlign: TextAlign = TextAlign.Justify,
    maxLines: Int = 1,
    fontFamily: FontFamily = Yekanbakh,
    fontStyle: FontStyle = FontStyle.Normal
) {

    Text(
        text = text,
        modifier = modifier.wrapContentWidth(),
        fontSize = fontSize.sp,
        fontWeight = fontWeight,
        color = color,
        lineHeight = lineHeight.em,
        textAlign = textAlign,
        maxLines = maxLines,
        fontFamily = fontFamily,
        fontStyle = fontStyle
    )
}

@Preview
@Composable
fun PreviewJetText() {
    JetText(text = "لورم ایپسوم متن ساختگی با هدف عدم کپی رایت است که به دست احسان پیش یار نوشته شده است")
}