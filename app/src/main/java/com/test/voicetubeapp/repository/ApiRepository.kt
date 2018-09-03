package com.test.voicetubeapp.repository

import com.test.voicetubeapp.repository.model.ApiItem
import com.test.voicetubeapp.repository.model.ApiRequest
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiService: ApiService) {

    fun fetchVideos(apiRequest: ApiRequest): Single<ApiItem> = apiService.fetchVideos(apiRequest)

}