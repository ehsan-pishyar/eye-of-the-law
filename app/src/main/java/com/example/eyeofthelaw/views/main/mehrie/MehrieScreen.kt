package com.example.eyeofthelaw.views.main.mehrie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.eyeofthelaw.components.JetDropDown
import com.example.eyeofthelaw.components.JetText
import com.example.eyeofthelaw.inflation_index_state.InflationIndexUiState

@Composable
fun MehrieScreen(
    toHomeScreen: () -> Unit,
    mehrieViewModel: MehrieViewModel = hiltViewModel()
) {

    val state = mehrieViewModel.state.value
    val inflationIndexState = mehrieViewModel.inflationIndexState.value

    val mehrieType = listOf("مهریه بر اساس ارزش پول", "مهریه بر اساس سکه")

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            JetDropDown(items = mehrieType)
            Spacer(modifier = Modifier.height(10.dp))

            MehrieMoneyScreen(state = state, inflationIndexState = inflationIndexState)
        }
    }
}

@Composable
fun MehrieMoneyScreen(
    state: MehrieUiState,
    inflationIndexState: InflationIndexUiState
) {
    Column(modifier = Modifier
        .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        JetDropDown(items = emptyList())
    }
}

@Composable
fun MehrieCoinScreen() {

}