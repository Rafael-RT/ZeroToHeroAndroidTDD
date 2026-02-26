package ru.easycode.zerotoheroandroidtdd

import android.app.Application

class App : Application() {
    val viewModel = MainViewModel(liveDataWrapper = LiveDataWrapper.Base(), repository = Repository.Base())
}
