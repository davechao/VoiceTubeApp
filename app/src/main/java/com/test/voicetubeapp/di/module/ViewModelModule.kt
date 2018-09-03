package com.test.voicetubeapp.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.test.voicetubeapp.di.ViewModelFactory
import com.test.voicetubeapp.di.ViewModelKey
import com.test.voicetubeapp.ui.countdown.CountdownViewModel
import com.test.voicetubeapp.ui.list.ListViewModel
import com.test.voicetubeapp.ui.main.MainViewModel
import com.test.voicetubeapp.ui.setting.SettingViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ListViewModel::class)
    abstract fun bindListViewModel(listViewModel: ListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SettingViewModel::class)
    abstract fun bindSettingViewModel(settingViewModel: SettingViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CountdownViewModel::class)
    abstract fun bindCountdownViewModel(countdownViewModel: CountdownViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

}