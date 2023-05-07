package com.example.repository.di

import com.example.nim_ashr_dolati.repository.Repository
import com.example.repository.data_source.DataSource
import com.example.repository.data_source.DataSourceImpl
import com.example.repository.repository.RepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindsDataSource(impl: DataSourceImpl): DataSource

    @Binds
    fun bindsRepository(impl: RepositoryImpl): Repository
}