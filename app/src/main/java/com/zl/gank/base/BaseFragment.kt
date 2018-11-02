package com.zl.gank.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import rx.Subscription
import rx.subscriptions.CompositeSubscription

/**
 * Created by lvruheng on 2017/7/4.
 */
abstract class BaseFragment<SV : ViewDataBinding> : Fragment() {
    var bindingView: SV? = null
    var isFirst: Boolean = false
    var isFragmentVisiable: Boolean = false
    private var mCompositeSubscription: CompositeSubscription? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingView = DataBindingUtil.inflate(inflater, getLayoutResources(), container, false)
        return bindingView?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {
        super.setUserVisibleHint(isVisibleToUser)
        if (isVisibleToUser) {
            isFragmentVisiable = true
        }
        if (bindingView?.root == null) {
            return
        }
        //可见，并且没有加载过
        if (!isFirst && isFragmentVisiable) {
            onFragmentVisiableChange(true)
            return
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisiable) {
            onFragmentVisiableChange(false)
            isFragmentVisiable = false
        }
    }

    open protected fun onFragmentVisiableChange(b: Boolean) {

    }

    abstract fun getLayoutResources(): Int

    abstract fun initView()

    fun addSubscription(s: Subscription) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = CompositeSubscription()
        }
        this.mCompositeSubscription?.add(s)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (this.mCompositeSubscription != null && this.mCompositeSubscription!!.hasSubscriptions()) {
            this.mCompositeSubscription?.unsubscribe()
        }
    }

    fun removeSubscription() {
        if (this.mCompositeSubscription != null && mCompositeSubscription!!.hasSubscriptions()) {
            this.mCompositeSubscription?.unsubscribe()
        }
    }
}