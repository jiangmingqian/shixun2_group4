package testcase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.ActivePage;
import pages.LoginPage;
import pages.MainPage;

public class ActivePageTest extends BaseDriver{
	ActivePage activePage;
	MainPage mainPage;
	@BeforeClass
	public void test_initPage() {
		LoginPage loginPage = new LoginPage(driver);
		mainPage = loginPage.login("xs", "xs");
		activePage = mainPage.changeActivity2();
	}
//	µãÔÞ
	@Test(priority=1)
	public void test_dz() throws InterruptedException {
		activePage.action_dz().click();
		Thread.sleep(2000);
	}
//	É¾³ýÆÀÂÛ
	@Test(priority=2)
	public void test_sc() throws InterruptedException {
		Thread.sleep(2000);
		activePage.delete_comment();
	}

}
