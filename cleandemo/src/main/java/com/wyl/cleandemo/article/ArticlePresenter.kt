package com.wyl.cleandemo.article

import com.wyl.cleandemo.base.BasePresenter
import com.wyl.cleandemo.data.ArticleRepositoryImpl
import com.wyl.cleandemo.domain.bean.ArticleBean
import com.wyl.cleandemo.domain.interactor.ArticleCase
import com.wyl.cleandemo.domain.observer.BaseObserver

class ArticlePresenter(view: ArticleContract.View?) : BasePresenter<ArticleContract.View>(view),
    ArticleContract.Presenter {
    private lateinit var mCase: ArticleCase

    override fun createUseCase() {
        mCase = ArticleCase(ArticleRepositoryImpl())
        mCaseList.add(mCase)
    }

    override fun getArticleList(key: String) {
        mCase.execute(key, object : BaseObserver<List<ArticleBean>>() {
            override fun onSuccess(t: List<ArticleBean>) {
                view?.getArticleSuccess(t)
            }

            override fun onFail(failMsg: String) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStart() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
    }

}