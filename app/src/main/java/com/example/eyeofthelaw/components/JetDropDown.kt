package com.example.eyeofthelaw.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.PopupProperties
import com.example.eyeofthelaw.ui.theme.LighterGray

@Composable
fun JetDropDown(items: List<String>) {
    var expanded by remember { mutableStateOf(false) }
    var selectedItem by remember { mutableStateOf("") }

    Column {
        Box(modifier = Modifier
            .fillMaxWidth()
            .background(LighterGray)
        ) {
            Text(
                text = selectedItem,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { expanded = true }
            )
            Icon(
                imageVector = Icons.Default.ArrowDropDown,
                contentDescription = null,
                modifier = Modifier
                    .padding(16.dp)
                    .clickable { expanded = true }
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
            properties = PopupProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true,
            )
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    text = {
                           Text(text = item)
                    },
                    onClick = {
                        selectedItem = item
                        expanded = false
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewJetDropDown() {
    JetDropDown(items = listOf("احسان", "امیر", "مهرناز", "اسما"))
}
