package com.wyl.componentapp.home

import android.arch.lifecycle.ViewModel
import com.wyl.componentapp.di.HelloRepository

class MyViewModel(private val repo: HelloRepository) : ViewModel() {
    fun sayHello() = "${repo.giveHello()} from $this"
}