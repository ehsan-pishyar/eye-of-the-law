package com.example.inflation_index.mappers

import com.example.common.models.InflationIndexResponse
import com.example.common.models.Month
import com.example.common.models.Year
import com.example.inflation_index.models.InflationIndexResponseLocal
import com.example.inflation_index.models.MonthLocal
import com.example.inflation_index.models.YearLocal

fun MonthLocal.toDomain(): Month {
    return Month(
        this.month,
        this.inflationIndex
    )
}

fun YearLocal.toDomain(): Year {
    return Year(
        this.year,
        this.monthLocals.map { it.toDomain() },
        this.inflationIndex,
        this.percentageChanges
    )
}

fun InflationIndexResponseLocal.toDomain(): InflationIndexResponse {
    return InflationIndexResponse(
        this.years.map { it.toDomain() }
    )
}