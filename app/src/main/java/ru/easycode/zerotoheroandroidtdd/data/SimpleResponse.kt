package ru.easycode.zerotoheroandroidtdd.data

import com.google.gson.annotations.SerializedName

data class SimpleResponse (
    @SerializedName("text")
    val text: String
)
