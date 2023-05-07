package com.example.repository.data_source

import com.example.nim_ashr_dolati.models.ResultResponse
import javax.inject.Inject

class DataSourceImpl @Inject constructor(): DataSource {

    override suspend fun getResult(): ResultResponse {
        return Results.results[0]
    }
}