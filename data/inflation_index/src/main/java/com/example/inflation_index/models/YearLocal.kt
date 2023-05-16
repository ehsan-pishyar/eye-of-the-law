package com.example.inflation_index.models

data class YearLocal(
    val year: String,
    val monthLocals: List<MonthLocal>,
    val inflationIndex: Double?,
    val percentageChanges: Double?
)
