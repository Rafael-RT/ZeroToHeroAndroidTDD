package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {
    interface Save : BundleWrapper {
        fun save(uiState: UiState)
    }

    interface Restore : BundleWrapper {
        fun restore(): UiState
    }

    interface Mutable : Restore, Save

    class Base(private val bundle: Bundle) : Mutable {
        override fun restore(): UiState {
            return bundle.getSerializable(KEY) as UiState
        }

        override fun save(uiState: UiState) {
            bundle.putSerializable(KEY, uiState)
        }

        companion object {
            private const val KEY = "KEY"
        }
    }
}
