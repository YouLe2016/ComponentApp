package com.wyl.componentapp

import android.app.Application
import com.lzg.extend.OkGoInitializer
import com.lzy.okgo.utils.OkLogger

lateinit var instance: MyApplication

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        OkGoInitializer.initOkGo(this)
        OkLogger.debug(BuildConfig.LOG_DEBUG)
    }

}
