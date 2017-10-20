package com.jack.news

import android.app.Application
import com.jack.common.rest.RestUtils

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        RestUtils.init(this)
    }

}