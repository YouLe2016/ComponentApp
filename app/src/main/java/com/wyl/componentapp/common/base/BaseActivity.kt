package com.wyl.componentapp.common.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

open class BaseActivity : AppCompatActivity(), View.OnClickListener {
    val TAG: String by lazy { componentName.shortClassName }


    override fun onClick(v: View) {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}