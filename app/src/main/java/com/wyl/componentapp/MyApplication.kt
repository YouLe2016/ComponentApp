package com.wyl.componentapp

import android.app.Application
import com.lzg.extend.OkGoInitializer
import com.lzy.okgo.utils.OkLogger
import com.wyl.componentapp.di.appModule
import org.koin.android.ext.android.startKoin

lateinit var instance: MyApplication

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Start Koin
        startKoin(this, appModule)

        // init OkGo
        OkGoInitializer.initOkGo(this)
        OkLogger.debug(BuildConfig.LOG_DEBUG)

    }

}
