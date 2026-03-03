package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.children
import ru.easycode.zerotoheroandroidtdd.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.actionButton.setOnClickListener {
            addTextView(binding.inputEditText.text.toString())
            binding.inputEditText.text?.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val list = binding.contentLayout.children.map { (it as TextView).text.toString() }.toList()
        outState.putStringArrayList(KEY_TEXT_VIEW, ArrayList(list))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val listView = savedInstanceState.getStringArrayList(KEY_TEXT_VIEW) ?: ArrayList()
        listView.forEach {
            addTextView(it)
        }
    }

    private fun addTextView(inputText: String) {
        val textView = TextView(baseContext).apply {
            text = inputText
        }
        binding.contentLayout.addView(textView)
    }

    companion object {
        const val KEY_TEXT_VIEW = "KEY_TEXT_VIEW"
    }
}