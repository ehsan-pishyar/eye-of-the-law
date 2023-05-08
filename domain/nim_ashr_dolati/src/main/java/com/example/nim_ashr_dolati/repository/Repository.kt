package com.example.nim_ashr_dolati.repository

interface Repository {

    suspend fun getResult(): String
    suspend fun getResult2(): String
}