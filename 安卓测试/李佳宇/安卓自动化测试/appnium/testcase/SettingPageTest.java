package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.SettingPage;
import utils.ExcelDataProvider;

public class SettingPageTest extends BaseDriver {

	SettingPage settingPage;
	
	@BeforeClass
	public void initPage() throws InterruptedException {
		settingPage = new SettingPage(driver);
		settingPage.loginToSettingPage();
	}
	
	//Excel数据驱动
	@DataProvider(name = "testData1")
	public Object[][] testData1() throws IOException {
		return new ExcelDataProvider().getTestDataByExcel("data_excel/data.xlsx", "Sheet1");
	}
	
	//开启夜间模式
	@Test(priority=1)
	public void testNightModeOn() {
		settingPage.nightModeSwitcher();
		String checked = settingPage.getChecked();
		Assert.assertEquals(checked, "true");
	}
	
	//关闭夜间模式
	@Test(priority=2)
	public void testNightModeOff() {
		settingPage.nightModeSwitcher();
		String checked = settingPage.getChecked();
		Assert.assertEquals(checked, "false");
	}
	
	//修改密码（正常输入）
	@Test(priority=3)
	public void testChangePwd1() {
		settingPage.changePassword("1234567", "testnewkey", "testnewkey");
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：修改成功");
	}
	
	//修改密码（输入的新密码为空）
	@Test(priority=4)
	public void testChangePwd2() {
		settingPage.changePassword("1234567", "", "");
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：修改失败");
	}
	
	//修改密码（输入的新密码过长）
	@Test(priority=5)
	public void testChangePwd3() {
		settingPage.changePassword("1234567", "thenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolong", "thenewkeyistoolongthenewkeyistoolongthenewkeyistoolongthenewkeyistoolong");
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：修改失败");
	}
	
	//修改密码（输入错误的原始密码）
	@Test(priority=6)
	public void testChangePwd4() {
		settingPage.changePassword("wrongoldkey", "testnewkey", "testnewkey");
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：原密码输入有误");
	}
	
	//修改密码（两次输入的新密码不同）
	@Test(priority=7)
	public void testChangePwd5() {
		settingPage.changePassword("1234567", "testnewkey", "differentnewkey");
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：新密码不相同");
	}
	
	//修改密码（从Excel中读取新密码）
	@Test(dataProvider="testData1",priority=8)	
	public void testChangePwdFromExcel(String oldKey,String newKey,String repeatKey) {
		settingPage.changePassword(oldKey, newKey, repeatKey);
		String text = settingPage.getToastText();
		Assert.assertEquals(text, "偶然：新密码不相同");
	}
	
	//开启确认注销按钮
	@Test(priority=9)
	public void testDestoryAccountSwitchOn() {
		String checked = settingPage.destoryAccountSwitcher();
		Assert.assertEquals(checked, "true");
	}
	
	//关闭确认注销按钮
	@Test(priority=10)
	public void testDestoryAccountSwitchOff() {
		String checked = settingPage.destoryAccountSwitcher();
		Assert.assertEquals(checked, "false");
	}
	
	//注销账户
	@Test(priority=11)
	public void testAccountDestory() {
		settingPage.accountDestory();
		Assert.assertNotEquals(settingPage.getCurrentUserName(), "1234567");
	}
	
	//清除缓存（清除成功后缓存大小归零）
	@Test(priority=12)
	public void testClearCookie() {
		settingPage.clearCookies();
		Assert.assertEquals(settingPage.getCookieSize(),"0.0MB");
	}
	
	//注销账号页面的返回键
	@Test(priority=13)
	public void testReturnAccountDestory() {
		settingPage.toAccountDestoryPage();
		settingPage.returnAccountDestoryPage();
		Assert.assertNotNull(settingPage.changePwd());
	}
	
	//账号与安全页面的返回键
	@Test(priority=14)
	public void testReturnSafePage() {
		settingPage.return2();
		Assert.assertNotNull(settingPage.setting_safe());
	}
	
	//帮助与反馈页面的返回键
	@Test(priority=15)
	public void testReturnHelpAndFeedbackPage() {
		settingPage.toHelpAndFeedbackPage();
		settingPage.returnHelpAndFeedbackPage();
		Assert.assertNotNull(settingPage.setting_safe());
	}
	
	//关于页面的返回键
	@Test(priority=16)
	public void testReturnAboutPage() {
		settingPage.toAboutPage();
		settingPage.returnAboutPage();
		Assert.assertNotNull(settingPage.setting_safe());
	}
	
	//退出登录
	@Test(priority=17)
	public void testLogout() throws InterruptedException {
		settingPage.toLogout();
		Assert.assertNotEquals(settingPage.getCurrentUserName(), "1234567");
	}
	
	//设置页返回键
	@Test(priority=18)
	public void testReturnSetting() {
		settingPage.return1();
		settingPage.settingBtn();
		Assert.assertEquals(settingPage.getCurrentUserName(), "1234567");
	}
	
	//设置安全问题页面的返回键
	@Test(priority=19)
	public void testReturnSetSafeQuestion() {
		settingPage.settingBtn();
		settingPage.toSetSafeQuestionPage();
		settingPage.returnSetSafeQuestionPage();
		Assert.assertNotNull(settingPage.changePwd());
	}
			
	//绑定邮箱页面的返回键
	@Test(priority=20)
	public void testReturnSetEmail() {
		settingPage.toSetEmailPage();
		settingPage.returnSetEmailPage();
		Assert.assertNotNull(settingPage.changePwd());
	}
	
}
