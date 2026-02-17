package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(button: Button, text: TextView, progressBar: ProgressBar)

    object ShowProgress : UiState {
        override fun apply(button: Button, text: TextView, progressBar: ProgressBar) {
            button.isEnabled = false
            text.visibility = View.GONE
            progressBar.visibility = View.VISIBLE
        }
    }

    object ShowData : UiState {
        override fun apply(button: Button, text: TextView, progressBar: ProgressBar) {
            button.isEnabled = true
            text.visibility = View.VISIBLE
            progressBar.visibility = View.GONE
        }
    }
}