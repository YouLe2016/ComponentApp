package com.wyl.componentapp

import android.os.Bundle
import com.wyl.componentapp.module_common.base.BaseActivity
import com.wyl.componentapp.module_common.utils.transact
import com.wyl.componentapp.module_home.HomeFragment
import com.wyl.componentapp.module_message.MessageFragment
import com.wyl.componentapp.module_mine.MineFragment
import kotlinx.android.synthetic.main.activity_home_layout.*


class HomeActivity : BaseActivity() {
    private val homeFragment by lazy {
        HomeFragment()
    }
    private val messageFragment by lazy {
        MessageFragment().apply {
            transact {
                add(R.id.rootView, this@apply)
            }
        }
    }
    private val mineFragment by lazy {
        MineFragment().apply {
            transact {
                add(R.id.rootView, this@apply)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_layout)

        transact { replace(R.id.rootView, homeFragment) }

        tab.material()
            .addItem(R.drawable.main_item0, "首页")
            .addItem(R.drawable.main_item2, "消息")
            .addItem(R.drawable.main_item3, "我的")
            .build()
            .addSimpleTabItemSelectedListener { index, _ ->
                when (index) {
                    0 -> transact {
                        show(homeFragment)
                        hide(messageFragment)
                        hide(mineFragment)
                    }
                    1 -> transact {
                        hide(homeFragment)
                        show(messageFragment)
                        hide(mineFragment)
                    }
                    2 -> transact {
                        hide(homeFragment)
                        hide(messageFragment)
                        show(mineFragment)
                    }
                }
            }
    }

}
