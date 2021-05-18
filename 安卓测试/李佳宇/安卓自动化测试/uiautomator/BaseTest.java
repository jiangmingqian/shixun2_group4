package com.example.app;

import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;

public class BaseTest {

    UiDevice mDevice;

    @Before
    public void testBefore() throws InterruptedException, RemoteException, UiObjectNotFoundException {
        mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

        if(!mDevice.isScreenOn()) {
            mDevice.wakeUp();
        }

        mDevice.pressHome();

        int width = mDevice.getDisplayWidth();
        int height = mDevice.getDisplayHeight();

        Log.w("Width:", String.valueOf(width));
        Log.w("Height:", height+"");

//        mDevice.pressKeyCode(KeyEvent.KEYCODE_0);

        mDevice.pressHome();

        Thread.sleep(10000);

        UiObject ouran = mDevice.findObject(new UiSelector().text("偶然"));

        ouran.click();

        Thread.sleep(5000);

    }

}
