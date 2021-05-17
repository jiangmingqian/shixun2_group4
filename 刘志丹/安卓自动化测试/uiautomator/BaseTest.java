package com.example.ourantask;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.UiDevice;
import org.junit.Before;

public class BaseTest {
    UiDevice mDevice;
    @Before
    public void init(){
        //        获得默认连接设备的模拟器
        mDevice= UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressHome();
    }
}
