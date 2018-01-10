package com.mytaxi.android_demo;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.mytaxi.android_demo.activities.MainActivity;

import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.v4.util.Preconditions.checkNotNull;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.collection.IsMapContaining.hasEntry;
import static org.hamcrest.core.Is.is;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * Test class for testing functionality of the activity such as Logout and Searching Drivers.
 */



@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MainActivityAuthenticatedTest extends MainActivityAuthenticatedUtility {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<MainActivity>(MainActivity.class);


    private MainActivity currentActivity = null;


    /*
    TC1: User can search in the search box and get automatic suggestions
    ACCEPTANCE CRITERIA: Search results are displayed
     */
    @Test
    public void TC1verifyUserLogOut() {

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightSlow());

        getLogoutNavigationControl().perform(click());

        AuthenticationUtility.findLoginButton().check(matches(isDisplayed()));
    }


    /*
    TC2: User can search in the search box and get automatic suggestions
    ACCEPTANCE CRITERIA: Search results are displayed
     */
    @Test
    public void TC2verifyAutomaticSearchSuggestion() {

       AuthenticationUtility.login(AuthenticationUtility.validLoginUser, AuthenticationUtility.validLoginPass);

       currentActivity = mActivityRule.getActivity();

       getSearchBar().perform(typeText(sampleDriverInCompleteName));

       onView(withText(sampleDriverFullName))
                .inRoot(withDecorView(not(is(currentActivity.getWindow().getDecorView()))))
                .check(matches(isDisplayed()));
    }

    /*
    TC2: User click action on search results
    ACCEPTANCE CRITERIA: Search results can be clicked by user
     */
    @Test
    public void TC3verifyAutoSearchSuggestionClick() {

        currentActivity = mActivityRule.getActivity();

        getSearchBar().perform(typeText(sampleDriverFullName));

        onView(withText(sampleDriverFullName))
                .inRoot(withDecorView(not(is(currentActivity.getWindow().getDecorView()))))
                .perform(click());
    }

}
