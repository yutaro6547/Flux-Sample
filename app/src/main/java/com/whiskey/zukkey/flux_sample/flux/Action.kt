package com.whiskey.zukkey.flux_sample.flux


interface Action<out T> {
    val type:String
    val data: T
}