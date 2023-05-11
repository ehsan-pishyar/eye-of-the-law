package com.example.eyeofthelaw.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import java.text.NumberFormat

class ThousandSeparatorTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        val outputText = formatAmount(parseAmount(text.text))

        val numberOffsetTranslator = object : OffsetMapping {
            override fun originalToTransformed(offset: Int): Int {
                return outputText.length
            }

            override fun transformedToOriginal(offset: Int): Int {
                return text.length
            }
        }

        return TransformedText(
            text = AnnotatedString(outputText),
            offsetMapping = numberOffsetTranslator
        )
    }

    private fun parseAmount(amountString: String): Long {
        return try {
            amountString.replace(",", "").toLong()
        } catch (e: NumberFormatException) {
            0L
        }
    }

    private fun formatAmount(amount: Long): String {
        return NumberFormat.getIntegerInstance().format(amount)
    }
}
