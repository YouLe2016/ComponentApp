package com.wyl.cleandemo.data

import com.google.gson.reflect.TypeToken
import com.lzg.extend.BaseResponse
import com.lzg.extend.JsonConvert
import com.lzy.okgo.OkGo
import com.lzy.okrx2.adapter.ObservableResponse
import com.wyl.cleandemo.domain.bean.ArticleBean
import com.wyl.cleandemo.domain.bean.ResponseData
import com.wyl.cleandemo.domain.repository.ArticleRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ArticleRepositoryImpl : ArticleRepository {

    override fun getArticleList(param: String): Observable<List<ArticleBean>> {
        // @GET("/weixin/query")
        // Observable<BaseResponse> getArticleList(@Query("key") String appKey);
        val type = object : TypeToken<BaseResponse<ResponseData>>() {}.type
        return OkGo.get<BaseResponse<ResponseData>>("http://v.juhe.cn/weixin/query")
            .params("key", param)
            .converter(object : JsonConvert<BaseResponse<ResponseData>>() {})
            .adapt(ObservableResponse<BaseResponse<ResponseData>>())
            .subscribeOn(Schedulers.io())
            .map {
                println("ArticleRepositoryImpl.getArticleList: thread = ${Thread.currentThread().name}")
                it.body().result.list
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

//    override fun getArticleList(param: String, task: (List<ArticleBean>) -> Unit) {
//        // @GET("/weixin/query")
//        // Observable<BaseResponse> getArticleList(@Query("key") String appKey);
//
//        return OkGo.get<BaseResponse>("http://v.juhe.cn/weixin/query")
//            .params("key", param)
//            .execute(result : JsonCallback<BaseResponse>() {
//                override fun onSuccess(response: Response<BaseResponse>) {
//                    task.invoke(  response.body().result.list)
//                }
//            })
//    }
}