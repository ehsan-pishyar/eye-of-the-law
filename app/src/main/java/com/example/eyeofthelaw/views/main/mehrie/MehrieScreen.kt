package com.example.eyeofthelaw.views.main.mehrie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eyeofthelaw.R
import com.example.eyeofthelaw.components.JetExposedDropDown
import com.example.eyeofthelaw.components.JetText
import com.example.eyeofthelaw.components.JetTextField
import com.example.eyeofthelaw.utils.separateThousands

@Composable
fun MehrieScreen(
    toHomeScreen: () -> Unit,
    mehrieViewModel: MehrieViewModel = hiltViewModel()
) {

    val mehrieType = listOf("مهریه بر اساس ارزش پول", "مهریه بر اساس سکه")

    val mehrieTypeState = mehrieViewModel.mehrieTypeState
    val state = mehrieViewModel.state.value
    val inflationIndexState = mehrieViewModel.inflationIndexState.value

    var openDialog by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            JetExposedDropDown(
                label = "نوع مهریه",
                itemList = mehrieType,
                selectedItem = { mehrieViewModel.setMehrieTypeState(it) }
            )
            
            Spacer(modifier = Modifier.height(10.dp))

            JetText(text = mehrieTypeState.value)
            println(mehrieTypeState.value)

            when(mehrieTypeState.value) {
                "مهریه بر اساس ارزش پول" -> {
                    MehrieMoneyScreen(viewModel = mehrieViewModel)
                }
                "مهریه بر اساس سکه" -> {
                    MehrieCoinScreen(viewModel = mehrieViewModel)
                }
            }
        }
    }
}

@Composable
fun MehrieMoneyScreen(
    viewModel: MehrieViewModel
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val state = viewModel.state.value
        val inflationIndexState = viewModel.inflationIndexState.value
        val amountState = viewModel.amountState.value
        val aghdInflationIndexState = viewModel.aghdInflationIndex.value
        val pardakhtInflationIndexState = viewModel.pardakhtInflationIndex.value

        inflationIndexState.response?.response?.let { years ->
            JetExposedDropDown(
                label = "سال اخذ مهریه",
                yearList = years,
                selectedItem = { viewModel.setPardakhtInflationIndex(it.toDouble()) }
            )

            Spacer(modifier = Modifier.height(10.dp))

            JetExposedDropDown(
                label = "سال عقد",
                yearList = years,
                selectedItem = { viewModel.setAghdInflationIndex(it.toDouble()) }
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        JetTextField(
            title = "مبلغ مهریه را وارد نمائید",
            value = amountState,
            onValueChange = {
                viewModel.setMoneyAmount(
                    aghdInflationIndex = aghdInflationIndexState,
                    pardakhtInflationIndex = pardakhtInflationIndexState,
                    newAmount = it
                    )
            }
        )

        Spacer(modifier = Modifier.height(50.dp))

        if (amountState.isNotEmpty()) {
            JetText(text = "شاخص سال اخذ: $pardakhtInflationIndexState, شاخص سال عقد: $aghdInflationIndexState")
            JetText(text = "${state.success?.result?.separateThousands()} ${stringResource(id = R.string.rial)}")
            Spacer(modifier = Modifier.height(10.dp))
            state.success?.description?.let { JetText(text = it) }
        }
    }
}

@Composable
fun MehrieCoinScreen(
    viewModel: MehrieViewModel
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "مهریه بر اساس سکه")
    }
}