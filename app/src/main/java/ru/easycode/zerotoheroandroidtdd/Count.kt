package ru.easycode.zerotoheroandroidtdd

interface Count {
    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            if (step < 1) {
                throw IllegalStateException("step should be positive, but was $step")
            } else if (max < 1) {
                throw IllegalStateException("max should be positive, but was $max")
            } else if (max < step) {
                throw IllegalStateException("max should be more than step")
            }
        }

        override fun increment(number: String): UiState {
            val current = number.toInt()
            val result = current + step
            return if (result > max - current) {
                UiState.Max(text = result.toString())
            } else {
                UiState.Base(text = result.toString())
            }
        }
    }
}