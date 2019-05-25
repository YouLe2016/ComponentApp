package com.wyl.componentapp

import android.app.Application
import com.lzg.extend.OkGoInitializer
import com.lzy.okgo.utils.OkLogger
import com.wyl.componentapp.di.HelloRepository
import com.wyl.componentapp.di.HelloRepositoryImpl
import com.wyl.componentapp.home.MyViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

lateinit var instance: MyApplication

class MyApplication : Application() {
    private val appModule = module {
        // single instance of HelloRepository
        single<HelloRepository> { HelloRepositoryImpl() }

        // MyViewModel ViewModel
        viewModel { MyViewModel(get()) }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        // Start Koin
        startKoin(this, listOf(appModule))

        // init OkGo
        OkGoInitializer.initOkGo(this)
        OkLogger.debug(BuildConfig.LOG_DEBUG)

    }

}
