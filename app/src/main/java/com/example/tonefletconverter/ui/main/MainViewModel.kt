package com.example.tonefletconverter.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tonefletconverter.model.Guitar
import com.example.tonefletconverter.model.QuestionGenerator
import com.example.tonefletconverter.model.TestState
import com.example.tonefletconverter.model.TestState.Answer
import com.example.tonefletconverter.model.TestState.Question

class MainViewModel : ViewModel() {

    companion object {
        const val TAG = "MainViewModel"
    }

    private val generator = QuestionGenerator(Guitar(6, 12))
    private val _state: MutableLiveData<TestState> = MutableLiveData(Question)
    private val _question: MutableLiveData<String> = MutableLiveData(generator.question)
    private val _answer: MutableLiveData<String> = MutableLiveData(generator.answer)

    val state: LiveData<TestState> = _state
    val question: LiveData<String> = _question
    val answer: LiveData<String> = _answer


    /**
     * 表示を切り替える
     */
    fun switchState() {
        Log.d(TAG, "switchState")
        when (state.value) {
            Question -> showAnswer()
            Answer -> showNextQuestion()
        }
    }

    /**
     * 回答を非表示にし、新しい問題を表示する。
     */
    private fun showNextQuestion() {
        Log.d(TAG, "showNextQuestion")
        generator.generateNext()
        _question.value = generator.question
        _answer.value = generator.answer
        _state.value = Question
    }

    /**
     * 現在出題されている問題の回答を表示する
     */
    private fun showAnswer() {
        Log.d(TAG, "showAnswer")
        _state.value = Answer
    }
}
