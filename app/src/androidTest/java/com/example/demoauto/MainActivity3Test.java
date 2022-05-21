package com.example.demoauto;

import static org.junit.Assert.*;

import android.view.View;

import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class MainActivity3Test {

    @Rule
    public ActivityTestRule<MainActivity3> mActivityTestRule = new ActivityTestRule<MainActivity3>(MainActivity3.class);
    private MainActivity3 mainActivity3 = null;

    @Before
    public void setUp() throws Exception {

        mainActivity3 = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch()
    {
        View view = mainActivity3.findViewById(R.id.button2);
        assertNotNull(view);
    }


    @After
    public void tearDown() throws Exception {
        mainActivity3 = null;
    }
}
