package com.idaxmx.myapplication.util.extension

enum class MaxHeight(val meters: Float) {
    TWO(2f),
    THREE(3f),
    FOUR(4f),
    FIVE(5f),
}

fun Float.convertHeightToPercentage(base: MaxHeight): Float = 1 - (this / base.meters)
fun Float.reverseHeightPercentage(base: Int): String = "${-base * (this - 1)}m"