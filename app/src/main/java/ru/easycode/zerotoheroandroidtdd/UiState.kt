package ru.easycode.zerotoheroandroidtdd

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import java.io.Serializable

interface UiState : Serializable {
    fun apply(button: Button, progressBar: ProgressBar, text: TextView)

    object ShowProgress : UiState {
        override fun apply(
            button: Button,
            progressBar: ProgressBar,
            text: TextView
        ) {
            button.isEnabled = false
            progressBar.visibility = View.VISIBLE
            text.visibility = View.GONE
        }
    }

    object ShowData : UiState {
        override fun apply(
            button: Button,
            progressBar: ProgressBar,
            text: TextView
        ) {
            button.isEnabled = true
            progressBar.visibility = View.GONE
            text.visibility = View.VISIBLE
        }

    }
}