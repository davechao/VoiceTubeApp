package com.test.voicetubeapp.ui.countdown

import android.annotation.SuppressLint
import android.app.Application
import com.test.voicetubeapp.ui.base.BaseAndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CountdownViewModel @Inject constructor(app: Application): BaseAndroidViewModel(app) {

    @SuppressLint("StaticFieldLeak")
    private val applicationContext = getApplication<Application>().applicationContext

    private val compositeDisposable by lazy { CompositeDisposable() }

    var second = 0.toLong()

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}