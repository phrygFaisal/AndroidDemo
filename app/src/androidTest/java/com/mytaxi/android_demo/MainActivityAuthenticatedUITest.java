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
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * Tests UI components of the Main Activity that is reached after Authentication.
 * No functional features such as login confirmation or logout are tested here.
 */

@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityAuthenticatedUITest extends MainActivityAuthenticatedUtility {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    /*
    TC1: Verify main activity title says "mytaxi demo"
        ACCEPTANCE CRITERIA: The title is displayed
     */

    @Test
    public void TC1verifyAppTitleBar(){

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        getHomeTitleBar().check(matches(isDisplayed()));
    }

    /*
        TC2: Verify search bar is displayed
    ACCEPTANCE CRITERIA: The search bar is displayed
     */

    @Test
    public void TC2verifyIsDisplayedSearchBar(){

        getSearchBar().check(matches(isDisplayed()));
    }

    /*
    TC3: Verify search bar is clickable
    ACCEPTANCE CRITERIA: User can tap on the search bar
     */

    @Test
    public void TC3verifyIsClickableSearchBar(){

        getSearchBar().check(matches(isClickable()));
    }

    /*
    TC4: Verify Swipe action in App Home
    ACCEPTANCE CRITERIA: User can perform fast swipe gesture to open navigation drawer on left.
     */

    @Test
    public void TC4verifyNavigationDrawerLayoutOpenFast() {

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightFast());

    }

    /*
    TC5: Verify Swipe action in App Home
    ACCEPTANCE CRITERIA: User can perform slow swipe gesture to open navigation drawer on left.
     */

    @Test
    public void TC5verifyNavigationDrawerLayoutOpenSlow() {

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightSlow());

    }

    /*
    TC6: Verify Username is displayed for logged in user
    ACCEPTANCE CRITERIA: Displayed username in navigation should be the same as logged in user.
     */

    @Test
    public void TC6verifyLoggedUserInformation() {

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightFast());

        getUsernameInNavigationDrawer().check(matches(withText(AuthenticationUtility.validLoginUser)));
    }

    /*
    TC7: Verify Logout control is visible to user
    ACCEPTANCE CRITERIA: Logout control is displayed in navigation drawer.
     */

    @Test
    public void TC7verifyIsVisibleLogoutControl() {

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightSlow());

        getLogoutNavigationControl().check(matches(isDisplayed()));
    }




}