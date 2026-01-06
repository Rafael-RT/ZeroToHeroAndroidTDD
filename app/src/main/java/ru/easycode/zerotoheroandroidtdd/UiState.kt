package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView

interface UiState {
    fun apply(textView: TextView)

    data class Base(private val text: String) : UiState {
        override fun apply(textView: TextView) {
            textView.text = text
        }
    }

    data class Max(private val text: String) : UiState {
        override fun apply(textView: TextView) {
            textView.text = text
        }
    }
}