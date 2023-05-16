package com.example.repository.repository

import com.example.mehrie.repository.MehrieCoinRepository
import com.example.repository.data_source.MehrieCoinDataSource
import javax.inject.Inject

class MehrieCoinRepositoryImpl @Inject constructor(
    private val dataSource: MehrieCoinDataSource
): MehrieCoinRepository {

    override suspend fun getMehrieCoinResult(): String =
        dataSource.getMehrieCoinResult()
}