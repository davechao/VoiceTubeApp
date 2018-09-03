package com.test.voicetubeapp.repository

import com.test.voicetubeapp.repository.model.ApiItem
import com.test.voicetubeapp.repository.model.ApiRequest
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("/thirdparty/test.php")
    fun fetchVideos(@Body body: ApiRequest): Single<ApiItem>

}