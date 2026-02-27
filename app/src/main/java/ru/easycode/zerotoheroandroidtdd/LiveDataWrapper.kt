package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {
    interface Save : LiveDataWrapper {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update : LiveDataWrapper {
        fun update(value: UiState)
    }

    interface Mutable : Save, Update {
        fun liveData(): LiveData<UiState>
    }

    class Base(
        private val liveData: MutableLiveData<UiState> = SingleLiveEvent()
    ) : Mutable {
        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let {
                bundleWrapper.save(it)
            }
        }

        override fun liveData(): LiveData<UiState> = liveData

        override fun update(value: UiState) {
            liveData.value = value
        }
    }
}
