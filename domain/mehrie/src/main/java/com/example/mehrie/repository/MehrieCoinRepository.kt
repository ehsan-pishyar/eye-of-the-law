package com.example.mehrie.repository

interface MehrieCoinRepository {

    suspend fun getMehrieCoinResult(): String
}