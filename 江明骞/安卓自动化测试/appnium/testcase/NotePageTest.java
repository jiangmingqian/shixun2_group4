package testcase;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseDriver;
import pages.NotePage;

public class NotePageTest extends BaseDriver{
	NotePage notePage;
	
	@BeforeMethod
	public void initPage() throws InterruptedException {
		notePage=new NotePage(driver);
		//每次执行用例先登录
		notePage.login_sucess("jmq", "123456");
	}
	
	@AfterMethod
	public void outPage() throws InterruptedException {
		driver.quit();
	}

	@Test(priority = 1)
	//1.发布一条有内容，图片，选择分类填写“五一”的感悟
	public void test1() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_ganwu("五一快乐", "五一");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 2)
	//2.发布一条无内容的感悟
	public void test2() throws InterruptedException {
		Thread.sleep(2000);
		String message =notePage.upload_ganwu_fail("", "");
		assertEquals(message, "必须填写内容");
	}
	
	@Test(priority = 3)
	//3.发布一条选择分类为自定义的感悟
	public void test3() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_ganwu("五一快乐", "");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 4)
	//4.用空格替代感悟和选择分类内容发布
	public void test4() throws InterruptedException {
		Thread.sleep(2000);
		String message =notePage.upload_ganwu_fail("   ", "    ");
		assertEquals(message, "必须填写内容");
	}
	
	@Test(priority = 5)
	//5.发布一条有音乐链接和想法的音乐
	public void test5() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music("http://music.163.com/song?id=767452&userid=543125681", "纯音乐");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 6)
	//6.发布一条没有音乐链接和想法的音乐
	public void test6() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music("", "");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 7)
	//7.发布一条有两条音乐链接的音乐
	public void test7() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music("http://music.163.com/song?id=767452&userid=543125681"+"\n"
				+ "http://music.163.com/song?id=1397725153&userid=543125681", "");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 8)
	//8.用空格替代想法发布
	public void test8() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music("http://music.163.com/song?id=767452&userid=543125681", "      ");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 9)
	//9.点击粘贴音乐连接后取消
	public void test9() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music_cancel("http://music.163.com/song?id=767452&userid=543125681");
		assertEquals(driver.currentActivity(), ".upload.activity.MusicUploadActivity");
	}
	
	@Test(priority = 10)
	//10.点击粘贴音乐连接后输入非链接字符
	public void test10() throws InterruptedException {
		Thread.sleep(2000);
		notePage.upload_music("aaaaaaaa", "");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 11)
	//11.在发现-感悟中根据用户名搜索
	public void test11() throws InterruptedException {
		Thread.sleep(2000);
		notePage.ganwu_search("ljjy");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 12)
	//12.在发现-感悟中根据标签搜索
	public void test12() throws InterruptedException {
		Thread.sleep(2000);
		notePage.ganwu_search("双十二");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 13)
	//13.在发现-音乐中根据用户名搜索
	public void test13() throws InterruptedException {
		Thread.sleep(2000);
		notePage.music_search("xs");
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 14)
	//14.在感悟中点击删除后取消
	public void test14() throws InterruptedException {
		Thread.sleep(2000);
		notePage.ganwu_delete_cancel();
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	
	@Test(priority = 15)
	//15.删除已经发布的感悟
	public void test15() throws InterruptedException {
		Thread.sleep(2000);
		String message=notePage.ganwu_delete();
		assertEquals(message,"删除成功");
	}
	
	@Test(priority = 16)
	//16.在感悟中点击用户发布内容进入用户发布的感悟
	public void test16() throws InterruptedException {
		Thread.sleep(2000);
		notePage.ganwu_enter();
		assertEquals(driver.currentActivity(), ".activity.HeartActivity");
	}
	
	@Test(priority = 17)
	//17.在感悟中点击用户头像查看用户音乐
	public void test17() throws InterruptedException {
		Thread.sleep(2000);
		notePage.ganwu_photo_enter();
		assertEquals(driver.currentActivity(), ".myCenter.mySpace.view.activity.MySpaceActivity");
	}
	
	@Test(priority = 18)
	//18.在音乐中点击播放音乐后暂停
	public void test18() throws InterruptedException {
		Thread.sleep(2000);
		notePage.music_begin();
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}
	
	@Test(priority = 19)
	//19.在音乐中进入用户发布的音乐界面
	public void test19() throws InterruptedException {
		Thread.sleep(2000);
		notePage.music_enter();
		assertEquals(driver.currentActivity(), ".activity.HeartActivity");
	}
	
	@Test(priority = 20)
	//20.在音乐中同时播放两首音乐
	public void test20() throws InterruptedException {
		Thread.sleep(2000);
		notePage.music_begin2();
		assertEquals(driver.currentActivity(), ".home.recommen.activity.MainActivity");
	}




}
