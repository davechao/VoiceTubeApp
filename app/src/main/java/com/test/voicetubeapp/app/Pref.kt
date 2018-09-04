package com.test.voicetubeapp.app

import android.content.Context
import com.google.gson.Gson
import com.test.voicetubeapp.repository.model.SettingPrefItem

class Pref(private val gson: Gson, context: Context, preferenceFileName: String) : AbstractPref(context, preferenceFileName) {

    private val settingPref = StringPref("SETTING_PREF")

    var settingPrefItem: SettingPrefItem
        get() =
            try {
                gson.fromJson<SettingPrefItem>(settingPref.get(), SettingPrefItem::class.java)
            } catch (e: Exception) {
                SettingPrefItem()
            }
        set(item) {
            settingPref.set(gson.toJson(item))
        }

}