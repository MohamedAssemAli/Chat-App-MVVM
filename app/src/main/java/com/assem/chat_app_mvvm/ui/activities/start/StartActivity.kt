package com.assem.chat_app_mvvm.ui.activities.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.ui.fragments.start.LoginFragment
import com.assem.chat_app_mvvm.ui.fragments.start.RegistrationFragment
import com.assem.chat_app_mvvm.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        viewPagerAdapter.addFragment(LoginFragment(), "Sigin")
        viewPagerAdapter.addFragment(RegistrationFragment(), "Signup")
        activity_start_viewpager.adapter = viewPagerAdapter
        activity_start_tab_layout.setupWithViewPager(activity_start_viewpager)
        activity_start_tab_layout!!.addOnTabSelectedListener(object :
            TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                activity_start_viewpager!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })
    }

}