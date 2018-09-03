package com.test.voicetubeapp.repository.model

import com.google.gson.annotations.SerializedName

data class ApiRequest(

        @SerializedName("key")
        var key: String = ""
)