package com.whiskey.zukkey.flux_sample

import com.whiskey.zukkey.flux_sample.flux.Dispatcher
import com.whiskey.zukkey.flux_sample.flux.Store
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.processors.BehaviorProcessor
import javax.inject.Inject

class MainStore @Inject constructor(
        private val dispatcher: Dispatcher
) : Store() {
    val _texts = BehaviorProcessor.create<String>()
    val texts: Flowable<String> = _texts

    init {
        dispatcher.on(MainAction.Text.TYPE)
                .map { (it as MainAction.Text).data }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(_texts)
    }
}