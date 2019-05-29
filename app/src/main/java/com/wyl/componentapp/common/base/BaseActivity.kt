package com.wyl.componentapp.common.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.wyl.componentapp.common.utils.getStatusBarHeight
import com.wyl.componentapp.common.utils.getStatusBarHeight2

abstract class BaseActivity : AppCompatActivity(), Presenter {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        initView()
        loadData()
        val height = getStatusBarHeight()
        val height2 = getStatusBarHeight2()
        println("height = $height height2 = $height2")
    }

    abstract fun setContentView()

    abstract fun getLayoutId(): Int

    abstract fun initView()

    abstract fun loadData()

    override fun onClick(v: View) {}


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        val height = getStatusBarHeight()
        val height2 = getStatusBarHeight2()
        println("height = $height height2 = $height2")
    }
}