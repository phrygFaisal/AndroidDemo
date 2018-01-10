package com.mytaxi.android_demo;

import android.content.Intent;
import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.v4.content.ContextCompat.startActivity;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/7/2018.
 *
 * Utility class to aid test classes for Login
 */

public class LoginUtility {

    /*sample login credential data to be used for
        - parameterized tests.
        - test calls from other test classes
    */
    public static String testLoginUserSample =  " ", testLoginUserSamplePass = "testPassword12345";
    public static String testLoginUserInvalid = "@#$%^", testLoginUserInvalidPass = "123456";
    public static String validLoginUser = "whiteelephant261", validLoginPass = "video";



    /*
    RETURNS the viewinteraction object for the edit text username in authentication activity
     */
    public static ViewInteraction findEditTextUsername(){

        return onView(withId(R.id.edt_username));

    }

    /*
    RETURNS the viewinteraction object for the edit text password in authentication activity
     */
    public static ViewInteraction findEditTextPassword(){

        return onView(withId(R.id.edt_password));
    }

    /*
    RETURNS the viewinteraction object for the button login in authentication activity
     */
    public static ViewInteraction findLoginButton(){

        return onView(withId(R.id.btn_login));
    }

    /*
        * Aids in user login.
        * Supplement for user login that is pre-requisite to test execution from other classes.
        * Uses username and password to login via the login activity.
        * This is a utility function and NOT a test method. It does not confirm succesful login.
     */
    public static void login(String username, String password){

        /*
            locate and find username and password fields in login activity.
            input to the text field
         */
        findEditTextUsername().perform(typeText(username));
        findEditTextPassword().perform(typeText(password));

        //click the login button
        findLoginButton().perform(click());
    }


}
