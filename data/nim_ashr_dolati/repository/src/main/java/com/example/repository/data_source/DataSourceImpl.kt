package com.example.repository.data_source

import javax.inject.Inject

class DataSourceImpl @Inject constructor(): DataSource {

    override suspend fun getResult(): String {
        return Results.RESULT

    }

    override suspend fun getResult2(): String {
        return Results.RESULT2
    }
}