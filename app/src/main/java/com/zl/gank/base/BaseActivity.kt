package com.zl.gank.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v7.app.AppCompatActivity


/**
 * Created by zilongsong on 18-4-23.
 */
abstract class BaseActivity<SV : ViewDataBinding> : AppCompatActivity() {
    var bindingView: SV? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView = DataBindingUtil.setContentView(this, getContentViewId())
        init(savedInstanceState)
        //ssss
    }


    abstract fun getContentViewId(): Int

    abstract fun init(savedInstanceState: Bundle?)
}