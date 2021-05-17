package testcase;

import org.testng.annotations.AfterMethod;
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
		notePage.login_sucess("a", "a");
		Thread.sleep(1000);
		notePage.user_page();
	}
	
	@AfterMethod
	public void outPage() throws InterruptedException {
		driver.quit();
	}

	@Test(priority = 1)
	//1.切换头像
	public void test_user_image() throws InterruptedException {
		notePage.select_user_image();
		
	}
	
	@Test(priority = 2)
	//2.切换壁纸
	public void test_wallpaper() throws InterruptedException{
		notePage.select_wallpaper();
	}
	@Test(priority = 3)
	//3.取消切换((软件停止运行))
	public void test_unphoto() throws InterruptedException{
		notePage.unphoto();
	}
	@Test(priority = 4)
	//4.添加文集1--仅选择封面
	public void test_add_pic() throws InterruptedException{
		notePage.add_works_pic();
		notePage.addwork();
	}
	
	@Test(priority = 5)
	//5.添加文集2,仅填写文字((软件停止运行))
	public void test_add_name() throws InterruptedException{
		notePage.add_works_name("aa");
		notePage.addwork();
		
	}
	@Test(priority = 6)
	//6.添加文集3,都填写（不可见）
	public void test_work0() throws InterruptedException{
		notePage.add_works_pic();
		notePage.add_works_name("aa");
		notePage.addwork0();
	}
	@Test(priority = 7)
	//7.添加文集4，都填写（可见）
	public void  test_work1() throws InterruptedException {
		notePage.add_works_pic();
		notePage.add_works_name("work1");
		notePage.addwork();
	}
	@Test(priority = 8)
	//8.添加文集5，重复填写名称（可见）
	public void  test_work2() throws InterruptedException {
		notePage.add_works_pic();
		notePage.add_works_name("work2");
		notePage.addwork();
	}
	@Test(priority = 9)
	//9.添加文集6，确认点击两次（可见）
	public void  test_work3() throws InterruptedException {
		notePage.add_works_pic();
		notePage.add_works_name("work3");
		notePage.addwork2();
	}
	@Test(priority = 10)
	//10.删除文集((软件停止运行))
	public void test_work4() throws InterruptedException{
		notePage.remove_works();
	}
	@Test(priority = 11)
	//11.更换封面((软件停止运行))
	public void test_work5() throws InterruptedException{
		notePage.change_Pic();
	}
	@Test(priority = 12)
	//12.点击文集((软件停止运行))
	public void test_work6() throws InterruptedException{
		notePage.s_work();
	}
	
	@Test(priority = 13)
	//13.我的评论
	public void test_comment() throws InterruptedException{
		notePage.look_comment();
	}
	@Test(priority = 14)
	//14.个人中心(软件停止运行)
	public void test_look_center() throws InterruptedException{
		notePage.look_center();
	}
	@Test(priority = 15)
	//15.帮助中心((软件停止运行))
	public void test_help() throws InterruptedException{
		notePage.look_help();
	}
	
	@Test(priority = 16)
	//16.我的关注1关注
	public void test_attention1() throws InterruptedException{
		notePage.Attention();
	}
	@Test(priority = 17)
	//17.我的关注2查看关注
	public void test_attention2() throws InterruptedException{
		notePage.look_attention();
	}
	@Test(priority = 19)
	//18.我的关注3取消关注
	public void test_atention3() throws InterruptedException{
		notePage.delete_attention();
	}
	@Test(priority = 19)
	//19.我的点赞1点赞
	public void test_agree1() throws InterruptedException{
		notePage.Agree();
	}
	@Test(priority = 20)
	//20.我的点赞2查看点赞
	public void test_agree2() throws InterruptedException{
		notePage.look_agree();
		
	}


}
