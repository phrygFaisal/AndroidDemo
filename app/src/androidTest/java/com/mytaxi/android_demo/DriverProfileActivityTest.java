package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.action.ViewActions.click;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * Test class to check call functionality from driver profile activity
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DriverProfileActivityTest extends DriverProfileUtility{

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    private MainActivity currentActivity = null;

    /*
    TC1: User can call driver using Call button
    ACCEPTANCE CRITERIA: User can press the floating CALL button to navigate to dialer
     */

    @Test
    public  void TC1verifyDriverCallButtonAction() {

        currentActivity = mActivityRule.getActivity();

        MainActivityAuthenticatedUtility.findDriverProfile(mActivityRule,
                MainActivityAuthenticatedUtility.sampleDriverFullName);

        findDriverCallButton().perform(click());

    }





}
