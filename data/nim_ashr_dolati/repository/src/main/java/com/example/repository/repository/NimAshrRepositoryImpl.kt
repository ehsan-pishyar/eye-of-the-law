package com.example.repository.repository

import com.example.nim_ashr_dolati.repository.NimAshrRepository
import com.example.repository.data_source.NimAshrDataSource
import javax.inject.Inject

class NimAshrRepositoryImpl @Inject constructor(
    private val nimAshrDataSource: NimAshrDataSource
): NimAshrRepository {

    override suspend fun getNimAshrResult(): String =
        nimAshrDataSource.getNimAshrResult()
}