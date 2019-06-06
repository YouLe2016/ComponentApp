package com.wyl.componentapp

import android.os.Bundle
import com.wyl.componentapp.common.base.BindingActivity
import com.wyl.componentapp.common.utils.noStatusBar
import com.wyl.componentapp.common.utils.transact
import com.wyl.componentapp.databinding.HomeActivityBinding
import com.wyl.componentapp.home.HomeFragment
import com.wyl.componentapp.home.MyViewModel
import com.wyl.componentapp.message.MessageFragment
import com.wyl.componentapp.mine.MineFragment
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : BindingActivity<HomeActivityBinding>() {
    private val viewModel: MyViewModel by viewModel()

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
        noStatusBar()
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutId(): Int = R.layout.home_activity

    override fun initView() {
        transact { replace(R.id.rootView, homeFragment) }

        mBinding.tab.material()
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
                    else -> {
                    }
                }
            }
    }

    override fun loadData() {

    }


}
