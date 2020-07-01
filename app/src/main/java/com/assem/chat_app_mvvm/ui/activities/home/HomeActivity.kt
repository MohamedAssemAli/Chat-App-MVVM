package com.assem.chat_app_mvvm.ui.activities.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.repository.UsersRepositoryImp
import com.assem.chat_app_mvvm.ui.fragments.home.ChatListFragment
import com.assem.chat_app_mvvm.ui.fragments.home.UsersListFragment
import com.assem.chat_app_mvvm.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: UsersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        viewModel = ViewModelProvider(
            this,
            UsersViewModelFactory(
                UsersRepositoryImp(1)
            )
        ).get(UsersViewModel::class.java)

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