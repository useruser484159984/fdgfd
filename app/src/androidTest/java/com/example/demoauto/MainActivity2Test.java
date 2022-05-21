package com.example.demoauto;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivity2Test {

    @Rule
    public ActivityTestRule<MainActivity2> mActivityTestRule = new ActivityTestRule<MainActivity2>(MainActivity2.class);
    private MainActivity2 mainActivity2 = null;

    @Before
    public void setUp() throws Exception {

        mainActivity2 = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view = mainActivity2.findViewById(R.id.button2);
        assertNotNull(view);
    }


    @After
    public void tearDown() throws Exception {
        mainActivity2 = null;
    }
}