package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import datasProvider.ExcelDataProvider;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.LoginPage;
import pages.MainPage;

public class MainPageTest extends BaseDriver{
	MainPage mainPage;
	LoginPage loginPage;
	@DataProvider(name = "s3")
	public Object[][] getFromExcel() throws IOException {
		return ExcelDataProvider.getData("data/commentInfo.xlsx");
	}
	@BeforeClass
	public void login() {
		 loginPage=new LoginPage(driver);
		 mainPage=loginPage.login("xs", "xs");
	}
//	取消关注
	@Test(priority = 1)
	public void my_cancel() throws InterruptedException {
		mainPage.action_att().click();
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		mainPage.action_attb().click();
		Thread.sleep(2000);
	}
//	关注后再取消再关注
	@Test(priority = 2)
	public void my_add() throws InterruptedException {
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		mainPage.action_attb().click();
		Thread.sleep(1000);
		mainPage.action_attb().click();
		Thread.sleep(1000);
		mainPage.action_attb().click();
	}
//	评论
	@Test(dataProvider="s3",priority = 3)
	public void my_comment(String key) throws InterruptedException {
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		mainPage.action_articleId().click();
		Thread.sleep(2000);
		mainPage.send_comment(key);
		Thread.sleep(2000);
		mainPage.action_send().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
//	发送为空的内容
	@Test(priority=4)
	public void my_comment2() throws InterruptedException {
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		mainPage.action_articleId().click();
		Thread.sleep(2000);
		mainPage.action_articleComment().sendKeys("");
		Thread.sleep(2000);
		mainPage.action_send().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
//	发送为空格的内容
	@Test(priority=5)
	public void my_comment3() throws InterruptedException {
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		mainPage.action_articleId().click();
		Thread.sleep(2000);
		mainPage.action_articleComment().sendKeys("    ");
		Thread.sleep(2000);
		mainPage.action_send().click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
	}
}
