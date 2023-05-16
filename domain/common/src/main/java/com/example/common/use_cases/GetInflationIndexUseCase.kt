package com.example.common.use_cases

import com.example.common.models.InflationIndexResponse
import com.example.common.repository.InflationIndexRepository
import kotlinx.coroutines.flow.Flow

class GetInflationIndexUseCase constructor(
    private val inflationIndexRepository: InflationIndexRepository
) {

    operator fun invoke(): Flow<InflationIndexResponse> =
        inflationIndexRepository.getInflationIndex()
}