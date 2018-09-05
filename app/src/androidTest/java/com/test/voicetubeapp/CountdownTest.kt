package com.test.voicetubeapp

import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.replaceText
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import org.junit.Test
import org.junit.runner.RunWith
import com.test.voicetubeapp.ui.main.MainActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
@LargeTest
class CountdownTest {

    @Rule
    @JvmField
    var mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

    @Test
    fun countdownTest() {
        showCountdownView()
        fillOutSecondEditText()
        clickCountdownBtn()
    }

    private fun showCountdownView() {
        val bottomNavigationItemView = onView(
                allOf(withId(R.id.navigation_countdown),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.bottomNavigation),
                                        0),
                                2),
                        isDisplayed()))
        bottomNavigationItemView.perform(click())
    }

    private fun fillOutSecondEditText() {
        val appCompatEditText = onView(
                allOf(withId(R.id.secondEditText),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.fragmentContent),
                                        0),
                                1),
                        isDisplayed()))
        appCompatEditText.perform(replaceText("10"), closeSoftKeyboard())

    }

    private fun clickCountdownBtn() {
        val appCompatButton = onView(
            allOf(withId(R.id.countdownBtn), withText("Countdown"),
                    childAtPosition(
                            childAtPosition(
                                        withId(R.id.fragmentContent),
                                        0),
                                2),
                    isDisplayed()))
        appCompatButton.perform(click());
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