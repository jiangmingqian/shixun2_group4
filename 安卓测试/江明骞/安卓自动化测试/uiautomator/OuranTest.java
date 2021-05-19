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
        userName.setText("jmq");
        Thread.sleep(2000);
        UiObject2 pwd=mDevice.findObject(By.res("com.example.shoujiedemo","login_userPassword"));
        pwd.setText("123456");
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
	
	//发现界面
    @Test
    public void test1() throws InterruptedException {
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_fround"))
                .click();
        Thread.sleep(3000);
        mDevice.pressBack();
    }
	
	
//    发现——音乐界面
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　音乐　　")).click();
        Thread.sleep(2000);
    }
	
	
	//    发现——感悟界面
    @Test
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　感悟　　")).click();
        Thread.sleep(2000);
    }
	
	//    发现——热门界面
    @Test
    public void test4() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　热门　　")).click();
        Thread.sleep(2000);
    }
	
	
//   点击关注后取消
    @Test
    public void test5() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　热门　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_article_btn_follow")).click();
    }
//    点赞后取消
    @Test
    public void test6() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　热门　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
    }

//    收藏
    @Test
    public void test7() throws InterruptedException {
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
	
	//    删除上传的感悟
    @Test
    public void test8() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　感悟　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/follow_heart_btn_pull")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("删除")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/delete_content_item_btn_commit")).click();
    }



//    删除上传的音乐
    @Test
    public void test9() throws InterruptedException {
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
	
	//在感悟中搜索
	@Test
    public void test10() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　感悟　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).clear();
		mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("五一");
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
    }
	//在音乐中空白搜索
	@Test
    public void test11() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_mySpace")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.text("　　音乐　　")).click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).clear();
		mDevice.findObject(By.res("com.example.shoujiedemo:id/ed_search")).setText("");
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/btn_search")).click();
    }
	
}
