package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasFocus;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * This test class tests the UI components of the activity
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthenticationActivityUITest extends AuthenticationUtility {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    /*
    TC1: Verify Username edit text field has focus by default when activity is loaded
    ACCEPTANCE CRITERIA: Cursor is displayed in username edit text field.
     */
    @Test
    public void TC1verifyFocusOnUsernameEditText(){

        findEditTextUsername().check(matches(hasFocus()));
    }

    /*
    TC2: Verify Password edit text field is Visible to User
    ACCEPTANCE CRITERIA: Password field is displayed in activity
     */
    @Test
    public void TC2verifyPasswordEditTextDisplay(){

        findEditTextPassword().check(matches(isDisplayed()));
    }


    /*
    TC3: Verify LOGIN button is clickable for user
    ACCEPTANCE CRITERIA: Click action can be performed on the button
     */
    @Test
    public void TC3verifyLoginButtonClickability(){

        findLoginButton().check(matches(isClickable()));
    }


}
