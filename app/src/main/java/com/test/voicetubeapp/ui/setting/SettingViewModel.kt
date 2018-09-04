package com.test.voicetubeapp.ui.setting

import android.annotation.SuppressLint
import android.app.Application
import com.test.voicetubeapp.R
import com.test.voicetubeapp.app.Pref
import com.test.voicetubeapp.repository.model.SettingItem
import com.test.voicetubeapp.repository.model.SettingPrefItem
import com.test.voicetubeapp.ui.base.BaseAndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class SettingViewModel @Inject constructor(
        app: Application,
        private val pref: Pref)
    : BaseAndroidViewModel(app) {

    @SuppressLint("StaticFieldLeak")
    private val applicationContext = getApplication<Application>().applicationContext

    private val compositeDisposable by lazy { CompositeDisposable() }

    val settingList: MutableList<Any> = arrayListOf()
    val settingMap: MutableMap<String, Boolean> = hashMapOf()

    override fun onCleared() {
        compositeDisposable.clear()
        compositeDisposable.dispose()
    }

    fun initData() {
        var autoPlay = false
        var subtitleSync = false
        var pause = false
        var reminder = false
        var notification = false

        if(pref.settingPrefItem.autoPlay != null) {
            autoPlay = pref.settingPrefItem.autoPlay!!
        }

        if(pref.settingPrefItem.subtitleSync != null) {
            subtitleSync = pref.settingPrefItem.subtitleSync!!
        }

        if(pref.settingPrefItem.pause != null) {
            pause = pref.settingPrefItem.pause!!
        }

        if(pref.settingPrefItem.reminder != null) {
            reminder = pref.settingPrefItem.reminder!!
        }

        if(pref.settingPrefItem.notification != null) {
            notification = pref.settingPrefItem.notification!!
        }

        settingList.add(applicationContext.getString(R.string.video_header))
        settingList.add(SettingItem(applicationContext.getString(R.string.auto_play), autoPlay))
        settingList.add(SettingItem(applicationContext.getString(R.string.subtitle_sync), subtitleSync))
        settingList.add(SettingItem(applicationContext.getString(R.string.pause), pause))
        settingList.add(SettingItem(applicationContext.getString(R.string.reminder), reminder))

        settingList.add(applicationContext.getString(R.string.notification_header))
        settingList.add(SettingItem(applicationContext.getString(R.string.notification), notification))

        settingList.forEach {
            if(it is SettingItem) {
                settingMap[it.name] = it.isOpen
            }
        }
    }

    fun storeSetting(settingMap: MutableMap<String, Boolean>) {

        val autoPlay = settingMap[applicationContext.getString(R.string.auto_play)]
        val subtitleSync = settingMap[applicationContext.getString(R.string.subtitle_sync)]
        val pause = settingMap[applicationContext.getString(R.string.pause)]
        val reminder = settingMap[applicationContext.getString(R.string.reminder)]
        val notification = settingMap[applicationContext.getString(R.string.notification)]

        val settingPrefItem = SettingPrefItem(
                autoPlay,
                subtitleSync,
                pause,
                reminder,
                notification
        )

        pref.settingPrefItem = settingPrefItem
    }

}