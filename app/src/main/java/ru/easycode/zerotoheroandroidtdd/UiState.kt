package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable{
    fun apply(textView: TextView, incrementButton: Button, decrementButton: Button)

    abstract class Abstract(private val text: String) : UiState {
        override fun apply(textView: TextView, incrementButton: Button, decrementButton: Button) {
            textView.text = text
            incrementButton.isEnabled = true
            decrementButton.isEnabled = true
        }
    }

    data class Base(private val text: String) : Abstract(text)

    data class Min(private val text: String) : Abstract(text) {

        override fun apply(
            textView: TextView,
            incrementButton: Button,
            decrementButton: Button
        ) {
            super.apply(textView, incrementButton, decrementButton)
            incrementButton.isEnabled = true
            decrementButton.isEnabled = false
        }
    }

    data class Max(private val text: String) : Abstract(text) {

        override fun apply(
            textView: TextView,
            incrementButton: Button,
            decrementButton: Button
        ) {
            super.apply(textView, incrementButton, decrementButton)
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
        }
    }

}
