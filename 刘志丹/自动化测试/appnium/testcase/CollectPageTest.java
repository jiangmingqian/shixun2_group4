package testcase;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import datasProvider.ExcelDataProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.reactivex.functions.Action;
import pages.CollectPage;
import pages.LoginPage;
import pages.MainPage;
import utils.BaseAction;

public class CollectPageTest extends BaseDriver {
	CollectPage coPage;
	MainPage mainPage;

	@DataProvider(name = "s2")
	public Object[][] getFromExcel() throws IOException {
		return ExcelDataProvider.getData("data/personInfo.xlsx");
	}

	@BeforeClass
	public void test_initPage() {
		LoginPage loginPage = new LoginPage(driver);
		mainPage = loginPage.login("xs", "xs");
		coPage = mainPage.changeActivity();
	}

// 修改个人信息
	@Test(dataProvider = "s2", priority = 1)
	public void test_action_update(String key) throws InterruptedException {
		System.out.println(driver.currentActivity());
		System.out.println("运行了修改个人信息的测试用例");
		Thread.sleep(3000);
	    coPage.action_personInfo().click();
	    Thread.sleep(2000);
	    coPage.action_update().click();
	    Thread.sleep(2000);
	    coPage.action_sex().click();
	    coPage.insert(key);
	    Thread.sleep(1000);
	    coPage.action_confirm().click();
	    Thread.sleep(1000);
	    coPage.action_return().click();
	}

//	关注
	@Test(priority = 2)
	public void test_action_gz() throws InterruptedException {
		System.out.println("运行关注的测试用例");
		System.out.println(driver.currentActivity());
		Thread.sleep(3000);
		coPage.action_space().click();
		Thread.sleep(2000);
		coPage.action_wj().click();
		Thread.sleep(2000);
		coPage.action_gz().click();
	}

//	点赞
	@Test(priority = 3)
	public void test_action_zdz() throws InterruptedException {
		System.out.println("运行点赞的测试用例");
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		coPage.action_dz().click();
	}

	@Test(priority = 4)
	public void test_action_zdz2() throws InterruptedException {
		System.out.println("运行点赞连续取消点赞的测试用例");
		System.out.println(driver.currentActivity());
		Thread.sleep(2000);
		coPage.action_dz().click();
		Thread.sleep(2000);
		coPage.action_dz().click();
	}

//	收藏
	@Test(priority = 5)
	public void test_action_zsc() throws InterruptedException {
		System.out.println(driver.currentActivity());
		System.out.println("运行了收藏的测试用例");
		Thread.sleep(3000);
		coPage.action_col().click();
		Thread.sleep(2000);
		coPage.action_list().click();
		Thread.sleep(1000);
		coPage.action_bcol().click();
	}

}
