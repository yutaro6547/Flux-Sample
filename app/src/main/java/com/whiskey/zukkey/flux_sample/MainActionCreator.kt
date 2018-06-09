package com.whiskey.zukkey.flux_sample

import com.whiskey.zukkey.flux_sample.di.PerActivityScope
import com.whiskey.zukkey.flux_sample.flux.Dispatcher
import javax.inject.Inject

@PerActivityScope
class MainActionCreator @Inject constructor(
        private val dispatcher: Dispatcher
) {

    fun setTexts(text: String) {
        dispatcher.dispatch(MainAction.Text(text))
    }
}