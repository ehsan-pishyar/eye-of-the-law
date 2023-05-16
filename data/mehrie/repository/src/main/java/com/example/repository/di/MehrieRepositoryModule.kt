package com.example.repository.di

import com.example.mehrie.repository.MehrieCoinRepository
import com.example.mehrie.repository.MehrieMoneyRepository
import com.example.repository.data_source.MehrieCoinDataSource
import com.example.repository.data_source.MehrieCoinDataSourceImpl
import com.example.repository.data_source.MehrieMoneyDataSource
import com.example.repository.data_source.MehrieMoneyDataSourceImpl
import com.example.repository.repository.MehrieCoinRepositoryImpl
import com.example.repository.repository.MehrieMoneyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface MehrieRepositoryModule {

    @Binds
    fun bindsMehrieMoneyDataSource(impl: MehrieMoneyDataSourceImpl): MehrieMoneyDataSource

    @Binds
    fun bindsMehrieCoinDataSource(impl: MehrieCoinDataSourceImpl): MehrieCoinDataSource

    @Binds
    fun bindsMehrieMoneyRepository(impl: MehrieMoneyRepositoryImpl): MehrieMoneyRepository

    @Binds
    fun bindsMehrieCoinRepository(impl: MehrieCoinRepositoryImpl): MehrieCoinRepository
}