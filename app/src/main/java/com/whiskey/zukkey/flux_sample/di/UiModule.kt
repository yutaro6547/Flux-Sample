package com.whiskey.zukkey.flux_sample.di

import com.whiskey.zukkey.flux_sample.MainActivity
import com.whiskey.zukkey.flux_sample.di.modules.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal abstract class UiModule {

    @PerActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun contributeMainActivityInjector() : MainActivity
}