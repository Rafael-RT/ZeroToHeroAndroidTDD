package ru.easycode.zerotoheroandroidtdd.data

import ru.easycode.zerotoheroandroidtdd.LiveDataWrapper
import ru.easycode.zerotoheroandroidtdd.UiState

interface LoadResult {
    fun show(updateLiveData: LiveDataWrapper.Update)

    data class Success(val data: SimpleResponse) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            updateLiveData.update(UiState.ShowData(text = data.text))
        }
    }

    data class Error(val noConnection: Boolean) : LoadResult {
        override fun show(updateLiveData: LiveDataWrapper.Update) {
            val text = if (noConnection) "No internet connection" else "Something went wrong"
            updateLiveData.update(UiState.ShowData(text))
        }
    }
}