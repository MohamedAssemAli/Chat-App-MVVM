package com.assem.chat_app_mvvm.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter


/**
 * Created by Mohamed Assem on 28-Jun-20.
 * mo7mad.assim@gmail.com
 */

class ViewPagerAdapter(fm: FragmentManager) :
    FragmentStatePagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val mFragmentsList: ArrayList<Fragment> = ArrayList()
    private val mFragmentsTitle: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {
        return mFragmentsList[position]
    }

    override fun getCount(): Int {
        return mFragmentsList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentsTitle[position]
    }

    fun addFragment(fragment: Fragment, fragmentTitle: String) {
        mFragmentsList.add(fragment)
        mFragmentsTitle.add(fragmentTitle)
    }
}