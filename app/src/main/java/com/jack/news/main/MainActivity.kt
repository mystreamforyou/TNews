package com.jack.news.main

import android.app.Fragment
import android.app.FragmentTransaction
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.widget.Toolbar
import com.jack.news.R
import com.jack.news.base.BaseMvpActivity
import com.jack.news.fragment.duanzi.DuanziFragment
import com.jack.news.fragment.qutu.QutuFragment
import com.jack.news.fragment.setting.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Description:
 * Copyright  : Copyright (c) 2015
 * Author     : liujianguang
 * Date       : 2017/10/10
 **/

class MainActivity : BaseMvpActivity<MainView, MainPresenter>() {

    override var mPresenter: MainPresenter = MainPresenter()

    private lateinit var duanziFragment: Fragment
    private lateinit var qutuFragment: Fragment
    private lateinit var settingFragment: Fragment

    private var currentFragment: Fragment? = null

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                showFragment(duanziFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                showFragment(qutuFragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                showFragment(settingFragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        toolbar.title = "setting"
        setActionBar(toolbar)
        initView()
    }

    private fun initView() {
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        duanziFragment = DuanziFragment.newInstance()
        qutuFragment = QutuFragment.newInstance()
        settingFragment = SettingFragment.newInstance()
        showFragment(duanziFragment)
    }

    private fun showFragment(fragment: Fragment) {
        val ft: FragmentTransaction = fragmentManager.beginTransaction()
        if (currentFragment != fragment) {
            if (currentFragment != null) ft.hide(currentFragment)
            currentFragment = fragment
            if (fragment.isAdded) {
                ft.show(fragment)
            } else {
                ft.add(R.id.content, fragment)
            }
            ft.commit()
        }
    }

}