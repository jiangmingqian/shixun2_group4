package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class MainPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
//	构造方法
	public MainPage(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		this.action=new BaseAction(driver);
		}
	
//	页面对象

	public AndroidElement username() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userName");
	}
	
	public AndroidElement password() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userPassword");
	}
	
	public AndroidElement loginbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/login_login");
	}
	
	public AndroidElement findbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/item_fround");
	}
	
	public AndroidElement articlebtn() {
		return driver.findElementByXPath("//*[@content-desc='文章']");
	}
	
	public AndroidElement poetrybtn() {
		return driver.findElementByXPath("//*[@content-desc='诗']");
	}
	
	public AndroidElement likebtn() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_like");
	}
	
	public AndroidElement likepeo() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_btn_like");
	}
	
	public WebElement likenums() {
		WebElement num = driver.findElements(By.id("com.example.shoujiedemo:id/follow_article_tv_like_num")).get(0);
		return num;
	}
	
	public WebElement likenum() {
		WebElement num = driver.findElements(By.id("com.example.shoujiedemo:id/follow_poem_tv_like_num")).get(0);
		return num;
	}
	
	public AndroidElement fanbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_follow");
	}
	
	public WebElement fannums() {
		WebElement num = driver.findElements(By.id("com.example.shoujiedemo:id/follow_article_tv_fan")).get(0);
		return num;
	}
	
	public AndroidElement typeart() {
		return  driver.findElementById("com.example.shoujiedemo:id/ed_article_content");
	}
	
	public AndroidElement typetitle() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_ed_article_title");
	}
	
	public AndroidElement typewriter() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_ed_article_writer");
	}
	
	public AndroidElement typetag() {
		return  driver.findElementById("com.example.shoujiedemo:id/custom_tag");
	}
	public AndroidElement send() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_btn_article_commit");
	}
	
	public AndroidElement typepoe() {
		return  driver.findElementById("com.example.shoujiedemo:id/ed_poem_content");
	}
	
	public AndroidElement poetypetitle() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_ed_poem_title");
	}
	
	public AndroidElement poetypewriter() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_ed_poem_writer");
	}
	
	public AndroidElement poetypetag() {
		return  driver.findElementById("com.example.shoujiedemo:id/custom_tag");
	}
	
	public AndroidElement poesend() {
		return  driver.findElementById("com.example.shoujiedemo:id/upload_btn_poem_commit");
	}
	
	public AndroidElement photo() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_article_cover");
	}
	
	public AndroidElement savephoto() {
		return driver.findElementById("com.android.gallery3d:id/filtershow_done");
	}
	
	public AndroidElement check() {
		return driver.findElementById("com.example.shoujiedemo:id/isOriginal");
	}
	
	public AndroidElement search() {
		return driver.findElementById("com.example.shoujiedemo:id/ed_search");
	}
	
	public AndroidElement searchbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/btn_search");
	}
	
	public AndroidElement collectbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_btn_collection");
	}
	
	public AndroidElement collectbtn2() {
		return driver.findElementById("com.example.shoujiedemo:id/item_btn_collect");
	}
	
	public AndroidElement fan1() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_btn_follow");
	}
	
	public AndroidElement comment() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_ln_content");
	}
	
	public AndroidElement commenttext() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_ed_comment");
	}
	
	public AndroidElement sentcomment() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_poem_btn_send_comment");
	}
	
	public AndroidElement delmenucomment() {
		return driver.findElementById("com.example.shoujiedemo:id/btn_menu");
	}
	
	public AndroidElement delcomment() {
		return driver.findElementById("com.example.shoujiedemo:id/comment_tv_delete");
	}
	
//	页面操作方法
	
	public void login(String username,String password) throws InterruptedException{
		action.type(username(),username);
		Thread.sleep(1000);
		action.type(password(),password);
		Thread.sleep(2000);
		action.click(loginbtn());
	}
	
	public void findarticle() throws InterruptedException {
		action.click(findbtn());
		Thread.sleep(2000);
		action.click(articlebtn());
	}
	
	public void findpoetry() throws InterruptedException {
		action.click(findbtn());
		Thread.sleep(2000);
		action.click(poetrybtn());
	}
	
	public void artlongclick(int x,int y) {
		action.longPresspoint(x,y);
	}
	
	public void artclick(int x,int y) {
		action.pointOption(x,y);
	}
	
	public void longmove(int x1,int y1,int x2,int y2) {
		action.longmove(x1,y1 ,x2 , y2);
	}
	
	public void typeart2(String context) {
		action.type(typeart(), context);
	}
	
	public void typetitle2(String context) {
		action.type(typetitle(), context);
	}
	
	public void typewriter2(String context) {
		action.type(typewriter(), context);
	}
	
	public void typetag2(String context) {
		action.type(typetag(), context);
	}
	
	public void send2() {
		action.click(send());
	}
	
	public void typepoe2(String context) {
		action.type(typepoe(), context);
	}
	
	public void poetypetitle2(String context) {
		action.type(poetypetitle(), context);
	}
	
	public void poetypewriter2(String context) {
		action.type(poetypewriter(), context);
	}
	
	public void poetypetag2(String context) {
		action.type(poetypetag(), context);
	}
	
	public void poesend2() {
		action.click(poesend());
	}
	
	public void sendphoto() throws InterruptedException {
		action.click(photo());
		action.pointOption(450,850);
		action.pointOption(450,850);
	}
	 public void check2() {
		action.click(check());
	}
	 
	 public void search2(String context) {
		action.type(search(), context);
	}
	 
	 public void collect() {
		action.click(collectbtn());
		action.click(collectbtn2());
	}
	 
	 public void fan() {
		action.click(fan1());
	} 
	 
	 public void poecomment(String context) {
		action.type(commenttext(), context);
	}
	 
	 public void sendpoecomment() {
		action.click(sentcomment());
	} 
	 
	 public void delpoecomment() {
		action.click(delmenucomment());
		action.click(delcomment());
	} 
}