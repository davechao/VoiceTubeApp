package com.test.voicetubeapp.di

import android.app.Application
import com.test.voicetubeapp.App
import com.test.voicetubeapp.di.module.ActivityBuilderModule
import com.test.voicetubeapp.di.module.AppModule
import com.test.voicetubeapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    (AndroidSupportInjectionModule::class),
    (AppModule::class),
    (ActivityBuilderModule::class),
    (ViewModelModule::class)])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Application): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)

}