package com.example.app;

import android.telephony.UiccCardInfo;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiCollection;
import androidx.test.uiautomator.UiObject;
import androidx.test.uiautomator.UiObjectNotFoundException;
import androidx.test.uiautomator.UiScrollable;
import androidx.test.uiautomator.UiSelector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;


@RunWith(AndroidJUnit4.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SettingTest extends BaseTest {

    @Before
    public void init_test() throws UiObjectNotFoundException, InterruptedException {
        if(mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))!=null) {
            mDevice.findObject(By.res("com.example.shoujiedemo:id/login_userName"))
                    .setText("1234567");
            mDevice.findObject(By.res("com.example.shoujiedemo:id/login_userPassword"))
                    .setText("1234567");
            mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login"))
                    .click();
            Thread.sleep(3000);
            mDevice.findObject(By.res("com.example.shoujiedemo:id/item_owner"))
                    .click();
            Thread.sleep(2000);
            mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_intent"))
                    .click();
            Thread.sleep(2000);
        }
    }

    //开启夜间模式
    @Test
    public void test1NightModeOn() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch"))
                .click();
        Thread.sleep(1000);
        Boolean checked = mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch"))
                .isChecked();
        Assert.assertEquals(checked,true);
    }

    //关闭夜间模式
    @Test
    public void test2NightModeOff() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch"))
                .click();
        Thread.sleep(1000);
        Boolean checked = mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch"))
                .isChecked();
        Assert.assertEquals(checked, false);
    }

    //修改密码(正常输入)
    @Test
    public void test3ChangePwd1() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_oldKey"))
                .setText("1234567");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_newKey"))
                .setText("testnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_repeatKey"))
                .setText("testnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_enter"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_return"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(1000);
    }

    //修改密码(输入的新密码为空)
    @Test
    public void test4ChangePwd2() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_oldKey"))
                .setText("1234567");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_newKey"))
                .setText("");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_repeatKey"))
                .setText("");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_enter"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_return"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(1000);
    }

    //修改密码(输入的原密码有误)
    @Test
    public void test5ChangePwd3() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_oldKey"))
                .setText("wrongoldkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_newKey"))
                .setText("testnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_repeatKey"))
                .setText("testnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_enter"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_return"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(1000);
    }

    //修改密码(输入的新密码过长)
    @Test
    public void test6ChangePwd4() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_oldKey"))
                .setText("1234567");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_newKey"))
                .setText("thenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolong");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_repeatKey"))
                .setText("thenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolong");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_enter"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_return"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(1000);
    }

    //修改密码(两次输入的新密码不一致)
    @Test
    public void test7ChangePwd5() throws UiObjectNotFoundException, InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_oldKey"))
                .setText("1234567");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_newKey"))
                .setText("testnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_repeatKey"))
                .setText("differentnewkey");
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_enter"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/changePassword_return"))
                .click();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(1000);
    }

    //清理缓存
    @Test
    public void test8ClearCookie() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_clearCookie"))
                .click();
        Thread.sleep(2000);
        String cSize = mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_cookieSize"))
                .getText();
        Assert.assertEquals(cSize,"0.0MB");
        Thread.sleep(1000);
    }

    //注销账户
    @Test
    public void test9DestoryAccount() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_destroyAccount"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/destroyAccount_enter"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/destroyAccount_return"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_safe_return"))
                .click();
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_return"))
                .click();
        Thread.sleep(2000);
        String currentUser = mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_userName"))
                .getText();
        Thread.sleep(1000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_intent"))
                .click();
        Thread.sleep(2000);
        Assert.assertNotEquals(currentUser,"1234567");
    }

    //退出登录
    @Test
    public void testxLogout() throws InterruptedException {
        Thread.sleep(2000);
        mDevice.findObject(By.res("com.example.shoujiedemo:id/myCenter_setting_logout"))
                .click();
        Thread.sleep(2000);
        Assert.assertNotEquals(mDevice.findObject(By.res("com.example.shoujiedemo:id/login_login")),null);
    }

}
