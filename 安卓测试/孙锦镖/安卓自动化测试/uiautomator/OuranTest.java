package com.example.ch10revicer;

import android.util.Log;

import androidx.test.espresso.UiController;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;

import org.junit.After;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OuranTest extends BaseTest{
    @Test
    //个人界面
    public void test1() throws InterruptedException {
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(3000);
        this.mDevice.pressBack();
    }
    //发现界面
    @Test
    public void test2() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround"))
                .click();
        Thread.sleep(3000);
        this.mDevice.pressBack();
    }
    //我的空间
    @Test
    public void test3() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace"))
                .click();
        Thread.sleep(3000);
        this.mDevice.pressBack();
    }
    //删除文集
    @Test
    public void test4() throws InterruptedException {
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/article_choose")).click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.text("删除")).click();
        Thread.sleep(1000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }
    //我的评论
    @Test
    public void test5() throws InterruptedException {
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_Storing"))
                .click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }

    //个人中心
    @Test
    public void test6() throws InterruptedException {
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_userInfo"))
                .click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }

    //帮助中心
    @Test
    public void test7() throws InterruptedException {
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_helpCenter"))
                .click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }
    //我的关注
    @Test
    public void test8() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround"))
                .click();
        Thread.sleep(2000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_heart_btn_follow"))
                .click();
        Thread.sleep(2000);
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_myFollow"))
                .click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }
    //我的点赞/取消点赞
    @Test
    public void test9() throws InterruptedException {
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround"))
                .click();
        Thread.sleep(5000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_heart_tv_like_num"))
                .click();
        Thread.sleep(2000);
        this.mDevice.findObject
                (By.res("com.example.shoujiedemo:id/item_owner"))
                .click();
        Thread.sleep(1000);
        this.mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_myAgreement"))
                .click();
        Thread.sleep(2000);
        this.mDevice.pressBack();
        this.mDevice.pressBack();
    }

}
