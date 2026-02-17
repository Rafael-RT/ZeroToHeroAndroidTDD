package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private val liveDataWrapper = LiveDataWrapper.Base()
    private val repository = Repository.Base()
    private val viewModel = MainViewModel(liveDataWrapper, repository)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionButton = findViewById<Button>(R.id.actionButton)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)
        val titleTextView = findViewById<TextView>(R.id.titleTextView)

        actionButton.setOnClickListener {
            viewModel.load()
        }

        liveDataWrapper.liveData().observe(this) {
            it.apply(button = actionButton, textView = titleTextView, progressBar = progressBar)
        }
    }
}