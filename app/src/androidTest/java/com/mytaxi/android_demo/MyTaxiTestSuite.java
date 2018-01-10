package com.mytaxi.android_demo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * Serves as the Test Suite class for running the tests
 * This is the first point of startup when tests are executed.
 *
 *
 * add/comment test classes here to design test run.
 *
 *
 */


@RunWith(Suite.class)
@Suite.SuiteClasses({
        AuthenticationActivityUITest.class,
        AuthenticationActivityTest.class,
        MainActivityAuthenticatedUITest.class,
        MainActivityAuthenticatedTest.class,
        DriverProfileActivityTest.class,
        DriverProfileActivityUITest.class
})
public class MyTaxiTestSuite {

    //Nothing to add here for test execution
}
