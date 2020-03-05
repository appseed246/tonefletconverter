package com.example.tonefletconverter.model

/**
 * フレットボート上のフレット番号と音名の対応を管理する
 */
object FretBoard {
    // 1-7弦の音階番号
    private val board = listOf(
        listOf(7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7),    // 1弦
        listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2),    // 2弦
        listOf(10, 11, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10),   // 3弦
        listOf(5, 6, 7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5),    // 4弦
        listOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0),    // 5弦
        listOf(7, 8, 9, 10, 11, 0, 1, 2, 3, 4, 5, 6, 7),    // 6弦
        listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 0, 1, 2)     // 7弦
    )
    /**
     * 引数で指定した弦とフレット番号から音階番号を取得する
     * @param string 弦の識別子
     * @param fret フレット番号
     * @return 引数で指定した地点の音階番号
     */
    fun getNoteIdByPosition(string: StringId, fret: Fret): NoteId {
        return NoteId(board[string.number - 1][fret.number])
    }
}