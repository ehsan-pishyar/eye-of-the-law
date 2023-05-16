package com.example.inflation_index.di

import com.example.common.repository.InflationIndexRepository
import com.example.common.use_cases.GetInflationIndexUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object InflationIndexUseCaseModule {

    @[Provides Singleton]
    fun providesGetInflationIndexUseCase(
        repository: InflationIndexRepository
    ): GetInflationIndexUseCase = GetInflationIndexUseCase(repository)
}