package com.wyl.componentapp.utils

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.replaceFragment(containerViewId: Int, fragment: Fragment, tag: String? = null) =
    supportFragmentManager.beginTransaction().replace(
        containerViewId,
        fragment,
        tag
    ).commit()

