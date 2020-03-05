package com.example.tonefletconverter.model

import androidx.annotation.IntRange

/**
 * 音階名を識別するための整数値
 */
data class NoteId(@IntRange(from = 0, to = 11) val value: Int)