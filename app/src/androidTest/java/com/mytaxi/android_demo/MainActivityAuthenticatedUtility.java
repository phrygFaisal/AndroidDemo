package com.mytaxi.android_demo;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.GeneralLocation;
import android.support.test.espresso.action.GeneralSwipeAction;
import android.support.test.espresso.action.Press;
import android.support.test.espresso.action.Swipe;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import com.mytaxi.android_demo.activities.MainActivity;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * Serves as utility class for test classes MainActivityAuthenticated and UI.
 */

public class MainActivityAuthenticatedUtility {

    public static String sampleDriverInCompleteName = "Sarah FriedRi";
    public static String sampleDriverFullName = "Sarah Friedrich";


    /*
    RETURNS the viewinteraction object for the title bar.
     */

    public ViewInteraction getHomeTitleBar(){

        return onView(withText("mytaxi demo"));
    }

    /*
    RETURNS the viewinteraction object for the search bar
     */

    public static ViewInteraction getSearchBar(){

        return onView(withId(R.id.textSearch));
    }

    /*
    RETURNS the viewinteraction object for the toolbar.
     */
    public static ViewInteraction getToolbar(){

        return onView(withId(R.id.toolbar));
    }

    /*
    RETURNS the viewinteraction object for the username in navigation drawer
     */
    public  ViewInteraction getUsernameInNavigationDrawer(){

        return onView(withId(R.id.nav_username));
    }

    /*
    RETURNS the viewinteraction object for the logout navigation in drawer
     */
    public static ViewInteraction getLogoutNavigationControl(){

        return onView(withText("Logout"));
    }

    /*
    RETURNS the viewinteraction object for search container
     */
    public ViewInteraction getSearchContainer(){

        return onView(withId(R.id.searchContainer));
    }


    /*
    /*
    RETURNS the view action on defined location.
    * Burps out parameters definition to calling function.
    * Parameter defines right swipe, starting location, ending location and fast gesture
     */

    public static ViewAction customSwipeRightFast() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.TOP_LEFT,
                GeneralLocation.TOP_RIGHT, Press.FINGER);
    }

    /*
    /*
    RETURNS the view action on defined location.
    * Burps out parameters definition to calling function.
    * Parameter defines right swipe, starting location, ending location and slow gesture
     */
    public static ViewAction customSwipeRightSlow() {
        return new GeneralSwipeAction(Swipe.SLOW, GeneralLocation.TOP_LEFT,
                GeneralLocation.TOP_RIGHT, Press.FINGER);
    }


    /*
        * Aids in navigating to driver login
        * Supplement for tests and serves as pre-requisite to test execution from other classes.
        * Uses driver name and navigates from main activity to driver activity
        * This is a utility function and NOT a test method. It does not confirm succesful login.
     */
    public static void findDriverProfile(ActivityTestRule<MainActivity> mActivityRule,
                                         String driverName){

        MainActivity currentActivity = mActivityRule.getActivity();

        getSearchBar().perform(typeText(driverName));

        onView(withText(driverName))
                .inRoot(withDecorView(not(is(currentActivity.getWindow().getDecorView()))))
                .perform(click());
    }

    public static void logOutCurrentUser(){

        getToolbar().perform(MainActivityAuthenticatedUtility.customSwipeRightSlow());

        getLogoutNavigationControl().perform(click());



    }


}
