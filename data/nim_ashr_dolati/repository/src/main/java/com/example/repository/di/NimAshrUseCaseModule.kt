package com.example.repository.di

import com.example.nim_ashr_dolati.repository.NimAshrRepository
import com.example.nim_ashr_dolati.use_cases.GetNimAshrResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NimAshrUseCaseModule {

    @Provides
    @Singleton
    fun providesGetNimAshrResultUseCase(
        nimAshrRepository: NimAshrRepository
    ): GetNimAshrResultUseCase = GetNimAshrResultUseCase(nimAshrRepository)
}