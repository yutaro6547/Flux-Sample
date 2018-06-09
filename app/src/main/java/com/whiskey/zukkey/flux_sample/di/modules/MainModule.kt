package com.whiskey.zukkey.flux_sample.di.modules

import com.whiskey.zukkey.flux_sample.MainStore
import com.whiskey.zukkey.flux_sample.di.PerActivityScope
import com.whiskey.zukkey.flux_sample.flux.Dispatcher
import dagger.Module
import dagger.Provides

@Module
internal class MainModule {

    @PerActivityScope
    @Provides
    fun provideMainStore(dispatcher: Dispatcher) = MainStore(dispatcher)
}