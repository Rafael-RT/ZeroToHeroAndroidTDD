package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val count: Count = Count.Base(step = 2, max = 4)
    private var uiState: UiState = UiState.Base(text = "0")
    private lateinit var button: Button
    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.countTextView)
        button = findViewById(R.id.incrementButton)

        uiState.apply(textView)

        button.setOnClickListener {
            uiState = count.increment(textView.text.toString())
            uiState.apply(textView)
            button.isEnabled = uiState !is UiState.Max
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_ENABLED, button.isEnabled)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        button.isEnabled = savedInstanceState.getBoolean(KEY_ENABLED)
    }

    companion object {
        private const val KEY_ENABLED = "KEY_ENABLED"
    }
}