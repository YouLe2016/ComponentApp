package com.wyl.cleandemo.base


interface IPresenter<V : IView> {

    fun attach(view: V)

    fun detach()

}