package com.example.eyeofthelaw.views.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eyeofthelaw.R
import com.example.eyeofthelaw.components.JetCategory

@Composable
fun HomeScreen(
    toNimAshrScreen: () -> Unit,
    toMehrieScreen: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally),
                content = {
                    items(count = 12) { index ->
                        when(index) {
                        0 -> {
                            JetCategory(
                                title = "نیم عشر دولتیپ",
                                image = R.drawable.secret,
                                onClick = { toNimAshrScreen() }
                            )
                        }
                        1 -> {
                            JetCategory(
                                title = "مهریه به نرخ روز",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        2 -> {
                            JetCategory(
                                title = "حق الزحمه داوری",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        3 -> {
                            JetCategory(
                                title = "هزینه دادرسی",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        4 -> {
                            JetCategory(
                                title = "دستمزد کارشناسی",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        5 -> {
                            JetCategory(
                                title = "خسارت تاخیر تادیه",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        6 -> {
                            JetCategory(
                                title = "هزینه دفتر اسناد رسمی",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        7 -> {
                            JetCategory(
                                title = "حق الوکاله و تمبر",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        8 -> {
                            JetCategory(
                                title = "دیه",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        9 -> {
                            JetCategory(
                                title = "دفتر خدمات قضایی",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        10 -> {
                            JetCategory(
                                title = "کارشناسی قانون تعیین تکلیف ساختمان های فاقد سند رسمی",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                        11 -> {
                            JetCategory(
                                title = "حق الارث",
                                image = R.drawable.secret,
                                onClick = { toMehrieScreen() }
                            )
                        }
                    }
                }
            })
        }
    }
}