package com.wyl.componentapp.common.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import com.wyl.componentapp.BR

abstract class BindingActivity<VB : ViewDataBinding> : BaseActivity() {
    protected lateinit var mBinding: VB

    override fun setContentView() {
        mBinding = DataBindingUtil.setContentView(this, getLayoutId())
        mBinding.setVariable(BR.presenter, this)
        mBinding.executePendingBindings()
        mBinding.lifecycleOwner = this
    }
}