package com.example.eyeofthelaw.components

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.eyeofthelaw.ui.theme.*
import kotlinx.coroutines.delay

@SuppressLint("UnrememberedMutableState")
@Composable
fun StandardDialog(
    title: String,
    modifier: Modifier = Modifier,
    items: List<String> = ArrayList(),
    dialogTitle: String
) {
    var selectedIndex by remember { mutableStateOf("") }
    val text = selectedIndex.ifEmpty { "انتخاب کنید ..." }
    var openDialog by remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
        ) {

            JetText(
                text = title,
                modifier = modifier
                    .padding(horizontal = 10.dp),
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(5.dp))

            TextButton(
                onClick = {
                    openDialog = true
                },
                modifier = modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(3.dp),
                colors = ButtonDefaults.textButtonColors(
                    containerColor = LighterGray
                )
            ) {
                Row(
                    modifier = modifier
                        .fillMaxWidth()
                        .padding(horizontal = 5.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (selectedIndex.isEmpty()) {
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
                    } else {
                        JetText(
                            text = selectedIndex,
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
            }

            if (openDialog) {
                Dialog(
                    onDismissRequest = { openDialog = false },
                ) {
                    Surface(
                        modifier = modifier
                            .fillMaxWidth(),
                        shape = RoundedCornerShape(15.dp)
                    ) {
                        Column(
                            modifier = modifier
                                .padding(15.dp)
                        ) {

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

                            Box(
                                modifier = modifier
                                    .height(350.dp)
                            ) {
                                LazyColumn(modifier = modifier
                                    .fillMaxSize()
                                ) {
                                    items(items.size) { index ->
                                        Row(modifier = modifier
                                            .fillMaxWidth(),
                                            verticalAlignment = Alignment.CenterVertically
                                        ) {
                                            RadioButton(
                                                selected = selectedIndex == items[index],
                                                onClick = { selectedIndex = items[index] }
                                            )
                                            JetText(
                                                text = items[index],
                                                modifier = modifier.clickable {
                                                    selectedIndex = items[index]
                                                    openDialog = false
                                                }
                                            )
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

@Composable
@Preview
fun PreviewStandardDialog() {
    StandardDialog(
        title = "استان",
        items = listOf("تهران", "اصفهان", "شیراز", "گیلان", "مازندران", "کاشان", "یزد", "هرمزگان", "کردستان", "مشهد"),
        dialogTitle = "استان"
    )
}