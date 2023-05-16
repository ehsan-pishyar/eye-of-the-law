package com.example.inflation_index.di

import com.example.common.repository.InflationIndexRepository
import com.example.inflation_index.repository.InflationIndexRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface InflationIndexRepositoryModule {

    @Binds
    fun bindsInflationIndexRepository(
        impl: InflationIndexRepositoryImpl
    ): InflationIndexRepository
}