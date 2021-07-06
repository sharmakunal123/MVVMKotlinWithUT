package com.jobapply.myapplication

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    LearnMainActivityTest::class,
    LearnSecondMainActivityTest::class
)
class ActivityTestSuit