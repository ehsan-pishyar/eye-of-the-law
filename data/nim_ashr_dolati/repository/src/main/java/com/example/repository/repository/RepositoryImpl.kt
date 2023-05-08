package com.example.repository.repository

import com.example.nim_ashr_dolati.repository.Repository
import com.example.repository.data_source.DataSource
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val dataSource: DataSource
): Repository {

    override suspend fun getResult(): String =
        dataSource.getResult()

    override suspend fun getResult2(): String =
        dataSource.getResult2()

}