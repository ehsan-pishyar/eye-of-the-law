package com.example.mehrie.use_cases

import com.example.mehrie.models.MehrieResultResponse
import com.example.mehrie.repository.MehrieMoneyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetMehrieMoneyResultUseCase constructor(
    private val mehrieMoneyRepository: MehrieMoneyRepository
) {

    operator fun invoke(
        aghdInflationIndex: Double,
        pardakhtInflationIndex: Double,
        amount: Long
    ): Flow<MehrieResultResponse> = flow {
        val description = mehrieMoneyRepository.getMehrieMoneyResult()
        val tabsare = mehrieMoneyRepository.getMehrieMoneyDocsTabsare1082()
        val made = mehrieMoneyRepository.getMehrieMoneyDocsMade3()
        val result = (pardakhtInflationIndex / aghdInflationIndex) * amount
        val increasedAmount = result - amount

        emit(
            MehrieResultResponse(
                result = "$result",
                increasedAmount = "$increasedAmount",
                description = description,
                tabsare = tabsare,
                made = made
            )
        )
    }
}