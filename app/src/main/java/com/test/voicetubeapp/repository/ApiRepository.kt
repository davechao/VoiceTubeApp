package com.test.voicetubeapp.repository

import com.test.voicetubeapp.repository.model.ApiItem
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiRepository @Inject constructor(private val apiService: ApiService) {

    fun fetchVideos(key: String): Single<ApiItem> = apiService.fetchVideos(key)

}