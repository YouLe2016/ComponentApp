package com.wyl.cleandemo.domain.interactor

import com.wyl.cleandemo.domain.bean.ArticleBean
import com.wyl.cleandemo.domain.repository.ArticleRepository
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class ArticleCase(private val articleRepository: ArticleRepository) : UseCase<List<ArticleBean>, String>() {

    override fun buildObservable(params: String): Observable<List<ArticleBean>> {
        return articleRepository.getArticleList(params)
    }

}