package com.jack.news.fragment.duanzi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jack.common.bean.Data
import com.jack.news.R
import com.jack.news.base.AnotherBinder
import com.jack.news.base.AnotherViewHolder
import kotlinx.android.synthetic.main.item_duanzi.view.*

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/17
 **/

class DuanziBinder : AnotherBinder<Data>() {
    override fun renderView(holder: AnotherViewHolder, itemView: View, item: Data) {
//        Log.i("Data","jsonToObject model "+item.jsonToObject())
        itemView.tvContent.text = item.getDuanzi().content
        itemView.zanTv.text=item.getDuanzi().diggCount
        itemView.caiTv.text=item.getDuanzi().buryCount
        itemView.pingTv.text=item.getDuanzi().commentCount
    }

    override fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): AnotherViewHolder {
        val view = inflater.inflate(R.layout.item_duanzi, parent, false)
        return AnotherViewHolder(view)
    }
}