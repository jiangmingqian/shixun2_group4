package testcase;


import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import datasProvider.ExcelDataProvider;
import pages.LoginPage;

public class LoginPageTest extends BaseDriver {
	 @DataProvider(name="s1")
	 public Object[][] getFromExcel() throws IOException{
		 return ExcelDataProvider.getData("data/user.xlsx");
	 }
	LoginPage loginPage;
	@BeforeClass
	public void initPage() {
		loginPage=new LoginPage(driver);
	}
	@Test(dataProvider="s1")
	public void test_login(String user,String pwd) {
		loginPage.login(user,pwd);
	}

}
