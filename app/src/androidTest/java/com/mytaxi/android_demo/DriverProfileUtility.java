package com.mytaxi.android_demo;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isRoot;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by SHEIKH FAISAL MISKHAT on 1/9/2018.
 *
 * utility class to aid in testing gof Driver Profile UI and funcionality.
 */

public class DriverProfileUtility {

    /*
    RETURNS the view interaction object for the Driver Call button
     */
    public static ViewInteraction findDriverCallButton(){

        return onView(withId(R.id.fab));
    }

    /*
    RETURNS the view interaction object for the driver profile title
     */

    public ViewInteraction findDriverProfileTitle(){

        return onView(withText("Driver Profile"));
    }

    /*
    RETURNS the view interaction object for the Driver Profile Name
     */
    public ViewInteraction findDriverProfileName(){

        return onView(withId(R.id.textViewDriverName));
    }

    /*
    RETURNS the view interaction object for the Driver Location Text
     */
    public ViewInteraction findDriverLocationText(){
        return onView(withId(R.id.textViewDriverLocation));
    }

    /*
    RETURNS the view interaction object for the Driver Image Avatar
     */
    public ViewInteraction findDriverImage(){

        return onView(withId(R.id.imageViewDriverAvatar));
    }


}
