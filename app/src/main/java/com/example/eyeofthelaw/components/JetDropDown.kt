package com.example.eyeofthelaw.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.eyeofthelaw.ui.theme.*

@Composable
fun JetDropDownWithDialog(
    title: String,
    modifier: Modifier = Modifier,
    items: List<String>,
    dialogTitle: String,
    selectedItem: MutableState<String>
) {
    val selectedIndex = remember { mutableStateOf(selectedItem.value) }
    val text = if (selectedIndex.value.isEmpty()) "انتخاب کنید ..." else selectedIndex.value
    var openDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = modifier.fillMaxWidth()
        ) {
            JetText(
                text = title,
                modifier = modifier.padding(horizontal = 10.dp),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextButton(
                onClick = { openDialog = true },
                modifier = modifier.fillMaxWidth().height(55.dp),
                shape = RoundedCornerShape(3.dp),
                colors = ButtonDefaults.textButtonColors(containerColor = LighterGray)
            ) {
                Row(
                    modifier = modifier.fillMaxWidth().padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    JetText(
                        text = text,
                        fontWeight = FontWeight.Medium,
                        fontSize = 14,
                        color = Black
                    )
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "",
                        tint = Black
                    )
                }
            }

            if (openDialog) {
                Dialog(
                    onDismissRequest = { openDialog = false },
                ) {
                    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                        Surface(
                            modifier = modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(15.dp)
                        ) {
                            Column(modifier = modifier.padding(15.dp)) {
                                JetText(
                                    text = "انتخاب $dialogTitle",
                                    fontSize = 14,
                                    fontWeight = FontWeight.SemiBold,
                                    color = LighterGray
                                )

                                Spacer(modifier = modifier.height(10.dp))

                                Divider(
                                    modifier = modifier.fillMaxWidth(),
                                    color = LighterGray,
                                    thickness = 1.dp
                                )

                                Spacer(modifier = modifier.height(20.dp))

                                Box(modifier = modifier.height(350.dp)) {
                                    LazyColumn(modifier = modifier.fillMaxSize()) {
                                        items(items.size) { index ->
                                            val item = items[index]
                                            Row(
                                                modifier = modifier.fillMaxWidth().clickable {
                                                    selectedIndex.value = item
                                                    selectedItem.value = item
                                                    openDialog = false
                                                },
                                                verticalAlignment = Alignment.CenterVertically
                                            ) {
                                                RadioButton(
                                                    selected = selectedIndex.value == item,
                                                    onClick = null
                                                )
                                                JetText(text = item)
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

