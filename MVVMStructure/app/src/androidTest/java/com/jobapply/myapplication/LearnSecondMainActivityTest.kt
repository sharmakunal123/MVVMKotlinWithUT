package com.jobapply.myapplication

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Pattern

@RunWith(AndroidJUnit4ClassRunner::class)
class LearnSecondMainActivityTest {

    @get:Rule
    val activityScenario = ActivityScenario.launch(LearnSecondMainActivity::class.java)

    @Test
    fun test_isActivityInView() {
        Espresso.onView(ViewMatchers.withId(R.id.secondary)).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
    }

    @Test
    fun test_visibility_tite_back_button() {
        Espresso.onView(
            ViewMatchers.withId(R.id.activity_secondary_title)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.isDisplayed()
            )
        )
        // Espresso.onView(ViewMatchers.withId(R.id.activity_secondary_title))
        // .check(ViewAssertions.matches(ViewMatchers.withText("Testing")))
    }
}