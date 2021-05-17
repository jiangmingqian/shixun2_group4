package pages;

import java.util.List;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class OuranPage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;
	public OuranPage(AndroidDriver<AndroidElement> driver) {
		
		this.driver=driver;
		this.action=new BaseAction(driver);
		
	}
	public AndroidElement login_username() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userName");
	}
	
	public AndroidElement login_userpwd(){
		return driver.findElementById("com.example.shoujiedemo:id/login_userPassword");
	}
	
	public AndroidElement ouran_login() {
		return driver.findElementById("com.example.shoujiedemo:id/login_login");
	}
//	public AndroidElement menu_click() {
//		AndroidElement listView=driver.findElementById("android:id/list");
//		List<MobileElement> list_view=listView.findElementsByClassName("android.widget.TextView");
//		int count=list_view.size();
//		if(count>0) {
//			return (AndroidElement) list_view.get(0);
//		}
//		return null;
////		return driver.findElementById("android:id/text1");
//	}
	public AndroidElement ouran_register() {
		return driver.findElementById("com.example.shoujiedemo:id/login_register");
	}

	public AndroidElement register_name(){
		return driver.findElementById("com.example.shoujiedemo:id/register_name");
	}
	public AndroidElement register_pwd(){
		return driver.findElementById("com.example.shoujiedemo:id/register_password");
	}
	public AndroidElement register_repeatPwd(){
		return driver.findElementById("com.example.shoujiedemo:id/register_repeatPassword");
	}
	public AndroidElement register_register(){
		return driver.findElementById("com.example.shoujiedemo:id/register_register");
	}
	
	public AndroidElement btn_date(){
		return driver.findElementById("com.example.shoujiedemo:id/btn_date");
	}
	public AndroidElement item_date_day() {
		return driver.findElementByXPath("//*[@text='5']");
	}
	

    public AndroidElement click_guanzhu() {
		return driver.findElementByXPath("//*[@text='我的关注']");
	}
//	public AndroidElement click_yiguanzhu() {
//		return driver.findElementByClassName("android.widget.ImageButton");
//	}
	public AndroidElement click_quguanzhu(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_follow");
	}
	public AndroidElement click_faxian(){
		return driver.findElementById("com.example.shoujiedemo:id/item_fround");
	}
	 public AndroidElement click_wenzhang() {
			return driver.findElementByXPath("//*[@text='文章']");
		}
	public AndroidElement click_yiguanzhu(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_follow");
	}
	public AndroidElement btn_like(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_like");
	}
	public AndroidElement btn_collection(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_collection");
	}
//	
	public AndroidElement btn_collect(){
		return driver.findElementById("com.example.shoujiedemo:id/item_btn_collect");
	}
	public AndroidElement btn_comment(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_comment");
	}
	public AndroidElement view_article(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_iv_cover");
	}
////	
	public AndroidElement btn_huifu(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_ed_comment");
	}
	public AndroidElement btn_sendcomment(){
		return driver.findElementById("com.example.shoujiedemo:id/follow_article_btn_send_comment");
	}
	public AndroidElement geren(){
		return driver.findElementById("com.example.shoujiedemo:id/item_owner");
	}
	public AndroidElement view_mydianzan(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_myAgreement");
	}
	public AndroidElement view_mygunazhu(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_myFollow");
	}
	public AndroidElement view_mypinglun(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_Storing");
	}
	public AndroidElement print_search(){
		return driver.findElementById("com.example.shoujiedemo:id/ed_search");
	}
	public AndroidElement click_search(){
		return driver.findElementById("com.example.shoujiedemo:id/btn_search");
	}
	public AndroidElement click_zhuye(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_helpCenter");
	}
	public AndroidElement click_helpcenter(){
		return driver.findElementById("com.example.shoujiedemo:id/item_home");
	}
	public AndroidElement click_setting(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_intent");
	}
	public AndroidElement click_night(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_nightModeSwitch");
	}
	public AndroidElement click_anquan(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe");
	}
	public AndroidElement click_editpwd(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_safe_changePassword");
	}
	public AndroidElement click_oldpwd(){
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_oldKey");
	}
	public AndroidElement click_newpwd(){
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_newKey");
	}
	public AndroidElement click_repitnewpwd(){
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_repeatKey");
	}
	public AndroidElement click_enter(){
		return driver.findElementById("com.example.shoujiedemo:id/changePassword_enter");
	}
	public AndroidElement click_back(){
		return driver.findElementById("com.example.shoujiedemo:id/myAgreement_return");
	}
	public AndroidElement click_back1(){
		return driver.findElementById("com.example.shoujiedemo:id/myFollow_return");
	}
	public AndroidElement click_back2(){
		return driver.findElementById("com.example.shoujiedemo:id/myComment_return");
	}
	
	public AndroidElement click_clear(){
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_setting_clearCookie");
	}
	
	public OuranPage login(String username,String password) throws InterruptedException {
		
		action.type(login_username(), username);
		
		action.type(login_userpwd(), password);
		Thread.sleep(3000);
		action.click(ouran_login());
		return new OuranPage(driver);
	}
	public OuranPage register(String username,String password,String repeatPwd) {
		action.click(ouran_register());
		action.type(register_name(), username);
		action.type(register_pwd(), password);
		action.type(register_repeatPwd(), repeatPwd);
		action.click(register_register());
		return new OuranPage(driver);
	}
	public OuranPage edit_date() {
		action.click(btn_date());
		action.click(item_date_day());
		return new OuranPage(driver);
	}
	public OuranPage quguanzhu() throws InterruptedException {
		Thread.sleep(3000);
		action.click(click_guanzhu());
		action.click(click_quguanzhu());
		
		return new OuranPage(driver);
	}
	public OuranPage faxian() {
		action.click(click_faxian());
		
		return new OuranPage(driver);
	}
	public OuranPage wenzhang() {
		action.click(click_faxian());
		
		return new OuranPage(driver);
	}
	public OuranPage guanzhu() throws InterruptedException {
		action.click(click_faxian());
		Thread.sleep(3000);
		action.click(click_wenzhang());
		Thread.sleep(3000);
		action.click(click_yiguanzhu());
		Thread.sleep(3000);
		action.click(click_zhuye());
		return new OuranPage(driver);
	}
	public OuranPage sousuo() throws InterruptedException {
		action.click(print_search());
		Thread.sleep(3000);
		action.click(click_search());
		Thread.sleep(3000);
		action.click(click_zhuye());
		return new OuranPage(driver);
	}
	public OuranPage dianzan() throws InterruptedException {
		action.click(click_guanzhu());
		Thread.sleep(3000);
		action.click(btn_like());
		return new OuranPage(driver);
	}
	public OuranPage shouchang() throws InterruptedException {
		action.click(click_guanzhu());
		Thread.sleep(3000);
		action.click(btn_collection());
		Thread.sleep(3000);
		action.click(btn_collect());
		Thread.sleep(3000);
		return new OuranPage(driver);
	}
	public OuranPage pinglun() throws InterruptedException {
		action.click(click_guanzhu());
		Thread.sleep(3000);
		action.click(btn_collection());
		Thread.sleep(3000);
		action.click(btn_collect());
		
		return new OuranPage(driver);
	}
	public OuranPage neirong() throws InterruptedException {
		action.click(click_guanzhu());
		Thread.sleep(3000);
		action.click(view_article());
		
		return new OuranPage(driver);
	}
	public OuranPage huifu() throws InterruptedException {
		
//		action.click(view_article());
		action.click(btn_huifu());
		action.type(btn_huifu(), "123");
		Thread.sleep(3000);
		action.click(btn_sendcomment());
		return new OuranPage(driver);
	}
	public OuranPage viewdianzan() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(view_mydianzan());
		Thread.sleep(3000);
		action.click(click_back());
		return new OuranPage(driver);
	}
	public OuranPage viewguanzhu() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(view_mydianzan());
		Thread.sleep(3000);
		action.click(click_back1());
		return new OuranPage(driver);
	}
	public OuranPage viewpinglun() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(view_mypinglun());
		action.click(click_back2());
		return new OuranPage(driver);
	}
	public OuranPage viewhelpcenter() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(click_helpcenter());
		
		return new OuranPage(driver);
	}
	public OuranPage setnight() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(click_setting());
		Thread.sleep(3000);
		action.click(click_night());
		return new OuranPage(driver);
	}
	public OuranPage setpwd(String username,String password,String repeatPwd) throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(click_anquan());
		Thread.sleep(3000);
		action.click(click_setting());
		action.click(click_editpwd());
		action.type(click_oldpwd(), username);
		Thread.sleep(3000);
		action.type(click_newpwd(), password);
		action.type(click_repitnewpwd(), repeatPwd);
//		action.click(click_back());
//		action.click(click_back1());
		return new OuranPage(driver);
	}
	public OuranPage clear() throws InterruptedException {
		
		action.click(geren());
		Thread.sleep(3000);
		action.click(click_setting());
		Thread.sleep(3000);
		action.click(click_clear());
		return new OuranPage(driver);
	}
	
	

}