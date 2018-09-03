package com.test.voicetubeapp.ui.main

import com.test.voicetubeapp.ui.countdown.CountdownFragment
import com.test.voicetubeapp.ui.list.ListFragment
import com.test.voicetubeapp.ui.setting.SettingFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainFragmentProvider {

    @ContributesAndroidInjector
    abstract fun provideListFragmentFactory(): ListFragment

    @ContributesAndroidInjector
    abstract fun provideSettingFragmentFactory(): SettingFragment

    @ContributesAndroidInjector
    abstract fun provideCountdownFragmentFactory(): CountdownFragment

}