package com.zl.gank.ui

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.example.zilongsong.kotlindemo.HomeFragment
import com.zl.gank.R
import com.zl.gank.base.BaseActivity
import com.zl.gank.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<ActivityMainBinding>(), NavigationView.OnNavigationItemSelectedListener {

    val items = listOf("主页", "安卓", "苹果")

    override fun getContentViewId(): Int {
        return R.layout.activity_main
    }

    @SuppressLint("ResourceAsColor")
    override fun init(savedInstanceState: Bundle?) {
        val toggle = ActionBarDrawerToggle(
                this, bindingView?.drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        bindingView?.drawerLayout?.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        val tablayout = bindingView?.include?.findViewById<TabLayout>(R.id.table_layout)
        tablayout?.tabMode = TabLayout.MODE_FIXED
        tablayout?.setBackgroundColor(Color.BLUE)
        for (item in items) {
            tablayout?.addTab(tablayout.newTab().setText(item))
        }
        tablayout?.setTabTextColors(Color.YELLOW, Color.WHITE)
        tablayout?.setSelectedTabIndicatorColor(R.color.colorAccent)
        tablayout?.getTabAt(0)?.select()

        val viewPager = bindingView?.include?.findViewById<ViewPager>(R.id.view_pager)
        val adapter = PageAdapter(supportFragmentManager)
        viewPager?.adapter = adapter
    }

    class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        var fragments: MutableList<Fragment> = ArrayList()

        init {
            fragments.add(HomeFragment())
            fragments.add(HomeFragment())
            fragments.add(HomeFragment())
        }

        override fun getCount(): Int = fragments.size

        override fun getItem(p0: Int): Fragment {
            return fragments[p0]
        }

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
