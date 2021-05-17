package pages;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

//		构造方法
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}

//		页面对象
	public AndroidElement action_gr() {
		return driver.findElementByAccessibilityId("个人");
	}
	public AndroidElement action_fx() {
		return driver.findElementByAccessibilityId("发现");
	}
	public AndroidElement action_att() {
		return driver.findElementByAccessibilityId("我的关注");
	}
	public AndroidElement action_attb() {
		return driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.Button");
	}
	public AndroidElement action_dz() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_heart_btn_like");
	}
//	评论
	public AndroidElement action_articleId() {
		return driver.findElement(By.id("com.example.shoujiedemo:id/follow_actricle_tv_title"));
	}
	public AndroidElement action_articleComment() {
		return driver.findElement(By.id("com.example.shoujiedemo:id/follow_article_ed_comment"));
	}
	public AndroidElement action_send() {
		return driver.findElement(By.id("com.example.shoujiedemo:id/follow_article_btn_send_comment"));
	}
//	发送评论
	public void send_comment(String key) {
		action.type(action_articleComment(), key);
	}

	public CollectPage changeActivity( ) {
		action.click(action_gr());
		return new CollectPage(driver);
	
	}
	public ActivePage changeActivity2( ) {
		action.click(action_fx());
		return new ActivePage(driver);
	
	}
	
}
