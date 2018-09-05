package com.test.voicetubeapp

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith
import com.test.voicetubeapp.ui.main.MainActivity
import com.test.voicetubeapp.utils.TestUtils.childAtPosition
import org.hamcrest.Matchers.allOf
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@LargeTest
class ListTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun listTest() {
        showListView()
    }

    private fun showListView() {
        val bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_list),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottomNavigation),
                                        0),
                                0),
                        isDisplayed()))
        bottomNavigationItemView.perform(click())
    }

}