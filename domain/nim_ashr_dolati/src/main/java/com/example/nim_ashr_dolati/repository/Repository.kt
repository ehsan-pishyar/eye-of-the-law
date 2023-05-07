package com.example.nim_ashr_dolati.repository

import com.example.nim_ashr_dolati.models.ResultResponse
import kotlinx.coroutines.flow.Flow

interface Repository {

    fun getResult(): Flow<ResultResponse>
}