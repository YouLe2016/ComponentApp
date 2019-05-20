package com.wyl.cleandemo.article

import com.wyl.cleandemo.base.IPresenter
import com.wyl.cleandemo.base.IView
import com.wyl.cleandemo.domain.bean.ArticleBean

interface ArticleContract {
    interface ArticleView : IView {

        fun getArticleSuccess(articleBeanList: List<ArticleBean>)

        fun getArticleFail(failMsg: String)

    }

    interface ArticlePresenter : IPresenter<ArticleView> {
        fun getArticleList(key: String)
    }
}