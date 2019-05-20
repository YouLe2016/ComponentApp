package com.wyl.cleandemo.base

import android.arch.lifecycle.LifecycleObserver
import com.wyl.cleandemo.domain.interactor.UseCase

abstract class BasePresenter<V : IView> : IPresenter<V>{
    var view: V? = null

    val mCaseList by lazy {
        mutableListOf<UseCase<*, *>>()
    }

    override fun attach(view: V) {
        this.view = view
    }

    override fun detach() {
        view = null
        for (it in mCaseList) {
            it.dispose()
        }
    }

    abstract fun createUseCase()

}