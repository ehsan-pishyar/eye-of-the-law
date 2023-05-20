package com.example.eyeofthelaw.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.common.models.Year
import com.example.eyeofthelaw.ui.theme.LighterGray
import com.example.eyeofthelaw.ui.theme.Secondary
import com.example.eyeofthelaw.ui.theme.Yekanbakh

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JetExposedDropDown(
    label: String,
    itemList: List<String> = emptyList(),
    yearList: List<Year> = emptyList(),
    selectedItem: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf("") }
    
    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .menuAnchor(),
            readOnly = false,
            value = selectedIndex,
            onValueChange = {},
            textStyle = TextStyle(
                fontFamily = Yekanbakh,
                textAlign = TextAlign.Start,
                fontSize = 14.sp,
                fontWeight = FontWeight.Normal
            ),
            label = { JetText(text = label, fontSize = 13) },
            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Secondary,
                unfocusedIndicatorColor = LighterGray,
                focusedLabelColor = Secondary,
                unfocusedLabelColor = LighterGray,
                containerColor = Color.White
            )
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            if (itemList.isNotEmpty()) {
                itemList.forEach {
                    DropdownMenuItem(
                        text = { JetText(text = it) },
                        onClick = {
                            selectedItem(it)
                            expanded = false
                            selectedIndex = it
                        }
                    )
                }
            }
            if (yearList.isNotEmpty()) {
                yearList.forEach {
                    DropdownMenuItem(
                        text = { JetText(text = it.year) },
                        onClick = {
                            selectedItem(it.year)
                            expanded = false
                            selectedIndex = it.year
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewExposedDropDown() {
    JetExposedDropDown(
        label = "انتخاب کنید",
        itemList = listOf("مقدار اول", "مقدار دوم", "مقدار سوم", "مقدار چهارم", "مقدار پنجم"),
        selectedItem = {}
    )
}