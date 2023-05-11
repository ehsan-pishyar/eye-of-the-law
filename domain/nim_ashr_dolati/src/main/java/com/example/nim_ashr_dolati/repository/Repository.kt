package com.example.nim_ashr_dolati.repository

interface Repository {

    suspend fun getResult(): String
}