package com.wyl.cleandemo.domain.repository

import com.wyl.cleandemo.domain.bean.ArticleBean
import io.reactivex.Observable


interface ArticleRepository {
    fun getArticleList(param: String): Observable<List<ArticleBean>>
}