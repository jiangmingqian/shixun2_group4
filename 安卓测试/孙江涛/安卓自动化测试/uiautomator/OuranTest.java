package com.example.myapplication;

import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class OuranTest {
    UiDevice mDevice;
//    public void quit(){
//
//    }

    @Before
    public void testLogin() throws InterruptedException, RemoteException {
        //获取设备，连接模拟器
        mDevice = UiDevice.getInstance
                (InstrumentationRegistry.
                        getInstrumentation());
        if (mDevice.isScreenOn()) {
            mDevice.wakeUp();

        }
        mDevice.pressHome();
        int width = mDevice.getDisplayWidth();
        int height = mDevice.getDisplayHeight();
        Log.w("Width:", String.valueOf(width));
        Log.w("Height:", height + "");
//        mDevice.click(1066,271);
//        mDevice.pressKeyCode(KeyEvent.KEYCODE_0);

//        mDevice.drag(1345,455,516,455,8);
        Thread.sleep(8000);

        UiObject2 ouran1 = mDevice.findObject(By.text("偶然"));
        Thread.sleep(3000);
//        UiObject todolist2=mDevice.findObject
//                (new UiSelector().text("ToDoList"));
        ouran1.click();
        Thread.sleep(3000);

    }
    @Test
    public void test_register_success() throws InterruptedException, IOException {
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/login_register"))
                .click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_name"))
                .setText("123");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_password"))
                .setText("123");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_repeatPassword"))
                .setText("123");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_register"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);

    }
    @Test
    public void test_register_fail() throws InterruptedException, IOException {
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/login_register"))
                .click();
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_name"))
                .setText("123");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_password"))
                .setText("123");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_repeatPassword"))
                .setText("111");
        Thread.sleep(3000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/register_register"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);

    }
    @Test
    public void test_alogin_fail() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("111111");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);


    }
    @Test
    public void test_blogin_success() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);


    }
//
    @Test
    public void test_setDate() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/btn_date"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("17")).click();

        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);

    }
    @Test
    public void test_setdianzan() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("我的关注")).click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_btn_like")).click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_setpinglun() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("我的关注")).click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_btn_comment"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_setshouchang() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("我的关注")).click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_btn_collection"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_btn_collect"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_setwenzhang() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("我的关注")).click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_iv_cover"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_sethuifu() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject(new UiSelector().text("我的关注")).click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_iv_cover"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_ed_comment"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/follow_article_btn_send_comment"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }


    @Test
    public void test_setmydianzan() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);

        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_myAgreement"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_mypinglun() throws InterruptedException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);

        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_Storing"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_myguaunzhu() throws InterruptedException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);

        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_myFollow"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_setnight() throws InterruptedException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);

        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_setting_intent"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }
    @Test
    public void test_setclear() throws InterruptedException {
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userName"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/login_userPassword"))
                .setText("123");
        Thread.sleep(3000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                .click();
        Thread.sleep(3000);

        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_setting_intent"))
                .click();
        Thread.sleep(3000);
        mDevice.findObject
                (By.res("com.example.shoujiedemo:id/myCenter_setting_clearCookie"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
        Thread.sleep(3000);
    }








//    @Test
//    public void testDeleteAll() throws InterruptedException, UiObjectNotFoundException {
//        UiObject2 lv = mDevice.findObject(By.res("android:id/list"));
//        int count=lv.getChildCount();
//        Log.w("count",count+"");
//        while (count>=0){
//            mDevice.findObject(By.res("android:id/text1"))
//                    .click(3000);
//            Thread.sleep(3000);
//            mDevice.findObject(new UiSelector().text("Delete")).click();
//            Thread.sleep(3000);
//            count--;
//        }
//
//    }
//    @Test
//    public void testPaste() throws InterruptedException, UiObjectNotFoundException {
//        mDevice.findObject(By.res("android:id/text1")).click(3000);
//        Thread.sleep(3000);
//
//        mDevice.findObject(new UiSelector().text("Copy")).click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.clazz("android.widget.ImageButton")).click();
//        Thread.sleep(3000);
//        mDevice.findObject(new UiSelector().text("Paste")).click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.android.notepad:id/menu_save")).click();
//
//    }
//
//    @Test
//    public void testUpdate() throws InterruptedException, UiObjectNotFoundException {
//        mDevice.findObject(By.res("android:id/text1")).click(3000);
//        Thread.sleep(3000);
//        mDevice.findObject(new UiSelector().text("Edit title")).click();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.android.notepad:id/title")).clear();
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.android.notepad:id/title")).setText("修改");
//        Thread.sleep(3000);
//        mDevice.findObject(By.res("com.example.android.notepad:id/ok")).click();
//        Thread.sleep(3000);
//
//
//
//
//    }
//
}
