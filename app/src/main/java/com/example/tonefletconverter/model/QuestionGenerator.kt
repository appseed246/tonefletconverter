package com.example.tonefletconverter.model

import android.util.Log

/**
 * 問題文生成クラス
 * @property guitar 出題元となるギターのスペック
 */
class QuestionGenerator(private val guitar: Guitar) {

    // 問題文
    lateinit var question: String private set

    // questionの回答
    lateinit var answer: String private set

    // 出題範囲
    private val stringsRange = 1..guitar.strings
    private val fretsRange = 0..guitar.frets

    companion object {
        private val TAG = QuestionGenerator::class.java.simpleName
    }

    init {
        // インスタンス生成時に問題を生成する
        generateNext()
    }

    /**
     * 問題文と答えを生成し、プロパティにセットする。
     * 生成された内容は[question],[answer]から取得する。
     */
    fun generateNext() {
        Log.d(TAG, "generate")

        val string = StringId(stringsRange.random())
        val fret = Fret(fretsRange.random())
        val note = guitar.getNoteIdByPosition(string, fret)
        question = "${string.number}弦の${fret.number}フレット"

        Log.d(TAG, "question: $question")

        val candidates = Note.fromId(note)
        answer = candidates.find {
            it.accidental == Accidental.Natural || it.accidental == Accidental.Sharp
        }!!.toneName

        Log.d(TAG, "answer: $answer")
    }
}