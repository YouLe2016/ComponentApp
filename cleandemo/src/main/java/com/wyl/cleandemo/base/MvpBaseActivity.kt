package com.wyl.cleandemo.base

import android.os.Bundle

abstract class MvpBaseActivity<V : IView, P : IPresenter<V>> : BaseActivity(), IView {
    lateinit var mPresenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        mPresenter = createPresenter()
        @Suppress("UNCHECKED_CAST")
        mPresenter.attach(this as V)
        super.onCreate(savedInstanceState)
    }

    abstract fun createPresenter(): P

}