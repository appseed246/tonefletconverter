package com.example.tonefletconverter.model

/**
 * フレットクラス
 * @property number フレット番号。0は開放弦を表し、1以降は1フレット以降に対応する。
 */
data class Fret(val number: Int) {
    init {
        require(number in 0..12)
    }
}