package com.jack.news.fragment.duanzi

import com.jack.common.bean.Data
import com.jack.news.mvp.BaseMvpView

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

interface DuanziView : BaseMvpView {

    fun showRefreshStart()

    fun showRefreshEnd()

    fun setData(isRefresh: Boolean, datas: List<Data>)

    fun showLoadMoreStart()

    fun showLoadMoreEnd()

}