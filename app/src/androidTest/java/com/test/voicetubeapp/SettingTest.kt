package com.test.voicetubeapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.test.voicetubeapp.ui.main.MainActivity
import com.test.voicetubeapp.utils.TestUtils.childAtPosition
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class SettingTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun settingTest() {
        showSettingView()
    }

    private fun showSettingView() {
        val bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_setting),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottomNavigation),
                                        0),
                                1),
                        isDisplayed()))
        bottomNavigationItemView.perform(ViewActions.click())
    }

}