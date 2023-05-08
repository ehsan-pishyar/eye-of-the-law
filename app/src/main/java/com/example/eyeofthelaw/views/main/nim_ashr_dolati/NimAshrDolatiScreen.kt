package com.example.eyeofthelaw.views.main.nim_ashr_dolati

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eyeofthelaw.components.JetText
import com.example.eyeofthelaw.components.JetTextField

@Composable
fun NimAshrDolatiScreen(
    toHomeScreen: () -> Unit,
    viewModel: NimAshrDolatiViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    var amount by remember {
        mutableStateOf("")
    } 

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetTextField(
                title = "مقدار",
                placeholder = "مقدار را وارد نمائید",
                value = amount,
                onValueChange = {
                    amount = it
                    if (amount.isNotEmpty() || amount.isNotBlank()) {
                        viewModel.getResult(it.toLong())
                    } else {
                        amount = ""
                    }
                }
            )
            
            Spacer(modifier = Modifier.height(50.dp))

            if (amount.isNotEmpty() || amount.isNotBlank()) {
                JetText(text = state.success.result)
                Spacer(modifier = Modifier.height(10.dp))
                JetText(text = state.success.description)
            }
        }
    }

}