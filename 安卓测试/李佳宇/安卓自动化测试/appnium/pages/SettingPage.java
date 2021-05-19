package pages;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelDataProvider;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class SettingPage {
	
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	
//	构造方法
	
	public SettingPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
//	页面对象
	
	public AndroidElement login_userName() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userName");
	}
	
	public AndroidElement login_userPassword() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userPassword");
	}
	
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.shoujiedemo:id/login_login");
	}
	
	public AndroidElement item_owner() {
		return driver.findElementById("com.example.shoujiedemo:id/item_owner");
	}
	
	public AndroidElement btn_setting() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_intent");
	}
	
	public AndroidElement switch_nightMode() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch");
	}
	
	public AndroidElement setting_safe() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe");
	}
	
	public AndroidElement clearCookie() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_clearCookie");
	}
	
	public AndroidElement cookieSize() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_cookieSize");
	}
	
	public AndroidElement helpAndFeedback() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_feedback");
	}
	
	public AndroidElement helpAndFeedback_return() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_feedback_return");
	}
	
	public AndroidElement about() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_about");
	}
	
	public AndroidElement about_return() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_about_return");
	}
	
	public AndroidElement btn_logout() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_logout");
	}
	
	public AndroidElement btn_return1() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_return");
	}
	
	public AndroidElement changePwd() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword");
	}
	
	public AndroidElement setSafeQuestion() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_setSafeQuestion");
	}
	
	public AndroidElement setSafeQuestion_return() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_setSafeQuestion_return");
	}
	
	public AndroidElement setEmail() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_setEmail");
	}
	
	public AndroidElement setEmail_return() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_setEmail_return");
	}
	
	public AndroidElement destoryAccount() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_destroyAccount");
	}
	
	public AndroidElement switch_destoryAccount() {
		return driver.findElementById("com.example.shoujiedemo:id/destroyAccount_switch");
	}
	
	public AndroidElement btn_destoryAccount() {
		return driver.findElementById("com.example.shoujiedemo:id/destroyAccount_enter");
	}
	
	public AndroidElement destoryAccount_return() {
		return driver.findElementById("com.example.shoujiedemo:id/destroyAccount_return");
	}
	
	public AndroidElement btn_return2() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_return");
	}
	
	public AndroidElement text_oldKey() {
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_oldKey");
	}
	
	public AndroidElement text_newKey() {
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_newKey");
	}

	public AndroidElement text_repeatKey() {
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_repeatKey");
	}
	
	public AndroidElement btn_changePwd() {
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_enter");
	}
	
	public AndroidElement btn_return3() {
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_return");
	} 
	
	public AndroidElement userName() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_userName");
	} 
	
//	页面操作方法	
	
	//登录并切换到设置页面
	
	public void loginToSettingPage() throws InterruptedException {		
		action.type(login_userName(),"1234567");
		action.type(login_userPassword(),"1234567");
		action.click(btn_login());
		action.click(item_owner());
		action.click(btn_setting());
	}
	
	//夜间模式开关
	public void nightModeSwitcher() {
		action.click(switch_nightMode());
	}
	
	//
	public String getChecked() {
		return switch_nightMode().getAttribute("checked");
	}
	
	//修改密码
	public void changePassword(String oldKey,String newKey,String repeatKey) {
		action.click(setting_safe());
		action.click(changePwd());
		action.type(text_oldKey(),oldKey);
		action.type(text_newKey(),newKey);
		action.type(text_repeatKey(),repeatKey);
		action.click(btn_changePwd());
		action.click(btn_return3());
		action.click(btn_return2());
	}
	
	//获取Toast的文本信息
	public String getToastText() {
		return action.getToast();
	}
	
	//清理缓存
	public void clearCookies() {
		action.click(clearCookie());
	}
	
	//获取缓存大小
	public String getCookieSize() {
		return cookieSize().getText();
	}
	
	//退出登录
	public void logout() {
		action.click(btn_logout());
	}
	
	//返回键(设置页)
	public void return1() {
		action.click(btn_return1());
	}
	
	//设置
	public void settingBtn() {
		action.click(btn_setting());
	}
	
	//账号与安全页面
	public void safePage() {
		action.click(setting_safe());
	}
	
	//返回键（账号与安全页面）
	public void return2() {
		action.click(btn_return2());
	}
	
	//设置安全问题页面
	public void toSetSafeQuestionPage() {
		action.click(setting_safe());
		action.click(setSafeQuestion());
	}
	
	//返回键（设置安全问题页面）
	public void returnSetSafeQuestionPage() {
		action.click(setSafeQuestion_return());
	}
	
	//绑定邮箱页面
	public void toSetEmailPage() {
		action.click(setting_safe());
		action.click(setEmail());
	}
	
	//返回键（绑定邮箱页面）
	public void returnSetEmailPage() {
		action.click(setEmail_return());
	}
	
	//确认注销按钮开关
	public String destoryAccountSwitcher() {
		action.click(setting_safe());
		action.click(destoryAccount());
		action.click(switch_destoryAccount());
		String checked = switch_destoryAccount().getAttribute("checked");
		action.click(destoryAccount_return());
		action.click(btn_return2());
		return checked;
	}
	
	//注销账户
	public void accountDestory() {
		action.click(setting_safe());
		action.click(destoryAccount());
		action.click(btn_destoryAccount());
		action.click(destoryAccount_return());
		action.click(btn_return2());
	}
	
	//注销账户页面
	public void toAccountDestoryPage() {
		action.click(setting_safe());
		action.click(destoryAccount());
	}
	
	//返回键（注销账户页面）
	public void returnAccountDestoryPage() {
		action.click(destoryAccount_return());
	}
	
	//获取当前用户名
	public String getCurrentUserName() {
		action.click(btn_return1());
		String user = userName().getText();
		action.click(btn_setting());
		return user;
	}
	
	//帮助与反馈页面
	public void toHelpAndFeedbackPage() {
		action.click(helpAndFeedback());
	}
	
	//返回键（帮助与反馈页面）
	
	public void returnHelpAndFeedbackPage() {
		action.click(helpAndFeedback_return());
	}
	
	//关于页面
	
	public void toAboutPage() {
		action.click(about());
	}
	
	//返回键（关于页面）
	
	public void returnAboutPage() {
		action.click(about_return());
	}
	
	//退出登录
	public void toLogout() {
		action.click(btn_logout());
	}
	
}
