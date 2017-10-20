package com.jack.news.fragment.duanzi

import com.jack.common.api.DataApi
import com.jack.common.bean.Data
import com.jack.common.bean.Response
import com.jack.news.mvp.BaseMvpPresenter
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class DuanziPresenter : BaseMvpPresenter<DuanziView>() {

    fun getDuanzis(isRefresh: Boolean, count: Int) {
        DataApi.IMPL.getDuanzis(0).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Observer<Response<Data>> {
                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onComplete() {
                        if (isViewAttached()) getView()!!.showRefreshEnd()
                    }

                    override fun onError(e: Throwable) {
                        if (isViewAttached()) getView()!!.showError(e.message)
                    }

                    override fun onNext(value: Response<Data>) {
                        if (isViewAttached()) getView()!!.setData(isRefresh, value.datas)
                    }
                })

    }
}