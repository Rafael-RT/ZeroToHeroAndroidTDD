package ru.easycode.zerotoheroandroidtdd

import java.io.Serializable

interface Count : Serializable {
    fun increment(number: String): String

    class Base(private val step: Int) : Count {
        init {
            if (step <= 0) {
                throw IllegalStateException("step should be positive, but was $step")
            }
        }

        override fun increment(number: String): String {
            val numberInt = number.toInt() + step
            return numberInt.toString()
        }
    }
}