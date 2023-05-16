package com.example.inflation_index.repository

import com.example.common.models.InflationIndexResponse
import com.example.common.models.Year
import com.example.common.repository.InflationIndexRepository
import com.example.inflation_index.data_source.InflationIndex
import com.example.inflation_index.mappers.toDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class InflationIndexRepositoryImpl @Inject constructor(): InflationIndexRepository {

    override fun getInflationIndex(): Flow<InflationIndexResponse> = flow {
        val response = InflationIndex.response
        println("Local Response: " +
                "Year: ${response.years[0].year}, " +
                "Month: ${response.years[0].monthLocals[0].month}, " +
                "Year Inflation Index: ${response.years[0].inflationIndex}, " +
                "Month Inflation Index: ${response.years[0].monthLocals[0].inflationIndex}, " +
                "Year Percentage Changes ${response.years[0].percentageChanges}")
        emit(response.toDomain())
    }
}