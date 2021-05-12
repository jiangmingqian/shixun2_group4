package com.example.ourantask;

import android.os.RemoteException;
import android.widget.ImageButton;

import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiObject2;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OuranTest extends BaseTest {
    public void login() throws InterruptedException {
        UiObject2 userName=mDevice.findObject(By.res("com.example.shoujiedemo","login_userName"));
        userName.setText("xs");
        Thread.sleep(2000);
        UiObject2 pwd=mDevice.findObject(By.res("com.example.shoujiedemo","login_userPassword"));
        pwd.setText("xs");
        Thread.sleep(2000);
        UiObject2 loginButton=mDevice.findObject(By.res("com.example.shoujiedemo","login_login"));
        loginButton.click();
    }

    public void quit() throws InterruptedException {
        UiObject2 person=mDevice.findObject(By.res("com.example.shoujiedemo","item_owner"));
        person.click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_intent")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_logout")).click();
        Thread.sleep(2000);

    }
    @Before
    public void testLogin() throws InterruptedException, RemoteException {
        UiObject2 ouRan=mDevice.findObject(By.text("偶然"));
        ouRan.click();
        Thread.sleep(3000);
        if(mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))==null){
            quit();
            Thread.sleep(3000);
            login();
        }
        else if(mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))!=null){
            login();
        }
    }
//    取消关注再关注
    @Test
    public void test1gz() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
    }
//连续点关注
    @Test
    public void test2gz() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
    }
//点赞
    @Test
    public void test3dz() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_like")).click();
    }
//连续点赞
    @Test
    public void test4dz() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_like")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_like")).click();
    }
//    收藏
    @Test
    public void test5sc() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_collection")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/set_rl")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_btn_collect")).click();
        Thread.sleep(1000);
    }
//    评论
    @Test
    public void test6pl() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_actricle_tv_title")).click();
        Thread.sleep(2000);
        for(int i=0;i<5;i++) {
            mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_ed_comment")).setText("这是第" + i + "条评论");
            Thread.sleep(1000);
            mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_send_comment")).click();
            Thread.sleep(1000);
        }
        mDevice.pressBack();
    }
//    删除评论
    @Test
    public void test7pl() throws InterruptedException, UiObjectNotFoundException {
        Thread.sleep(2000);
        mDevice.findObject(By.text("我的关注")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_actricle_tv_title")).click();
        Thread.sleep(2000);
        UiScrollable scroll = new UiScrollable(new UiSelector().className("android.widget.RelativeLayout"));
        boolean re = false;
        re = scroll.scrollIntoView(new UiSelector().resourceId("com.example.shoujiedemo:id/btn_menu"));
        Thread.sleep(2000);
        if(re){
            mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_menu")).click();
            Thread.sleep(2000);
            mDevice.findObject(By.text("删除")).click();
            Thread.sleep(2000);
            mDevice.pressBack();
        }
        else{
            System.out.println("滚动屏幕没找到指定className");
        }

    }
//修改个人信息
    @Test
    public void test8gr() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_userInfo")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_PersonalInfo_change")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_woman")).click();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_sign")).setText("修改个人信息");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_enter")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_PersonalInfo_return")).click();
    }
//    修改个人信息
    @Test
    public void test9gr() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_userInfo")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_PersonalInfo_change")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_man")).click();
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_sign")).setText("");
        mDevice.findObject(By.res("com.example.shoujiedemo:id/userInfoChange_enter")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_PersonalInfo_return")).click();
    }
//    删除上传的音乐
    @Test
    public void testz10yy() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　音乐　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_music_btn_pull")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("删除")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/delete_content_item_btn_commit")).click();
    }
}
