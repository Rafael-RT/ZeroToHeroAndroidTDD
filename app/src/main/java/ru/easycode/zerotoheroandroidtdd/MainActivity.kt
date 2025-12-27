package ru.easycode.zerotoheroandroidtdd

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private lateinit var titleView: TextView
    private lateinit var button: Button
    private lateinit var root: LinearLayout
    private var state: State = State.Initial

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        root = findViewById(R.id.rootLayout)
        titleView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        button.setOnClickListener {
            state = State.Removed
            state.apply(root, titleView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            savedInstanceState.getSerializable(KEY, State::class.java) as State
        } else {
            savedInstanceState.getSerializable(KEY) as State
        }
        state.apply(root, titleView)
    }

    companion object {
        private const val KEY = "key"
    }
}

interface State : Serializable {
    fun apply(linearLayout: LinearLayout, textView: TextView)

    object Initial : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) = Unit
    }

    object Removed : State {
        override fun apply(linearLayout: LinearLayout, textView: TextView) {
            linearLayout.removeView(textView)
        }
    }
}