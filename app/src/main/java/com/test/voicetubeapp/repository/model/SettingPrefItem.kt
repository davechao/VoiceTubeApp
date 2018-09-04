package com.test.voicetubeapp.repository.model

import com.google.gson.annotations.SerializedName

data class SettingPrefItem(

        @SerializedName("autoPlay")
        val autoPlay: Boolean? = false,

        @SerializedName("subtitleSync")
        val subtitleSync: Boolean? = false,

        @SerializedName("pause")
        val pause: Boolean? = false,

        @SerializedName("reminder")
        val reminder: Boolean? = false,

        @SerializedName("notification")
        val notification: Boolean? = false

)