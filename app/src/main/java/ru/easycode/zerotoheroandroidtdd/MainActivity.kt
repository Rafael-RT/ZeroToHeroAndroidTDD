package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val count: Count = Count.Base(step = 2, max = 4, min = 0)
    private var uiState: UiState = UiState.Base(text = "0")

    private lateinit var textView: TextView
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.countTextView)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)

        uiState = count.initial(textView.text.toString())
        uiState.apply(textView, incrementButton, decrementButton)

        incrementButton.setOnClickListener {
            uiState = count.increment(number = textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }

        decrementButton.setOnClickListener {
            uiState = count.decrement(number = textView.text.toString())
            uiState.apply(textView, incrementButton, decrementButton)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        uiState = count.initial(textView.text.toString())
        uiState.apply(textView, incrementButton, decrementButton)
    }
}