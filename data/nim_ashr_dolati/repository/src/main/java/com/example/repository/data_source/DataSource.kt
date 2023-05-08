package com.example.repository.data_source

interface DataSource {
    suspend fun getResult(): String
    suspend fun getResult2(): String
}