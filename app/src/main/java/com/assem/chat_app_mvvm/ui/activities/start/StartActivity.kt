package com.assem.chat_app_mvvm.ui.activities.start

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.assem.chat_app_mvvm.R
import com.assem.chat_app_mvvm.data.repository.AuthRepositoryImpl
import com.assem.chat_app_mvvm.ui.fragments.start.SignInFragment
import com.assem.chat_app_mvvm.ui.fragments.start.SignUpFragment
import com.assem.chat_app_mvvm.util.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    lateinit var viewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        setupViewPager()
        viewModel = ViewModelProvider(
            this,
            AuthViewModelFactory(
                AuthRepositoryImpl(1)
            )
        ).get(AuthViewModel::class.java)
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(this.supportFragmentManager)
        viewPagerAdapter.addFragment(SignInFragment(), "Sigin")
        viewPagerAdapter.addFragment(SignUpFragment(), "Signup")
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