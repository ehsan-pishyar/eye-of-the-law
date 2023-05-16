package com.example.eyeofthelaw.views.main.nim_ashr_dolati

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.eyeofthelaw.R
import com.example.eyeofthelaw.components.JetText
import com.example.eyeofthelaw.components.JetTextField
import com.example.eyeofthelaw.utils.separateThousands
import java.util.Locale
import kotlin.reflect.typeOf

@Composable
fun NimAshrDolatiScreen(
    toHomeScreen: () -> Unit,
    viewModel: NimAshrDolatiViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val amount = viewModel.amount.value

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JetTextField(
                title = stringResource(id = R.string.amount2),
                placeholder = "${stringResource(id = R.string.placeholderName)} ${stringResource(id = R.string.p10_000_000)}",
                value = amount,
                onValueChange = { viewModel.setAmount(it) }
            )
            
            Spacer(modifier = Modifier.height(50.dp))

            if (amount.isNotEmpty()) {
                JetText(text = "${state.success.result.separateThousands()} ${stringResource(id = R.string.rial)}")
                Spacer(modifier = Modifier.height(10.dp))
                JetText(text = state.success.description)
            }
        }
    }

}