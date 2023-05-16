package com.example.common.models

data class Year(
    val year: String,
    val months: List<Month>,
    val inflationIndex: Double?,
    val percentageChanges: Double?
)