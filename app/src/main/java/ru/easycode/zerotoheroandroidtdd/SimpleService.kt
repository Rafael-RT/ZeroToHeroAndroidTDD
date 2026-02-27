package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.delay
import retrofit2.http.GET
import retrofit2.http.Url

interface SimpleService {
    @GET
    suspend fun fetch(
        @Url url: String
    ): SimpleResponse

    class Base : SimpleService {
        @GET
        override suspend fun fetch(@Url url: String): SimpleResponse {
            delay(3000)
            return SimpleResponse(text = "Hello World From Web!")
        }
    }
}
