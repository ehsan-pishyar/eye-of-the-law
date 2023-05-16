package com.example.repository.di

import com.example.nim_ashr_dolati.repository.NimAshrRepository
import com.example.repository.data_source.NimAshrDataSource
import com.example.repository.data_source.NimAshrDataSourceImpl
import com.example.repository.repository.NimAshrRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface NimAshrRepositoryModule {

    @Binds
    fun bindsNimAshrDataSource(impl: NimAshrDataSourceImpl): NimAshrDataSource

    @Binds
    fun bindsNimAshrRepository(impl: NimAshrRepositoryImpl): NimAshrRepository
}