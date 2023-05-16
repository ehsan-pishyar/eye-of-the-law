package com.example.repository.data_source

import javax.inject.Inject

class MehrieCoinDataSourceImpl @Inject constructor(): MehrieCoinDataSource {

    override fun getMehrieCoinResult(): String =
        MehriesResults.MEHRIE_COIN_RESULT
}