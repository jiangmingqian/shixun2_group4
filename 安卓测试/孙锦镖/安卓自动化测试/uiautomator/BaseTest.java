package com.example.ch10revicer;


import android.os.RemoteException;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;

public class BaseTest {
    UiDevice mDevice;

    @Before
    public void initDevice() throws InterruptedException {
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        try {
            if(mDevice.isScreenOn()){
                mDevice.wakeUp();

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        mDevice.pressHome();

        UiObject2 todolist=mDevice.findObject(By.text("偶然"));
        todolist.click();
        Thread.sleep(3000);

        login();

    }
    public void login() throws InterruptedException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("a");
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("a");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(2000);
    }
}
