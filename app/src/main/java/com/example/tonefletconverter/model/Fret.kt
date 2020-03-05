package com.example.tonefletconverter.model

import androidx.annotation.IntRange

/**
 * フレットクラス
 * @property number フレット番号。0は開放弦を表し、1以降は1フレット以降に対応する。
 */
data class Fret(@IntRange(from = 0) val number: Int)