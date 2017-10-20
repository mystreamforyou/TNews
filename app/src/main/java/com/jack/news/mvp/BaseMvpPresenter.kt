package com.jack.news.mvp

import java.lang.ref.WeakReference

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

open class BaseMvpPresenter<V : BaseMvpView> {

    private var viewRef: WeakReference<V>? = null

    fun attachView(view: V) {
        viewRef = WeakReference<V>(view)
    }

    fun detachView() {
        if (viewRef != null) {
            viewRef!!.clear()
            viewRef = null
        }
    }

    protected fun getView(): V? {
        return if (viewRef == null) null else viewRef!!.get()
    }

    protected fun isViewAttached(): Boolean {
        return viewRef != null && viewRef!!.get() != null
    }
}
