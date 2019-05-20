package com.wyl.componentapp.common.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity


fun AppCompatActivity.transact(block: FragmentTransaction.() -> FragmentTransaction) =
    supportFragmentManager.beginTransaction().block().commit()


@Deprecated(
    "弃用",
    ReplaceWith("transact替代"),
    level = DeprecationLevel.WARNING
)
fun AppCompatActivity.replaceFragment(containerViewId: Int, fragment: Fragment, tag: String? = null) =
    supportFragmentManager.beginTransaction().replace(
        containerViewId,
        fragment,
        tag
    ).commit()

