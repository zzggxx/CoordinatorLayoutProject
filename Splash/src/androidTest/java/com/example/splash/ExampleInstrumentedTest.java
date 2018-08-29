package com.example.splash;

import android.support.test.runner.AndroidJUnit4;
import android.util.Base64;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getTargetContext();
//
//        assertEquals("com.example.splash", appContext.getPackageName());

        String str = "a";
        String stringBase64 = Base64.encodeToString(str.getBytes(), Base64.NO_PADDING);
        System.out.println(stringBase64);
    }
}
