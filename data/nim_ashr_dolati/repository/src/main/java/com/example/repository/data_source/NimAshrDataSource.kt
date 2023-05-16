package com.example.repository.data_source

interface NimAshrDataSource {
    suspend fun getNimAshrResult(): String
}