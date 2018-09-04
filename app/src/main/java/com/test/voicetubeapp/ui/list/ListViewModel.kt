package com.test.voicetubeapp.ui.list

import android.annotation.SuppressLint
import android.app.Application
import android.arch.lifecycle.MutableLiveData
import com.test.voicetubeapp.R
import com.test.voicetubeapp.event.SingleLiveEvent
import com.test.voicetubeapp.repository.ApiRepository
import com.test.voicetubeapp.repository.model.VideoItem
import com.test.voicetubeapp.ui.base.BaseAndroidViewModel
import com.test.voicetubeapp.utils.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import timber.log.Timber
import javax.inject.Inject

class ListViewModel @Inject constructor(
        app: Application,
        private val schedulerProvider: SchedulerProvider,
        private val apiRepository: ApiRepository)
    : BaseAndroidViewModel(app) {

    @SuppressLint("StaticFieldLeak")
    private val applicationContext = getApplication<Application>().applicationContext

    private val compositeDisposable by lazy { CompositeDisposable() }

    var videosLiveData: MutableLiveData<ArrayList<VideoItem>> = MutableLiveData()
    var toastLiveData: SingleLiveEvent<String> = SingleLiveEvent()

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    fun fetchData() {
        compositeDisposable.add(
                apiRepository.fetchVideos("VoiceTube")
                        .compose(schedulerProvider.getSchedulersForSingle())
                        .subscribeBy(
                                onSuccess = {
                                    if(it.status == "success") {
                                        videosLiveData.value = it.videos
                                    } else {
                                        toastLiveData.value = applicationContext.getString(R.string.server_not_available)
                                    }
                                },
                                onError = {
                                    Timber.d(it.toString())
                                }
                        )
        )
    }

}