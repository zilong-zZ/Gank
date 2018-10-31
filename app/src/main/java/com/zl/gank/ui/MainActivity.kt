package com.zl.gank.ui

import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.example.zilongsong.kotlindemo.HomeFragment
import com.zl.gank.R
import com.zl.gank.base.BaseActivity
import com.zl.gank.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var homeFragment: HomeFragment

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    override fun init(savedInstanceState: Bundle?) {
        val toggle = ActionBarDrawerToggle(
                this, bindingView?.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        bindingView?.drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        initFragment(savedInstanceState)
    }

    private fun initFragment(savedInstanceState: Bundle?) {
        if (savedInstanceState != null) {
            //异常情况
            val mFragments: List<Fragment> = supportFragmentManager.fragments
            for (item in mFragments) {
                if (item is HomeFragment) {
                    homeFragment = item
                }
            }
        } else {
            homeFragment = HomeFragment()

            val fragmentTrans = supportFragmentManager.beginTransaction()
            fragmentTrans.add(R.id.fl_content, homeFragment)
            fragmentTrans.commit()
        }
        supportFragmentManager.beginTransaction().show(homeFragment)
                .commit()
    }

    override fun onBackPressed() {
        if (bindingView?.drawerLayout!!.isDrawerOpen(GravityCompat.START)) {
            bindingView?.drawerLayout?.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_camera -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_manage -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        bindingView?.drawerLayout?.closeDrawer(GravityCompat.START)
        return true
    }
}
