package com.jack.news.base

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/17
 **/

abstract class ItemBinder<T : Any, VH : RecyclerView.ViewHolder> {
    var itemClickListener: ((item: T, position: Int) -> Unit)? = null

    var extendListener1: ((item: T) -> Unit)? = null
    var extendListener2: ((item: T) -> Unit)? = null

    lateinit var adapter: AnotherAdapter

    abstract fun createViewHolder(inflater: LayoutInflater, parent: ViewGroup): VH

    abstract fun bindViewHolder(holder: VH, item: T)

    fun clickWith(listener: (item: T, position: Int) -> Unit) = apply {
        itemClickListener = listener
    }

    fun addExtendListener1(listener: (item: T) -> Unit) = apply {
        extendListener1 = listener
    }

    fun addExtendListener2(listener: (item: T) -> Unit) = apply {
        extendListener2 = listener
    }
}

abstract class AnotherBinder<T : Any> : ItemBinder<T, AnotherViewHolder>() {
    override fun bindViewHolder(holder: AnotherViewHolder, item: T) {
        renderView(holder, holder.itemView, item)
    }

    abstract fun renderView(holder: AnotherViewHolder, itemView: View, item: T)
}