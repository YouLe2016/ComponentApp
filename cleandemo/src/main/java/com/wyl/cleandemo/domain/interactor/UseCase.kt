package com.wyl.cleandemo.domain.interactor


import com.wyl.cleandemo.domain.observer.BaseObserver
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Case 基类
 *
 * T     返回数据
 *
 * Params 请求参数
 */
abstract class UseCase<T, Params> {

    private val mDisposables: CompositeDisposable = CompositeDisposable()

    protected abstract fun buildObservable(params: Params): Observable<T>

    private fun addDisposable(disposable: Disposable) {
        mDisposables.add(disposable)
    }

    fun execute(params: Params, observer: BaseObserver<T>) {
        buildObservable(params)
            .doOnSubscribe { observer.onStart() }
            .doFinally { observer.onFinish() }
            .subscribe(observer)
        observer.disposable?.let {
            addDisposable(it)
        }
    }

    fun dispose() {
        if (!mDisposables.isDisposed) mDisposables.dispose()
    }

}