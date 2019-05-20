package com.wyl.cleandemo.article

import com.wyl.cleandemo.base.BasePresenter
import com.wyl.cleandemo.data.ArticleRepositoryImpl
import com.wyl.cleandemo.domain.bean.ArticleBean
import com.wyl.cleandemo.domain.interactor.ArticleCase
import com.wyl.cleandemo.domain.observer.BaseObserver

class ArticlePresenter : BasePresenter<ArticleContract.ArticleView>() {
    private lateinit var mCase: ArticleCase

    override fun createUseCase() {
        mCase = ArticleCase(ArticleRepositoryImpl())
        mCaseList.add(mCase)
    }

    fun getData(key: String) {
        mCase.execute(key, object : BaseObserver<List<ArticleBean>>() {
            override fun onSuccess(t: List<ArticleBean>) {
                view?.getArticleSuccess(t)
            }

            override fun onFail(failMsg: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onFinish() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}