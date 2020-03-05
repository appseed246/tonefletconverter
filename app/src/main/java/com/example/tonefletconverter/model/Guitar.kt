package com.example.tonefletconverter.model

import android.util.Log
import androidx.annotation.IntRange

/**
 * ギターオブジェクト
 * @property strings 弦の本数
 * @property frets フレット数
 */
class Guitar(
    @IntRange(from = 1, to = 7) val strings: Int,
    @IntRange(from = 12, to = 12) val frets: Int
) {
    companion object {
        private val TAG = Guitar::class.java.simpleName
    }

    /**
     * 弦とフレットから音階番号を取得する
     * @param string 弦の識別子
     * @param fret フレット番号
     */
    fun getNoteIdByPosition(string: StringId, fret: Fret): NoteId {
        Log.d(TAG, "getNoteIdByPosition")
        if (string.number > strings) {
            throw IllegalArgumentException("this guitar has $strings strings, but specified ${string.number}th string.")
        }
        if (fret.number > frets) {
            throw IllegalArgumentException("this guitar has $frets frets, but specified ${fret.number}th fret.")
        }
        return FretBoard.getNoteIdByPosition(string, fret)
    }
}