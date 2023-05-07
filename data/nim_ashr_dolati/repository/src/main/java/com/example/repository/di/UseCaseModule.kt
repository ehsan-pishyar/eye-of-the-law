package com.example.repository.di

import com.example.nim_ashr_dolati.repository.Repository
import com.example.nim_ashr_dolati.use_cases.GetResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun providesGetResultUseCase(
        repository: Repository
    ): GetResultUseCase = GetResultUseCase(repository)
}