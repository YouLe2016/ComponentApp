package com.wyl.componentapp

import android.app.Application

lateinit var instance: MyApplication

const val isDebug = true

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

    }


}
