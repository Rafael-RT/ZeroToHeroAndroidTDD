package ru.easycode.zerotoheroandroidtdd.data

import java.net.UnknownHostException

interface Repository {
    suspend fun load(): LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ) : Repository {
        override suspend fun load(): LoadResult =
            runCatching {
                val result = service.fetch(url = url)
                LoadResult.Success(result)
            }.getOrElse {
                LoadResult.Error(noConnection = it is UnknownHostException)
            }
    }
}
