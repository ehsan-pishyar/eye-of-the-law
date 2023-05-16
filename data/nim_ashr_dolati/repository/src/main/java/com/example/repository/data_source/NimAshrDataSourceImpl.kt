package com.example.repository.data_source

import javax.inject.Inject

class NimAshrDataSourceImpl @Inject constructor(): NimAshrDataSource {

    override suspend fun getNimAshrResult(): String {
        return NimAshrResults.NIM_ASHR_RESULT

    }
}