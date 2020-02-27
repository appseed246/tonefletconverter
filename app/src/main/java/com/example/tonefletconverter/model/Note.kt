package com.example.tonefletconverter.model

import com.example.tonefletconverter.model.Accidental.*

/**
 * 音名
 * @property id 音名を識別するための整数値。A~G#まで順に0〜11が割り振られる。
 * @property accidental 音名に付与されている変化記号
 * @property toneName 音の表記上の名前
 */
enum class Note(val id: NoteId, val accidental: Accidental, val toneName: String) {
    A(NoteId(0), Natural, "A"),
    Ais(NoteId(1), Sharp, "A#"),
    B(NoteId(1), Flat, "B♭"),
    H(NoteId(2), Natural, "B"),
    C(NoteId(3), Natural, "C"),
    Cis(NoteId(4), Sharp, "C#"),
    Des(NoteId(4), Flat, "D♭"),
    D(NoteId(5), Natural, "D"),
    Dis(NoteId(6), Sharp, "D#"),
    Es(NoteId(6), Flat, "E♭"),
    E(NoteId(7), Natural, "E"),
    F(NoteId(8), Natural, "F"),
    Fis(NoteId(9), Sharp, "F#"),
    Ges(NoteId(9), Flat, "G♭"),
    G(NoteId(10), Natural, "G"),
    Gis(NoteId(11), Sharp, "G#"),
    As(NoteId(11), Flat, "A♭");

    companion object {
        /**
         * 引数で指定した音階番号と変化記号に一致するノートを取得する。
         * @param id 取得対象の音階番号
         * @param accidental 取得対象の変化記号
         * @return 引数で指定した条件と一致するノート。一致するノートが存在しない場合null。
         */
        fun fromId(id: NoteId, accidental: Accidental): Note? {
            return values().firstOrNull { it.accidental == accidental && it.id == id }
        }

        /**
         * 引数で渡した音階番号に一致する音をすべて取得する
         * @param id 取得対象の音階番号
         * @return 指定した音階番号と一致する音のリスト
         */
        fun fromId(id: NoteId): List<Note> {
            return values().filter { it.id == id }
        }
    }
}

