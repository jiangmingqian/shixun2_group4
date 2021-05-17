package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.NotePage;
import pages.OuranPage;

public class OuranTest extends BaseDriver {
	OuranPage ouranPage;
	@BeforeClass
	public void initPage() {
		ouranPage=new OuranPage(driver);
	}
	@Test(priority = 1)
	public void test_register_fail() {
		
		ouranPage.register("111", "112", "111");
		driver.navigate().back();
		
	}
	@Test(priority = 1)
	public void test_register_success() {
		
		ouranPage.register("123", "123", "123");
		driver.navigate().back();
	}
	@Test(priority =2 )
	public void test_login_fail() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.login("123","0000");
		
		
	}
////	3
	@Test(priority = 2)
	public void test_login_success() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.login("123","123");
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 3)
	public void test_setdate() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.edit_date();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 4)
	public void test_asetdianzan() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.dianzan();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 4)
	public void test_bsetquguanzhu() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.quguanzhu();	
		//assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	
	
	@Test(priority = 4)
	public void test_csetshouchang() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.shouchang();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 4)
	public void test_dsetpinglun() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.pinglun();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 5)
	public void test_aneirong() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.neirong();
		
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 5)
	public void test_bsethuifu() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.huifu();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.navigate().back();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 6)
	public void test_asetguanzhu() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.quguanzhu();	
		//assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 6)
	public void test_bsearch() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.sousuo();
		//assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 7)
	public void test_aviewdianzan() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.view_mydianzan();
		Thread.sleep(3000);
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 7)
	public void test_bviewguanzhu() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.view_mygunazhu();
		Thread.sleep(3000);
		
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 7)
	public void test_cviewpinglun() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.view_mypinglun();
		Thread.sleep(3000);
		
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 7)
	public void test_dviewhelp() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.viewhelpcenter();
		Thread.sleep(3000);
		driver.navigate().back();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 8)
	public void test_setnight() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.setnight();
		driver.navigate().back();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 8)
	public void test_setpwd() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.setpwd("123","123","123");
		driver.navigate().back();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}
	@Test(priority = 8)
	public void test_clear() throws InterruptedException {
		Thread.sleep(3000);
		ouranPage.clear();
		driver.navigate().back();
		
//		assertEquals(driver.currentActivity(), ".Log.activity.LoginActivity");
	}

}

