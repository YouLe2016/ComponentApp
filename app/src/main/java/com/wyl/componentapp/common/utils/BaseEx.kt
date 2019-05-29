package com.wyl.componentapp.common.utils

import android.util.Log
import com.wyl.componentapp.BuildConfig

fun Any.logD(msg: Any?) {
    if (BuildConfig.DEBUG) {
        Log.d(javaClass.simpleName, msg.toString())
    }
    // Activity.componentName.shortClassName == javaClass.simpleName
}