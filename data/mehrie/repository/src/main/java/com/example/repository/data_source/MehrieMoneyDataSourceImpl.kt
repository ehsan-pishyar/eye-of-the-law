package com.example.repository.data_source

import javax.inject.Inject

class MehrieMoneyDataSourceImpl @Inject constructor(): MehrieMoneyDataSource {

    override fun getMehrieMoneyResult(): String =
        MehriesResults.MEHRIE_MONEY_RESULT

    override fun getMehrieMoneyDocsTabsare1082(): String =
        MehriesResults.MEHRIE_DOCS_TABSARE_MADE_1082

    override fun getMehrieMoneyDocsMade3(): String =
        MehriesResults.MEHRIE_DOCS_MADE_3
}