package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * test class for testing UI components of the activity
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverProfileActivityUITest extends DriverProfileUtility{

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity currentActivity = null;

    /*
    TC1: User can see the driver profile card

    ACCEPTANCE CRITERIA: Verifies the presence of Driver Profile Info
        1. Title of activity.
        2. Name of Driver.
        3. Location of Driver.
        4. Driver Image Avatar display
     */
    @Test
    public void TC1verifyDriverProfile() {

        //currentActivity = mActivityRule.getActivity();

        MainActivityAuthenticatedUtility.findDriverProfile(mActivityRule,
                MainActivityAuthenticatedUtility.sampleDriverFullName);

        findDriverProfileTitle().check(matches(isDisplayed()));
        findDriverProfileName().check(matches(isDisplayed()));
        findDriverLocationText().check(matches(isDisplayed()));
        findDriverImage().check(matches(isDisplayed()));


    }

}

