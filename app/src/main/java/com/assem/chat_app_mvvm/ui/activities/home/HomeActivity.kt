package com.assem.chat_app_mvvm.ui.activities.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.ui.fragments.home.ChatListFragment
import com.assem.chat_app_mvvm.ui.fragments.home.UsersListFragment
import com.assem.chat_app_mvvm.ui.fragments.start.SignInFragment
import com.assem.chat_app_mvvm.ui.fragments.start.SignUpFragment
import com.assem.chat_app_mvvm.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        viewPagerAdapter.addFragment(ChatListFragment(), "Chats")
        viewPagerAdapter.addFragment(UsersListFragment(), "Users")
        activity_home_viewpager.adapter = viewPagerAdapter
        activity_home_tab_layout.setupWithViewPager(activity_home_viewpager)
        activity_home_tab_layout!!.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                activity_home_viewpager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }
}