package com.jack.news.fragment.qutu

import android.os.Bundle
import android.view.View
import com.jack.news.R
import com.jack.news.base.BaseMvpFragment

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class QutuFragment : BaseMvpFragment<QutuView, QutuPresenter>() {

    override val mResId: Int = R.layout.fragment_qutu

    override var mPresenter: QutuPresenter = QutuPresenter()

    companion object {
        fun newInstance(): QutuFragment {
            val args = Bundle()
            val fragment = QutuFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}