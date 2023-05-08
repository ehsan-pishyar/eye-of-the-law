package com.example.nim_ashr_dolati.use_cases

import com.example.nim_ashr_dolati.models.ResultResponse
import com.example.nim_ashr_dolati.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetResultUseCase(
    private val repository: Repository
) {

    operator fun invoke(amount: Long): Flow<ResultResponse> = flow {
        amount.let {
            if (it < 1000) {
                emit(ResultResponse().copy(result = "$it", description = repository.getResult()))
            } else {
                emit(ResultResponse().copy(result = "${it * 2}", description = repository.getResult2()))
            }
        }
    }
}