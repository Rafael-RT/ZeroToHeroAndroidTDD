package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface UiState {
    fun apply(button: Button, textView: TextView, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun apply(button: Button, textView: TextView, progressBar: ProgressBar) {
            textView.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
            button.isEnabled = true
        }
    }
}
