package com.example.tonefletconverter.model

/**
 * フレットボート上のフレット番号と音名の対応を管理する
 */
object FretBoard {
    // 1-6弦の音階番号
    private val string1 = listOf(7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7)
    private val string2 = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2)
    private val string3 = listOf(10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    private val string4 = listOf(5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5)
    private val string5 = listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0)
    private val string6 = listOf(7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7)
    private val board = listOf(string1, string2, string3, string4, string5, string6)

    /**
     * 弦とフレットから音階番号を取得する
     * @param string 弦の識別子
     * @param fret フレット番号
     */
    fun getNoteIdByPosition(string: StringId, fret: Fret): NoteId {
        return NoteId(board[string.number][fret.number])
    }
}