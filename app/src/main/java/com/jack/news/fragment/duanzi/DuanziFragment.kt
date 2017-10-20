package com.jack.news.fragment.duanzi

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.jack.common.bean.Data
import com.jack.news.R
import com.jack.news.base.AnotherAdapter
import com.jack.news.base.BaseMvpFragment
import com.jack.news.widget.RecyclerDivider
import kotlinx.android.synthetic.main.fragment_duanzi.*

/**
 * Description: News
 * Copyright  : Copyright (c) 2017
 * Author     : liujianguang
 * Date       : 2017/10/16
 **/

class DuanziFragment : BaseMvpFragment<DuanziView, DuanziPresenter>(), DuanziView {

    override val mResId: Int = R.layout.fragment_duanzi

    override var mPresenter: DuanziPresenter = DuanziPresenter()

    lateinit var adapter: AnotherAdapter

    companion object {
        fun newInstance(): DuanziFragment {
            val args = Bundle()
            val fragment = DuanziFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }

    private fun initData() {
        mPresenter.getDuanzis(true, 0)
    }

    private fun initView() {
        rlvList.layoutManager = LinearLayoutManager(context)
        rlvList.addItemDecoration(RecyclerDivider(context, LinearLayoutManager.VERTICAL))
        adapter = AnotherAdapter()
                .with(Data::class.java, DuanziBinder().clickWith({ item, _ ->
                    toast("item")
                }))
        rlvList.adapter = adapter

        refreshView.setOnRefreshListener {
            showRefreshEnd()
            mPresenter.getDuanzis(true, 0)
        }

    }

    override fun setData(isRefresh: Boolean, datas: List<Data>) {
        Log.i("DataApi", "isRefresh " + isRefresh + " Data size " + datas.size)
        if (isRefresh) {
            adapter.update(datas)
        } else {
            adapter.add(datas)
        }
    }

    override fun showRefreshStart() {
        refreshView.isRefreshing = true
    }

    override fun showRefreshEnd() {
        refreshView.isRefreshing = false
    }

    override fun showLoadMoreStart() {
    }

    override fun showLoadMoreEnd() {
    }
}