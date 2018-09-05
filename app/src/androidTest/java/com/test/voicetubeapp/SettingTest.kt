package com.test.voicetubeapp

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import com.test.voicetubeapp.ui.main.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
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
        val bottomNavigationItemView = Espresso.onView(
                Matchers.allOf(ViewMatchers.withId(R.id.navigation_setting),
                        ListTest.childAtPosition(
                                ListTest.childAtPosition(
                                        ViewMatchers.withId(R.id.bottomNavigation),
                                        0),
                                1),
                        ViewMatchers.isDisplayed()))
        bottomNavigationItemView.perform(ViewActions.click())
    }

    companion object {
        fun childAtPosition(parentMatcher: Matcher<View>, position: Int): Matcher<View> {
            return object: TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return (parent is ViewGroup
                            && parentMatcher.matches(parent)
                            && view == parent.getChildAt(position))
                }
            }
        }
    }

}