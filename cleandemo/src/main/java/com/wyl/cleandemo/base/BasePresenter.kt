package com.wyl.cleandemo.base

import com.wyl.cleandemo.domain.interactor.UseCase

abstract class BasePresenter<V : IView>(var view: V?) : IPresenter {

    val mCaseList by lazy {
        mutableListOf<UseCase<*, *>>()
    }

    override fun detach() {
        view = null
        for (it in mCaseList) {
            it.dispose()
        }
    }

    abstract fun createUseCase()

}