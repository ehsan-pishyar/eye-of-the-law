package com.example.eyeofthelaw.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.eyeofthelaw.ui.theme.Black
import com.example.eyeofthelaw.ui.theme.LighterGray
import com.example.eyeofthelaw.ui.theme.Primary
import com.example.eyeofthelaw.ui.theme.Yekanbakh
import com.example.eyeofthelaw.utils.ThousandSeparatorTransformation

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetTextField(
    modifier: Modifier = Modifier,
    title: String,
    height: Int = 56,
    value: String,
    placeholder: String,
    background: Color = Color(0xFFF6F6F6),
    style: TextStyle = TextStyle(
        color = MaterialTheme.colorScheme.onBackground,
        fontSize = 14.sp,
        fontFamily = Yekanbakh,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal
    ),
    singleLine: Boolean = true,
    maxLines: Int = 1,
    shape: Int = 3,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Number,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit,
    visualTransformation: VisualTransformation = ThousandSeparatorTransformation()
){
    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        if (title.isNotEmpty()) {
            JetText(
                text = title,
                modifier = modifier
                    .padding(horizontal = 10.dp),
                fontFamily = Yekanbakh,
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        OutlinedTextField(
            modifier = modifier
                .fillMaxWidth()
                .height(height.dp)
                .semantics {
                    testTag = "Text field"
                },
            value = value,
            onValueChange = { onValueChange(it) },
            shape = RoundedCornerShape(shape.dp),
            maxLines = maxLines,
            textStyle = style,
            readOnly = readOnly,
            placeholder = {
                Text(
                    modifier = modifier.fillMaxWidth(),
                    text = placeholder,
                    style = style,
                )
            },
//            if (onValueChange.toString().length > maxLength) {
//                isError = error
//            } else {
//                isError = ""
//            }
//            isError = error != "",
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            singleLine = singleLine,
            colors = TextFieldDefaults.textFieldColors(
                containerColor = background,
                cursorColor = Black,
                focusedIndicatorColor = Primary,
                unfocusedIndicatorColor = LighterGray,
            ),
            leadingIcon = leadingIcon,
            trailingIcon = trailingIcon,
            visualTransformation = visualTransformation
        )
    }
}