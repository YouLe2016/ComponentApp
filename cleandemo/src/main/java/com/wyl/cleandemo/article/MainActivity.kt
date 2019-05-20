package com.wyl.cleandemo.article

import android.text.method.ScrollingMovementMethod
import android.view.View
import com.wyl.cleandemo.R
import com.wyl.cleandemo.base.BaseActivity
import com.wyl.cleandemo.data.ArticleRepositoryImpl
import com.wyl.cleandemo.domain.bean.ArticleBean
import com.wyl.cleandemo.domain.interactor.ArticleCase
import com.wyl.cleandemo.domain.observer.BaseObserver
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 需求
 * 用户点击 Button 按钮，获取微信精选文章，在界面显示。
 */
class MainActivity : BaseActivity(), ArticleContract.ArticleView {
    private val KEY = "dbb6893ab0913b02724696504181fe39"

    val articleCase by lazy {
        ArticleCase(ArticleRepositoryImpl())
    }

    override fun createView(): Int = R.layout.activity_main

    override fun initView() {
        textView.movementMethod = ScrollingMovementMethod.getInstance()
    }

    override fun onClick(v: View) {
        /*Observable.fromArray(1, 2, 3, 4)
            .map {
                println("thread map = ${Thread.currentThread()} $it")
                it + 1
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .map {
                val i = it - 1
                println("thread map2 = ${Thread.currentThread()} $i")
                i
            }
            .subscribe(object : Observer<Int> {
                override fun onComplete() {
                    println("thread onComplete = ${Thread.currentThread()}")
                }

                override fun onSubscribe(d: Disposable) {

                }

                override fun onNext(t: Int) {
                    println("MainActivity.onNext $t")
                }

                override fun onError(e: Throwable) {

                }

            })*/

        if (R.id.btnGet == v.id) {
            articleCase.execute(KEY, object : BaseObserver<List<ArticleBean>>() {
                override fun onSuccess(t: List<ArticleBean>) {
                    textView.text = t.toString()
                }

                override fun onFail(failMsg: String) {
                    textView.text = failMsg
                }

                override fun onStart() {
                    textView.text = "请求中..."
                }
            })

//            OkGo.get<BaseResponse<ResponseData>>("http://v.juhe.cn/weixin/query")
//                .params("key", KEY)
//                .execute(object : JsonCallback<BaseResponse<ResponseData>>() {
//                    override fun onSuccess(response: Response<BaseResponse<ResponseData>>) {
//                        val body = response.body()
//                        if (body.error_code != 0) {
//                            textView.text = body.reason
//                        } else {
//                            textView.text = body.result.list.toString()
//                        }
//                    }
//
//                    override fun onError(response: Response<BaseResponse<ResponseData>>) {
//                        textView.text = response.message()
//                    }
//
//                    override fun onStart(request: Request<BaseResponse<ResponseData>, out Request<Any, Request<*, *>>>?) {
//                        textView.text = "请求中..."
//                    }
//                })
        }
    }

    override fun initData() {
        mCaseList.add(articleCase)
    }

    override fun getArticleSuccess(articleBeanList: List<ArticleBean>) {

    }

    override fun getArticleFail(failMsg: String) {

    }

}
