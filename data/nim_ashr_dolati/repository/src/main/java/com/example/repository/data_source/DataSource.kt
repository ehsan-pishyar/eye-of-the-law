package com.example.repository.data_source

import com.example.nim_ashr_dolati.models.ResultResponse

interface DataSource {
    suspend fun getResult(): ResultResponse
}