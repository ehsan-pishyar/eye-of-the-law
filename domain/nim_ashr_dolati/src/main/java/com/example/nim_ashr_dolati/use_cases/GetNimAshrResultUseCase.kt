package com.example.nim_ashr_dolati.use_cases

import com.example.nim_ashr_dolati.models.NimAshrResultResponse
import com.example.nim_ashr_dolati.repository.NimAshrRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetNimAshrResultUseCase(
    private val nimAshrRepository: NimAshrRepository
) {

    operator fun invoke(amount: Long): Flow<NimAshrResultResponse> = flow {
        emit(
            NimAshrResultResponse(
                result = "${amount * 0.05}",
                description = nimAshrRepository.getNimAshrResult()
            )
        )
    }
}