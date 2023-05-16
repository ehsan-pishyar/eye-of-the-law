package com.example.common.repository

import com.example.common.models.InflationIndexResponse
import com.example.common.models.Year
import kotlinx.coroutines.flow.Flow

interface InflationIndexRepository {

    fun getInflationIndex(): Flow<InflationIndexResponse>
}