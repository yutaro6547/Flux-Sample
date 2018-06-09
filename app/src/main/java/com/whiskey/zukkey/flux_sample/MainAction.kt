package com.whiskey.zukkey.flux_sample

import com.whiskey.zukkey.flux_sample.flux.Action


sealed class MainAction<out T>(override val type: String): Action<T> {
    class Text(override val data: String): MainAction<String>(TYPE) {
        companion object {
            const val TYPE = "MainAction.Text"
        }
    }
}