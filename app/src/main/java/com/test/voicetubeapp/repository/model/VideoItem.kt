package com.test.voicetubeapp.repository.model

import com.google.gson.annotations.SerializedName

data class VideoItem(

        @SerializedName("title")
        val title: String = "",

        @SerializedName("img")
        val img: String = ""
)