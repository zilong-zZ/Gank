package com.example.zilongsong.kotlindemo

import com.tt.lvruheng.eyepetizer.ui.fragment.BaseFragment
import com.zl.gank.R
import com.zl.gank.databinding.HomeFragmentBinding

/**
 * Created by zilongsong on 18-4-19.
 */
class HomeFragment : BaseFragment<HomeFragmentBinding>() {

    override fun getLayoutResources(): Int {
        return R.layout.home_fragment
    }

    override fun initView() {
        bindingView?.textView2?.text = "homeFragment"
    }

}
