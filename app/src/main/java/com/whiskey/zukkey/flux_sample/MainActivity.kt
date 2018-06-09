package com.whiskey.zukkey.flux_sample

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.whiskey.zukkey.flux_sample.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var store: MainStore
    @Inject
    lateinit var actionCreator: MainActionCreator

    private val disposable = CompositeDisposable()
    private val binding by lazy { DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main) }

    private fun Disposable.disposeWhenDestroy() = disposable.add(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.button.setOnClickListener {
            val rnd = Random()
            when (rnd.nextInt(10)) {
                0, 4, 6 -> actionCreator.setTexts("小吉")
                1, 3 -> actionCreator.setTexts("中吉")
                2 -> actionCreator.setTexts("大吉")
                else -> actionCreator.setTexts("末吉")
            }
        }
        store.texts.subscribe {
            binding.text.text = it
        }.disposeWhenDestroy()
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }
}
