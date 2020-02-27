package com.example.tonefletconverter.model

/**
 * 音階名を識別するための整数値
 */
data class NoteId(val value: Int) {
    init {
        require(value in 0..11)
    }
}