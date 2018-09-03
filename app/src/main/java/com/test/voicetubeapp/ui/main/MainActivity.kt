package com.test.voicetubeapp.ui.main

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import com.test.voicetubeapp.R
import com.test.voicetubeapp.databinding.ActivityMainBinding
import com.test.voicetubeapp.ui.base.BaseActivity
import com.test.voicetubeapp.ui.countdown.CountdownFragment
import com.test.voicetubeapp.ui.list.ListFragment
import com.test.voicetubeapp.ui.setting.SettingFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity: BaseActivity<ActivityMainBinding, MainViewModel>()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupView()
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun getViewModelClass(): Class<MainViewModel>? {
        return MainViewModel::class.java
    }

    private fun setupView() {
        window.statusBarColor = ContextCompat.getColor(this, R.color.black)

        bottomNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        val fragment = ListFragment.newInstance() as Fragment
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit()
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener {
        when(it.itemId) {
            R.id.navigation_list -> {
                val fragment = ListFragment.newInstance() as Fragment
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit()
                true
            }

            R.id.navigation_setting -> {
                val fragment = SettingFragment.newInstance() as Fragment
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit()
                true
            }

            R.id.navigation_countdown -> {
                val fragment = CountdownFragment.newInstance() as Fragment
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, fragment).commit()
                true
            }
        }
        false
    }

}
