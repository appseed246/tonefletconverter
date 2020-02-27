package com.example.tonefletconverter.model

/**
 * 弦を一意に識別するための番号。1オリジン。
 */
data class StringId(val value: Int) {
    init {
        require(value >= 1)
    }
}