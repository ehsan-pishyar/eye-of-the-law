package com.example.nim_ashr_dolati.use_cases

import com.example.nim_ashr_dolati.models.ResultResponse
import com.example.nim_ashr_dolati.repository.Repository
import kotlinx.coroutines.flow.Flow

class GetResultUseCase(
    private val repository: Repository
) {

    operator fun invoke(): Flow<ResultResponse> =
        repository.getResult()
}