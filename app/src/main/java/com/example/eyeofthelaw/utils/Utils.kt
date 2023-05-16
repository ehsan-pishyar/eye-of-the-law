package com.example.eyeofthelaw.utils

fun String.separateThousands(): String {
    val regex = "(\\d)(?=(\\d{3})+\$)".toRegex()
    return this.replace(regex, "$1,")
}