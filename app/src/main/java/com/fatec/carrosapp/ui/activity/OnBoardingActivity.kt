package com.fatec.carrosapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.fatec.carrosapp.R
import com.fatec.carrosapp.ui.fragment.FragmentFour
import com.fatec.carrosapp.ui.fragment.FragmentOne
import com.fatec.carrosapp.ui.fragment.FragmentThree
import com.fatec.carrosapp.ui.fragment.FragmentTwo
import kotlinx.android.synthetic.main.activity_main.*

class OnBoardingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = MyViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(FragmentOne(), "One")
        adapter.addFragment(FragmentTwo(), "Two")
        adapter.addFragment(FragmentThree(), "Three")
        adapter.addFragment(FragmentFour(), "Four")
        view_pager.adapter = adapter
    }

    class MyViewPagerAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

        private val fragmentList : MutableList<Fragment> = ArrayList()
        private val titleList : MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getCount(): Int {
            return fragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String){
            fragmentList.add(fragment)
            titleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }

    }
}
