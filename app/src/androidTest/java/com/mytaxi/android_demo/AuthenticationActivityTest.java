package com.mytaxi.android_demo;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * This test class tests the functional components of the activity.
 *
 * Uses parameterized tests for
 *  - sample login
 *  - invalid login
 *  - valid login
 *
 *  Parameterized that do not apply to certain tests are ignored and the result is a ignored test run.
 */

import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.Assume;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.junit.runners.Parameterized;


import java.util.Arrays;
import java.util.Collection;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withHint;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


//@RunWith(Parameterized.class)

@RunWith(Parameterized.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class AuthenticationActivityTest extends AuthenticationUtility {





        @Rule
        public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

        Type type;
        String userInput, passwordInput;

        /*
            Overloaded constructor to aid parameterized test execution

         */
        public AuthenticationActivityTest(Type type, String usernameInput, String passwordInput){
            this.type = type;
            this.userInput = usernameInput;
            this.passwordInput = passwordInput;
        }

        enum Type {sampleLogin, validLOGIN, invalidLOGIN};
        @Parameterized.Parameters
        public static Collection<Object[]> data(){
            return Arrays.asList(new Object[][] {
                    {Type.sampleLogin, AuthenticationUtility.testLoginUserSample, testLoginUserSamplePass},
                    {Type.invalidLOGIN, AuthenticationUtility.testLoginUserInvalid, testLoginUserInvalidPass},
                    {Type.validLOGIN, AuthenticationUtility.validLoginUser, AuthenticationUtility.validLoginPass}
            });
        }

        /*
        TC1: Verify user can input data in the username edit text field
        ACCEPTANCE CRITERIA:
            1. Input data in input fields.
            2. Loose focus from the field.
            3. Match user data with the input data
        THIS TEST CHECKS FOR VARIOUS TYPE OF USER INPUTS.
        */
        @Test
        public void TC1verifyInputOnUsernameEditText(){

            Assume.assumeTrue(type == Type.sampleLogin);

            findEditTextUsername().perform(typeText(userInput));
            findEditTextPassword().perform(typeText(passwordInput));

            findEditTextUsername().check(matches(withText(userInput)));
        }

        /*
        TC2: Verify invalid login for user
        STEPS:
            1. Input invalid data in input fields.
            2. Click on Login
        ACCEPTANCE CRITERIA: Failed Login
        THIS TEST CHECKS FOR VARIOUS TYPE OF USER INPUTS.
        */
        @Test
        public void TC2verifyFailedLoginOnInvalidInpput(){

            Assume.assumeTrue(type == Type.invalidLOGIN);

            findEditTextUsername().perform(typeText(userInput));
            findEditTextPassword().perform(typeText(passwordInput));

            findLoginButton().perform(click());

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            onView(withText("Login failed")).check(matches(isDisplayed()));
        }

        /*
        TC3: Verify valid login
        ACCEPTANCE CRITERIA: User can login with valid credentials
        */
        @Test
        public void TC3verifyValidUserLogin(){

            Assume.assumeTrue(type == Type.validLOGIN);

            findEditTextUsername().perform(typeText(userInput));
            findEditTextPassword().perform(typeText(passwordInput));

            findLoginButton().perform(click());
        }


}




