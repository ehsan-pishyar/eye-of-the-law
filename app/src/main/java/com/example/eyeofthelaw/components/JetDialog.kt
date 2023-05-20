package com.example.eyeofthelaw.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.eyeofthelaw.ui.theme.LighterGray

@Composable
fun JetDialog(
    itemList: List<String>,
    dialogTitle: String,
    selectedItem: (String) -> Unit
) {

    var opened by remember { mutableStateOf(false) }

    if (opened) {
        Dialog(
            onDismissRequest = { opened = false },
            properties = DialogProperties(
                dismissOnBackPress = true,
                dismissOnClickOutside = true
            )
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(15.dp)
                ) {
                    Column(modifier = Modifier.padding(15.dp)) {
                        JetText(
                            text = "انتخاب $dialogTitle",
                            fontSize = 14,
                            fontWeight = FontWeight.SemiBold,
                            color = LighterGray
                        )

                        Spacer(modifier = Modifier.height(10.dp))

                        Divider(
                            modifier = Modifier.fillMaxWidth(),
                            color = LighterGray,
                            thickness = 1.dp
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Box(modifier = Modifier.height(350.dp)) {
                            LazyColumn(modifier = Modifier.fillMaxSize()) {
                                items(itemList.size) { index ->
                                    val item = itemList[index]
                                    Row(
                                        modifier = Modifier.fillMaxWidth().clickable {
                                            selectedItem(item)
                                            opened = false
                                        },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        RadioButton(
                                            selected = itemList[index] == item,
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