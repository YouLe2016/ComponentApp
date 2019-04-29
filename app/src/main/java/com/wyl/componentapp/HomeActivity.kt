package com.wyl.componentapp

import android.os.Bundle
import android.view.View
import com.wyl.componentapp.base.BaseActivity


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_layout)
    }

    override fun onClick(v: View) {

    }

}
