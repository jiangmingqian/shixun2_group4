package com.example.shoujiedemo;

import android.app.Instrumentation;
import android.os.RemoteException;
import android.util.Log;


import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiSelector;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Demo {
    private UiDevice mDevice;
    Instrumentation instrumentation;

    @Before
    public void startUp() throws RemoteException, InterruptedException{
        instrumentation = InstrumentationRegistry.getInstrumentation();
        mDevice = UiDevice.getInstance(instrumentation);
        mDevice.pressHome();
        if(!mDevice.isScreenOn())
            mDevice.wakeUp();
        mDevice.findObject(By.text("偶然")).click();
        Thread.sleep(5000);
    }

    public void login(){
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_userName")).setText("zhang");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_userPassword")).setText("123456");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login")).click();
    }

    public void find() throws InterruptedException, UiObjectNotFoundException {
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().className("android.widget.TextView").text("文章")).click();
    }


    @Test
    public void test01() throws InterruptedException, UiObjectNotFoundException {
        String num1;
        String num2;
//        login();
        Thread.sleep(2000);
        find();
        num1 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_tv_like_num")).getText();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_like")).click();
        num2 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_tv_like_num")).getText();
        Thread.sleep(2000);
        int num3 = Integer.valueOf(num1).intValue()+1;
        int num4 = Integer.valueOf(num2).intValue();
        Assert.assertEquals(num3,num4);
        Log.e("tag1", String.valueOf(num3));
    }

    @Test
    public void test02() throws InterruptedException, UiObjectNotFoundException {
        String name;
//        login();
        Thread.sleep(2000);
        find();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("浩瀚星海");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
        Thread.sleep(2000);
        name =  mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_actricle_tv_title")).getText();
        Thread.sleep(2000);
        Assert.assertEquals("浩瀚星海",name);
        Log.e("tag2",name);
    }

    @Test
    public void test03() throws InterruptedException, UiObjectNotFoundException{
        String num1;
        String num2;
//        login();
        Thread.sleep(2000);
        find();
        num1 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_tv_fan")).getText();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        num2 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_tv_fan")).getText();
        Thread.sleep(2000);
        int num3 = Integer.valueOf(num1).intValue()+1;
        int num4 = Integer.valueOf(num2).intValue();
        Assert.assertEquals(num3,num4);
        Log.e("tag1", String.valueOf(num3));
    }

    @Test
    public void test04() throws InterruptedException, UiObjectNotFoundException{
        String text;
//        login();
        Thread.sleep(2000);
        find();
        mDevice.swipe(440,1480,310,1490,100);
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/upload_ed_article_title")).setText("这是一个文章标题");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_article_content")).setText("这是一个文章内容");
        Thread.sleep(2000);
        text  = mDevice.findObject(By.res("com.example.shoujiedemo:id/upload_ed_article_title")).getText();
        Assert.assertEquals("这是一个文章标题",text);
        Log.e("tag1", text);
    }

    @Test
    public void test05() throws InterruptedException, UiObjectNotFoundException{
        String text;
//        login();
        Thread.sleep(2000);
        find();
        mDevice.swipe(440,1480,310,1490,100);
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_article_content")).setText("这是一个文章内容");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/upload_ed_article_writer")).setText("文章作者");
        Thread.sleep(2000);
        text  = mDevice.findObject(By.res("com.example.shoujiedemo:id/upload_ed_article_writer")).getText();
        Assert.assertEquals("文章作者",text);
        Log.e("tag1", text);
    }

    @Test
    public void test06() throws InterruptedException, UiObjectNotFoundException{
        String text;
//        login();
        Thread.sleep(2000);
        find();
        mDevice.swipe(440,1480,310,1490,100);
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_article_content")).setText("这是一个文章内容");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/custom_tag")).setText("自定义文章");
        Thread.sleep(2000);
        text  = mDevice.findObject(By.res("com.example.shoujiedemo:id/custom_tag")).getText();
        Assert.assertEquals("自定义文章",text);
        Log.e("tag1", text);
    }

    @Test
    public void test07() throws InterruptedException, UiObjectNotFoundException{
        UiObject text;
//        login();
        Thread.sleep(2000);
        find();
        mDevice.swipe(440,1480,310,1490,100);
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_article_content")).setText("这是一个文章内容");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/isOriginal")).click();
        Thread.sleep(2000);
        text= mDevice.findObject(new UiSelector().checkable(true).className("android.widget.CheckBox"));
        Thread.sleep(2000);;
    }

    @Test
    public void test08() throws InterruptedException, UiObjectNotFoundException{
        String num1;
        String num2;
//        login();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().className("android.widget.TextView").text("诗")).click();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("王小波");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
        Thread.sleep(2000);
        num1 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_comment_num")).getText();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_ln_content")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_ed_comment")).setText("好");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_btn_send_comment")).click();
        Thread.sleep(2000);
        num2 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_comment_num2")).getText();
        Thread.sleep(2000);
        int num3 = Integer.valueOf(num1).intValue()+1;
        int num4 = Integer.valueOf(num2).intValue();
        Assert.assertEquals(num3,num4);
        Log.e("tag1", String.valueOf(num3));
    }

    @Test
    public void test09() throws InterruptedException, UiObjectNotFoundException{
        String num1;
        String num2;
//        login();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().className("android.widget.TextView").text("诗")).click();
        Thread.sleep(2000);
        num1 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_collection_num")).getText();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_btn_collection")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_btn_collect")).click();
        Thread.sleep(2000);
        mDevice.swipe(613,267,610,800,100);
        Thread.sleep(5000);
        num2 = mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_collection_num")).getText();
        Thread.sleep(2000);
        int num3 = Integer.valueOf(num1).intValue()+1;
        int num4 = Integer.valueOf(num2).intValue();
        Assert.assertEquals(num3,num4);
        Log.e("tag1", String.valueOf(num3));
    }

    @Test
    public void test10() throws InterruptedException, UiObjectNotFoundException {
        String name1;
        String name2;
        //        login();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround")).click();
        Thread.sleep(2000);
        mDevice.findObject(new UiSelector().className("android.widget.TextView").text("诗")).click();
        name1 =  mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_writer_name")).getText();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("王小波");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
        Thread.sleep(2000);
        mDevice.swipe(613,267,610,800,10);
        Thread.sleep(5000);
        name2 =mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_poem_tv_writer_name")).getText();
        Thread.sleep(1000);
        Assert.assertEquals(name1,name2);
        Log.e("tag1", name2);
    }
}
