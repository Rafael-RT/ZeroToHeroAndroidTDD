package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var titleText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.changeButton)
        titleText = findViewById(R.id.titleTextView)

        button.setOnClickListener {
            titleText.text = "I am an Android Developer!"
        }

        savedInstanceState?.let {
            titleText.text = it.getString("TitleTextViewKey")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("TitleTextViewKey", titleText.text.toString())
    }
}