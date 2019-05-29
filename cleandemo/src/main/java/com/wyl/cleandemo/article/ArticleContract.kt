package com.wyl.cleandemo.article

import com.wyl.cleandemo.base.IPresenter
import com.wyl.cleandemo.base.IView
import com.wyl.cleandemo.domain.bean.ArticleBean

interface ArticleContract {
    interface View : IView {
        fun getArticleSuccess(articleBeanList: List<ArticleBean>)

        fun getArticleFail(failMsg: String)

    }

    interface Presenter : IPresenter {
        fun getArticleList(key: String)
    }
}