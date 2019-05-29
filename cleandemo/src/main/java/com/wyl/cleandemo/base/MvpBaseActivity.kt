package com.wyl.cleandemo.base

import android.os.Bundle

abstract class MvpBaseActivity : BaseActivity(), IView {
    protected val mPresenters = mutableListOf<IPresenter>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createPresenter()
    }

    abstract fun createPresenter()

    override fun onDestroy() {
        mPresenters.forEach { it.detach() }
        super.onDestroy()
    }

}