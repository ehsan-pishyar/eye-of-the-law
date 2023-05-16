package com.example.eyeofthelaw.views.main.nim_ashr_dolati

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nim_ashr_dolati.use_cases.GetNimAshrResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NimAshrDolatiViewModel @Inject constructor(
    private val getNimAshrResultUseCase: GetNimAshrResultUseCase
): ViewModel() {

    private var _state = mutableStateOf(NimAshrResultUiState())
    val state: State<NimAshrResultUiState> = _state

    private var _amount = mutableStateOf("")
    val amount: State<String> get() = _amount

    fun setAmount(newAmount: String) {
        _amount.value = newAmount
        if (newAmount.isNotEmpty()) {
            getResult(newAmount.toLong())
        } else {
            _amount.value = ""
        }
    }

    private fun getResult(amount: Long) {
        viewModelScope.launch {
            getNimAshrResultUseCase.invoke(amount).collect {
                _state.value = _state.value.copy(
                    success = it
                )
            }
        }
    }
}