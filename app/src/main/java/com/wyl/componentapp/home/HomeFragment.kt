package com.wyl.componentapp.home


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.lzg.extend.StringDialogCallback
import com.lzy.okgo.OkGo
import com.lzy.okgo.model.Response
import com.wyl.componentapp.R
import kotlinx.android.synthetic.main.fragment_home_layout.*
import org.koin.android.viewmodel.ext.android.viewModel


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    val myViewModel: MyViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        OkGo.get<String>("http://gank.io/api/today")
            .tag(this)
            .execute(object : StringDialogCallback(activity, true) {
                override fun onSuccessResponse(response: Response<String>, msg: String?, msgCode: String?) {
                    val data = response.body()//这个就是返回来的结果
                    text.text = data
                }

//                override fun onSuccess(response: Response<String>) {
//                    //注意这里已经是在主线程了
//                    val data = response.body()//这个就是返回来的结果
//                    text.text = data
//                }

                override fun onError(response: Response<String>) {

                }
            })
    }

}
