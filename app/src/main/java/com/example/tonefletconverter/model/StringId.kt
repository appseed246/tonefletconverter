package com.example.tonefletconverter.model

import androidx.annotation.IntRange

/**
 * 弦を一意に識別するための番号。1オリジン。
 * @property number 弦の識別番号。
 */
data class StringId(@IntRange(from = 1) val number: Int)