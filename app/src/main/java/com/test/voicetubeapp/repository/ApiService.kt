package com.test.voicetubeapp.repository

import com.test.voicetubeapp.repository.model.ApiItem
import io.reactivex.Single
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("/thirdparty/test.php")
    fun fetchVideos(@Field("key") token: String): Single<ApiItem>

}