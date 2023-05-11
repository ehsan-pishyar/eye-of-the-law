package com.example.repository.data_source

import javax.inject.Inject

class DataSourceImpl @Inject constructor(): DataSource {

    override suspend fun getResult(): String {
        return Results.RESULT

    }
}