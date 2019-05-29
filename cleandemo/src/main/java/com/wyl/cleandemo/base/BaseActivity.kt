package com.wyl.cleandemo.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.wyl.cleandemo.domain.interactor.UseCase

abstract class BaseActivity : AppCompatActivity(), View.OnClickListener {
    val mCaseList by lazy {
        mutableListOf<UseCase<*, *>>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(createView())
        initData()
        initView()
    }

    abstract fun initView()

    abstract fun initData()

    abstract fun createView(): Int

    override fun onDestroy() {
        for (it in mCaseList) {
            it.dispose()
        }
        super.onDestroy()
    }
}