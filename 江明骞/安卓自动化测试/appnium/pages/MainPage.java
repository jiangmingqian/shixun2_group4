package pages;

import java.util.List;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
	

	
	
	

}