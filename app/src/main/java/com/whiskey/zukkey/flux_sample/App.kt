package com.whiskey.zukkey.flux_sample


import com.whiskey.zukkey.flux_sample.di.DaggerAppComponent
import dagger.android.DaggerApplication


class App : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder()
            .application(this)
            .build()
}