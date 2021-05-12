package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class LoginPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	//通过构造方法对于driver初始化
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
	}
	
	public AndroidElement edit_username() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userName");
	}
	
	public AndroidElement edit_password() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userPassword");
	}
	
	public AndroidElement btn_login() {
		return driver.findElementById("com.example.shoujiedemo:id/login_login");
	}
	
	public MainPage login(String username,String password) {
		action.type(edit_username(), username);
		action.type(edit_password(), password);
		action.click(btn_login());
		return new MainPage(driver);
	
	}
	
	
	

}
