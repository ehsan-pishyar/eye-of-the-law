package com.example.repository.repository

import com.example.nim_ashr_dolati.models.ResultResponse
import com.example.nim_ashr_dolati.repository.Repository
import com.example.repository.data_source.DataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource
): Repository {

    override fun getResult(): Flow<ResultResponse> = flow {
        emit(dataSource.getResult())
    }
}