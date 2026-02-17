package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper,
    private val repository: Repository,
) {
    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

    fun load() {
        scope.launch {
            liveDataWrapper.update(UiState.ShowProgress)
            repository.load()
            liveDataWrapper.update(UiState.ShowData)
        }
    }
}
