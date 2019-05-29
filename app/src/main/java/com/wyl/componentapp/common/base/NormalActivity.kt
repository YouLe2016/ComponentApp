package com.wyl.componentapp.common.base

abstract class NormalActivity : BaseActivity() {
    override fun setContentView() {
        setContentView(getLayoutId())
    }
}