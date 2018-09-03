package com.test.voicetubeapp.di.module

import com.test.voicetubeapp.ui.main.MainActivity
import com.test.voicetubeapp.ui.main.MainFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainFragmentProvider::class])
    abstract fun bindMainActivity(): MainActivity

}