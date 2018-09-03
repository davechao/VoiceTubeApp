package com.test.voicetubeapp.ui.list

import android.annotation.SuppressLint
import android.app.Application
import com.test.voicetubeapp.ui.base.BaseAndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class ListViewModel @Inject constructor(app: Application): BaseAndroidViewModel(app) {

    @SuppressLint("StaticFieldLeak")
    private val applicationContext = getApplication<Application>().applicationContext

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

}