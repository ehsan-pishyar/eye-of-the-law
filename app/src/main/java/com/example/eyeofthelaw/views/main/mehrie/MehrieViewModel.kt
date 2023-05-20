package com.example.eyeofthelaw.views.main.mehrie

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.common.use_cases.GetInflationIndexUseCase
import com.example.eyeofthelaw.inflation_index_state.InflationIndexUiState
import com.example.mehrie.use_cases.GetMehrieCoinResultUseCase
import com.example.mehrie.use_cases.GetMehrieMoneyResultUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MehrieViewModel @Inject constructor(
    private val getMehrieMoneyResultUseCase: GetMehrieMoneyResultUseCase,
    private val getMehrieCoinResultUseCase: GetMehrieCoinResultUseCase,
    private val getInflationIndexUseCase: GetInflationIndexUseCase
): ViewModel() {

    private var _state = mutableStateOf(MehrieUiState())
    val state: State<MehrieUiState> get() = _state

    private var _inflationIndexState = mutableStateOf(InflationIndexUiState())
    val inflationIndexState: State<InflationIndexUiState> get() = _inflationIndexState

    private var _mehrieTypeState = mutableStateOf("")
    val mehrieTypeState: State<String> get() = _mehrieTypeState

    private var _amountState = mutableStateOf("")
    val amountState: State<String> get() = _amountState

    private var _aghdInflationIndex = mutableStateOf(0.0)
    val aghdInflationIndex: State<Double> get() = _aghdInflationIndex

    private var _pardakhtInflationIndex = mutableStateOf(0.0)
    val pardakhtInflationIndex: State<Double> get() = _pardakhtInflationIndex

    init {
        getInflationIndex()
    }

    fun setMehrieTypeState(type: String) {
        viewModelScope.launch {
            _mehrieTypeState.value = type
        }
    }

    fun setMoneyAmount(newAmount: String, aghdInflationIndex: Double, pardakhtInflationIndex: Double) {
        _amountState.value = newAmount
        if (newAmount.isNotEmpty()) {
            getMoneyResult(
                aghdInflationIndex,
                pardakhtInflationIndex,
                newAmount.toLong()
            )
        } else {
            _amountState.value = ""
        }
    }

    fun setAghdInflationIndex(newAghdInflationIndex: Double) {
        _aghdInflationIndex.value = newAghdInflationIndex
    }

    fun setPardakhtInflationIndex(newPardakhtInflationIndex: Double) {
        _pardakhtInflationIndex.value = newPardakhtInflationIndex
    }

    private fun getMoneyResult(
        aghdInflationIndex: Double,
        pardakhtInflationIndex: Double,
        amount: Long
    ) {
        viewModelScope.launch {
            getMehrieMoneyResultUseCase.invoke(
                aghdInflationIndex,
                pardakhtInflationIndex,
                amount
            ).collect {
                _state.value = _state.value.copy(
                    success = it
                )
            }
        }
    }

    private fun getInflationIndex() {
        viewModelScope.launch {
            getInflationIndexUseCase.invoke().collect {
                _inflationIndexState.value = _inflationIndexState.value.copy(
                    response = it
                )
            }
        }
    }
}