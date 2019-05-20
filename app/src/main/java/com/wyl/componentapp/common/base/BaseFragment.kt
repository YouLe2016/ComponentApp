package com.wyl.componentapp.common.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }
}