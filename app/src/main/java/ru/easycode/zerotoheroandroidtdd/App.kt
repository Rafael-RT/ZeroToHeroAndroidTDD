package ru.easycode.zerotoheroandroidtdd

import android.app.Application
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {
    private lateinit var service: SimpleService
    lateinit var viewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.google.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(SimpleService::class.java)

        viewModel = MainViewModel(
            LiveDataWrapper.Base(),
            Repository.Base(
                service,
                URL
            )
        )
    }

    companion object {
        private const val URL =
            "https://raw.githubusercontent.com/JohnnySC/ZeroToHeroAndroidTDD/task/018-clouddatasource/app/sampleresponse.json"
    }
}