package com.idaxmx.myapplication.util.extension

enum class MaxHeight(val meters: Float) {
    TWO(2f),
    THREE(3f),
    FOUR(4f),
    FIVE(5f),
}

fun Float.convertHeightToPercentageBase2m(): Float = 1 - (this / MaxHeight.TWO.meters)

fun Float.reverseHeightPercentageBase2m(): String = "${-2 * (this - 1)}m"