package com.test.voicetubeapp.repository.model

import com.google.gson.annotations.SerializedName

data class ApiItem(

        @SerializedName("status")
        val status: String = "",

        @SerializedName("videos")
        val videos: ArrayList<VideoItem>? = arrayListOf()
)