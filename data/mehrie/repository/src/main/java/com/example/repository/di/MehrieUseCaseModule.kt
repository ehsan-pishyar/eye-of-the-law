package com.example.repository.di

import com.example.mehrie.repository.MehrieCoinRepository
import com.example.mehrie.repository.MehrieMoneyRepository
import com.example.mehrie.use_cases.GetMehrieCoinResultUseCase
import com.example.mehrie.use_cases.GetMehrieMoneyResultUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MehrieUseCaseModule {

    @[Provides Singleton]
    fun providesGetMehrieMoneyResultUseCase(
        repository: MehrieMoneyRepository
    ): GetMehrieMoneyResultUseCase = GetMehrieMoneyResultUseCase(repository)

    @[Provides Singleton]
    fun providesGetMehrieCoinResultUseCase(
        repository: MehrieCoinRepository
    ): GetMehrieCoinResultUseCase = GetMehrieCoinResultUseCase(repository)
}