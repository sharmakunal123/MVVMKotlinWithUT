package com.jobapply.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class LearnMainActivityTest {

    @Test
    fun test_isActivityInView() {
        val activityScenario = ActivityScenario.launch(LearnMainActivity::class.java)

        Espresso.onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


    @Test
    fun test_visibility_next_button() {
        val activityScenario = ActivityScenario.launch(LearnMainActivity::class.java)

        Espresso.onView(withId(R.id.activity_main_title)).check(matches(isDisplayed()))
        // First Way
        Espresso.onView(withId(R.id.button_next_activity)).check(matches(isDisplayed()))
        // Second Way to do same
        Espresso.onView(withId(R.id.button_next_activity))
            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))

    }

    @Test
    fun test_isTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(LearnMainActivity::class.java)
        Espresso.onView(withId(R.id.activity_main_title))
            .check(matches(withText(R.string.text_mainactivity)))
    }
}