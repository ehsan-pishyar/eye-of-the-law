package com.example.repository.data_source

interface DataSource {
    suspend fun getResult(): String
}