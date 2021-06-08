package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import pages.MainPage;

public class Test1 extends BaseDriver{
	MainPage mainPage;
	
	public void artticle() throws InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.login("zhang","123456");
		Thread.sleep(2000);
		mainPage.findarticle();
	}
	
	public void poetry() throws InterruptedException {
		mainPage = new MainPage(driver);
		mainPage.login("zhang","123456");
		Thread.sleep(2000);
		mainPage.findpoetry();
	}
	
	@DataProvider(name = "like")
	public Object[][] createLike(){
		return new Object[][] {
			{"zhang","123456"},
			{"zj","123456"},
			{"123456","123456"}
			};
	}
	//点赞
	@Test(priority=1)
	public void arttest1() throws InterruptedException, MalformedURLException{
		String num1,num2;
		int num3,num4;
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(2000);
		artticle();
		Thread.sleep(2000);
		num1 = driver.findElementById("com.example.shoujiedemo:id/follow_article_tv_like_num").getText();
		mainPage.likebtn().click();
		Thread.sleep(2000);
		num2 = driver.findElementById("com.example.shoujiedemo:id/follow_article_tv_like_num").getText();
		num3 = Integer.valueOf(num1).intValue();
		num4 = Integer.valueOf(num2).intValue();
		Thread.sleep(2000);
		assertEquals(num3+1,num4);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//多用户点赞
	@Test(dataProvider = "like",priority=2)
	public void arttest2(String uString,String pString) throws InterruptedException, MalformedURLException {
		mainPage = new MainPage(driver);
		startUp();
		mainPage.login(uString,pString);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//退出发表编辑的功能
	@Test(priority=3)
	public void arttest3() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(2000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typeart2("退出编辑");
//		mainPage.send2();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		
		Thread.sleep(2000);
		startUp();
		Thread.sleep(2000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		String string =driver.findElementById("com.example.shoujiedemo:id/ed_article_content").getText();
		Thread.sleep(3000);
		assertEquals("诗歌内容", string);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//发送纯文字文章的功能
	@Test(priority=4)
	public void test4() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typeart2("这是一篇小文章");
		String string = driver.findElementById("com.example.shoujiedemo:id/ed_article_content").getText();
		//mainPage.send2();		
		assertEquals(string,"这是一篇小文章");
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//发送带标签的文章
	@Test(priority=5)
	public void test5() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typetitle2("文章标题");
		mainPage.typeart2("这是一篇带有标题小文章");
		String string = driver.findElementById("com.example.shoujiedemo:id/upload_ed_article_title").getText();
		assertEquals(string,"文章标题");
//		mainPage.send2();		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
		
	//发送带作者的文章
	@Test(priority=6)
	public void test6() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typeart2("这是一篇带作者小文章");
		mainPage.typewriter2("文章作者");
		String string = driver.findElementById("com.example.shoujiedemo:id/upload_ed_article_writer").getText();
		assertEquals(string,"文章作者");
		//		mainPage.send2();		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
		
	//发送带分类的文章
	@Test(priority=7)
	public void test7() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typeart2("这是一篇带分类小文章");
		mainPage.typetag2("文章分类");
		String string = driver.findElementById("com.example.shoujiedemo:id/custom_tag").getText();
		assertEquals(string,"文章分类");
//		mainPage.send2();		
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
		
	//发送带原创的文章
	@Test(priority=8)
	public void test8() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.longmove(440,1480,310,1490);
		Thread.sleep(1000);
		mainPage.typeart2("这是一篇带分类小文章");
		mainPage.check2();
		String string = driver.findElementById("com.example.shoujiedemo:id/isOriginal").getAttribute("checked");
		assertTrue(true, string);
		//		mainPage.send2();
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//文章关注用户
	@Test(priority=9)
	public void arttest9() throws InterruptedException, MalformedURLException{
		String num1,num2;
		int num3,num4;
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(2000);
		artticle();
		num1 = driver.findElementById("com.example.shoujiedemo:id/follow_article_tv_fan").getText();
		Thread.sleep(2000);
		mainPage.fanbtn().click();
		Thread.sleep(2000);
		num2 = driver.findElementById("com.example.shoujiedemo:id/follow_article_tv_fan").getText();
		num3 = Integer.valueOf(num1).intValue();
		num4 = Integer.valueOf(num2).intValue();
		Thread.sleep(2000);
		assertEquals(num3+1,num4);
		mainPage.fanbtn().click();
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//搜索文章
	@Test(priority=10)
	public void arttest10() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		artticle();
		mainPage.search2("午魂");
		Thread.sleep(2000);
		mainPage.searchbtn().click();
		Thread.sleep(3000);
		String title = driver.findElementById("com.example.shoujiedemo:id/follow_actricle_tv_title").getText();
		Thread.sleep(3000);
		assertEquals("午魂", title);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//搜索文章，清除文章搜索
	@Test(priority=11)
	public void poetest11() throws InterruptedException, MalformedURLException{
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		poetry();
		mainPage.search2("橄榄树");
		Thread.sleep(2000);
		mainPage.searchbtn().click();
		Thread.sleep(2000);
		mainPage.search2("");
		Thread.sleep(2000);
		mainPage.searchbtn().click();
		mainPage.longmove(630,248,630,750);
		Thread.sleep(5000);
		String writer = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_writer_name").getText();
		Thread.sleep(3000);
		assertEquals("王小波", writer);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//诗收藏
	@Test(priority=12)
	public void poetest12() throws InterruptedException, MalformedURLException{
		String num1,num2;
		int num3,num4;
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		poetry();
		Thread.sleep(2000);
		num1 = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_collection_num").getText();
		mainPage.collect();
		Thread.sleep(2000);
		mainPage.longmove(630,248,630,750);
		Thread.sleep(6000);
		num2=driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_collection_num").getText();
		num3 = Integer.valueOf(num1).intValue();
		num4 = Integer.valueOf(num2).intValue();
		Thread.sleep(2000);
		assertEquals(num3+1,num4);
		Thread.sleep(3000);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//诗关注
	@Test(priority=13)
	public void poetest13() throws InterruptedException, MalformedURLException{
		String num1,num2;
		int num3,num4;
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(1000);
		poetry();
		Thread.sleep(2000);
		num1 = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_fan").getText();
		mainPage.fan();
		Thread.sleep(4000);
		num2 = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_fan").getText();
		Thread.sleep(2000);
		num3 = Integer.valueOf(num1).intValue();
		num4 = Integer.valueOf(num2).intValue();
		Thread.sleep(2000);
		assertEquals(num3+1,num4);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//诗点赞
	@Test(priority=14)
	public void poetest14() throws InterruptedException, MalformedURLException{
		String num1,num2;
		int num3,num4;
		mainPage = new MainPage(driver);
		startUp();
		Thread.sleep(2000);
		poetry();
		num1 = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_like_num").getText();
		Thread.sleep(2000);
		mainPage.likepeo().click();
		Thread.sleep(2000);
		num2 = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_like_num").getText();
		num3 = Integer.valueOf(num1).intValue();
		num4 = Integer.valueOf(num2).intValue();
		Thread.sleep(2000);
		assertEquals(num3+1,num4);
		driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
	}
	
	//发送带标题的诗
		@Test(priority=15)
		public void test15() throws InterruptedException, MalformedURLException{
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			mainPage.longmove(440,1480,363,1392);
			Thread.sleep(1000);
			mainPage.poetypetitle2("诗标题");
			mainPage.typepoe2("这是一篇带有标题小诗");
			String string = driver.findElementById("com.example.shoujiedemo:id/upload_ed_poem_title").getText();
			assertEquals(string,"诗标题");
			//			mainPage.poesend2();	
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
			
		//发送带作者的诗
		@Test(priority=16)
		public void test16() throws InterruptedException, MalformedURLException{
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			mainPage.longmove(440,1480,363,1392);
			Thread.sleep(1000);
			mainPage.typepoe2("这是一篇带有标题小诗");
			mainPage.poetypewriter2("小诗作者");
			String string = driver.findElementById("com.example.shoujiedemo:id/upload_ed_poem_writer").getText();
			assertEquals(string,"小诗作者");
			//			mainPage.poesend2();	
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
			
		//发送带分类的诗
		@Test(priority=17)
		public void test17() throws InterruptedException, MalformedURLException{
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			mainPage.longmove(440,1480,363,1392);
			Thread.sleep(1000);
			mainPage.typepoe2("这是一篇带有标题小诗");
			mainPage.poetypetag2("小诗分类");
			System.out.println(driver.findElementById("com.example.shoujiedemo:id/custom_tag").getText());
			String string = driver.findElementById("com.example.shoujiedemo:id/custom_tag").getText();
			assertEquals(string,"小诗分类");
			//			mainPage.poesend2();		
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
			
		//发送带原创的诗
		@Test(priority=18)
		public void test18() throws InterruptedException, MalformedURLException{
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			mainPage.longmove(440,1480,363,1392);
			Thread.sleep(1000);
			mainPage.typepoe2("这是一篇带有标题小诗");
			mainPage.check2();
			String string = driver.findElementById("com.example.shoujiedemo:id/isOriginal").getAttribute("checked");
			assertTrue(true, string);
			//			mainPage.poesend2();	
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
		
		//诗评论
		@Test(priority=19)
		public void test19() throws InterruptedException, MalformedURLException{
			String num1,num2;
			int num3,num4;
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			Thread.sleep(1000);
			mainPage.comment().click();
			num1=driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_comment_num2").getText();
			mainPage.poecomment("一条诗评论");
			mainPage.sendpoecomment();
			Thread.sleep(1000);
			System.out.println(driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_comment_num2").getText());
			num2=driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_comment_num2").getText();
			num3 = Integer.valueOf(num1).intValue();
			num4 = Integer.valueOf(num2).intValue();
			Thread.sleep(2000);
			assertEquals(num3+1,num4);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
		
		//界面刷新
		@Test(priority=20)
		public void poetest20() throws InterruptedException, MalformedURLException{
			mainPage = new MainPage(driver);
			startUp();
			Thread.sleep(1000);
			poetry();
			mainPage.longmove(630,248,630,800);
			Thread.sleep(6000);
			String writer = driver.findElementById("com.example.shoujiedemo:id/follow_poem_tv_writer_name").getText();
			Thread.sleep(3000);
			assertEquals("王小波", writer);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));//home键模拟
		}
}
