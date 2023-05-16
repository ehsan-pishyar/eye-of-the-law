package com.example.repository.repository

import com.example.mehrie.repository.MehrieMoneyRepository
import com.example.repository.data_source.MehrieMoneyDataSource
import javax.inject.Inject

class MehrieMoneyRepositoryImpl @Inject constructor(
    private val dataSource: MehrieMoneyDataSource
): MehrieMoneyRepository {

    override suspend fun getMehrieMoneyResult(): String =
        dataSource.getMehrieMoneyResult()

    override suspend fun getMehrieMoneyDocsTabsare1082(): String =
        dataSource.getMehrieMoneyDocsTabsare1082()

    override suspend fun getMehrieMoneyDocsMade3(): String =
        dataSource.getMehrieMoneyDocsMade3()
}