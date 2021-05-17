package pages;

import java.awt.List;
import java.security.PublicKey;
import java.sql.Driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import utils.BaseAction;

public class NotePage {
	AndroidDriver<AndroidElement> driver;
	BaseAction action;

	// 通过构造方法对于driver初始化
	public NotePage(AndroidDriver<AndroidElement> driver) {
		this.driver = driver;
		this.action = new BaseAction(driver);
	}
//	页面对象
	
	//登录对象
	public AndroidElement login_user() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userName");
	}
	public AndroidElement login_pwd() {
		return driver.findElementById("com.example.shoujiedemo:id/login_userPassword");
	}
	public AndroidElement login_submit() {
		return driver.findElementById("com.example.shoujiedemo:id/login_login");
	}
	//
	//个人
	public AndroidElement user() {
		return driver.findElementById("com.example.shoujiedemo:id/item_owner");
		
	}
	//发现
	public AndroidElement find() {
		return driver.findElementById("com.example.shoujiedemo:id/item_fround");
	}
	//点击头像
	public AndroidElement userImg() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_userImg");
	}
	//个人界面
	public AndroidElement mySpace() {
		return driver.findElementById(
				"com.example.shoujiedemo:id/myCenter_mySpace");
	}
	//我的评论
	public  AndroidElement myComment() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_Storing");
	}
	//个人中心
	public  AndroidElement myCenter() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_userInfo");
	}
	//帮助中心
	public  AndroidElement myHelp() {
		return driver.findElementById(
				"com.example.shoujiedemo:id/myCenter_helpCenter");
	}
	//我的关注
	public  AndroidElement myAttention() {
		return driver.findElementById(	
				"com.example.shoujiedemo:id/myCenter_myFollow");
	}
	//我的点赞
	public  AndroidElement myAgreement() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_myAgreement");
	}
	//点击“壁纸”
	public AndroidElement wallpaper() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_userImg_wallpaper");
		
	}
	//点击“头像”
	public AndroidElement userImg_img() {
		return driver.findElementById("com.example.shoujiedemo:id/myCenter_userImg_img");
	}
	//相册选取
	public AndroidElement photo() {
		return driver.findElementByXPath("//*[@text='从相册选取']");
	}
	//取消
	public AndroidElement unphoto() {
		return driver.findElementByXPath("//*[@text='取消']");
		
	}
	//进入图片界面
	public AndroidElement photo1() {
		return driver.findElementById("android:id/content");
	}
	//选中图片
	public AndroidElement photo2() {
		return driver.findElementById("com.android.gallery3d:id/gl_root_view");
	}
	//保存图片
	public AndroidElement photo_select() {
		return driver.findElementByXPath("//*[@text='保存']");
	}
	//确认保存图片
	public  AndroidElement photo_submit() {
		return driver.findElementByXPath("//*[@text='确认']");
	}


	//点击“+”号
	public AndroidElement add() {
		return driver.findElementById("com.example.shoujiedemo:id/mySpace_add");
	}
	//选择封面
	public AndroidElement select_works_pic() {
		return driver.findElementById("com.example.shoujiedemo:id/mySpace_addGroup_img");
	}
	//文集名字
	public AndroidElement workname() {
		return driver.findElementById("//*[@text='文集名字']");
	}
	//保存文集
	public  AndroidElement work_submit() {
		return driver.findElementByXPath("//*[@text='确认']");
	}
	
	//取消添加
	public  AndroidElement work_unsubmit() {
		return driver.findElementByXPath("//*[@text='取消']");
	}
	//选择文集
	public AndroidElement select_work() {
		return driver.findElementById("com.example.shoujiedemo:id/article_image");
	}
	//点击三角号
	public AndroidElement click_thr() {
		return driver.findElementById("com.example.shoujiedemo:id/article_choose");
	}
	//更换封面 
	public AndroidElement change_pic() {
		return driver.findElementByXPath("//*[@text='更换封面']");
	}
	//删除
	public AndroidElement remove_work() {
		return driver.findElementByXPath("//*[@text='删除']");
	}
	//点赞
	public AndroidElement agree() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_heart_tv_like_num");
	}
	//关注1
	public AndroidElement attention() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_heart_btn_follow");
	}
	//关注2
	public AndroidElement attention2(){
		return driver.findElementById("com.example.shoujiedemo:id/myFollow_cancel");
	}
	//返回
	public AndroidElement ret() {
		return driver.findElementById(
				"com.example.shoujiedemo:id/myFollow_return");
	}

	
	
	
	
	
	
	
	
	
	
	//登录
	public void login_sucess(String user, String pwd) throws InterruptedException {
		Thread.sleep(1000);
		action.type(login_user(), user);
		action.type(login_pwd(), pwd);
		action.click(login_submit());
		
	}
	//进入个人页面
	public void user_page() throws InterruptedException {
		Thread.sleep(1000);
		action.click(user());
		
	}
	//切换头像
	public void select_user_image() throws InterruptedException {
		Thread.sleep(1000);
		action.click(userImg());
		Thread.sleep(1000);
		action.click(userImg_img());
		Thread.sleep(1000);
		action.click(photo());
		Thread.sleep(1000);
		action.click(photo1());
		Thread.sleep(1000);
		action.click(photo2());
		Thread.sleep(1000);
		action.click(photo_select());
		Thread.sleep(1000);
		action.click(photo_submit());
		
	}
	//切换壁纸
	public void select_wallpaper() throws InterruptedException {
		Thread.sleep(1000);
		action.click(userImg());
		Thread.sleep(1000);
		action.click(wallpaper());
		Thread.sleep(2000);
		action.click(photo());
		Thread.sleep(1000);
		action.click(photo1());
		Thread.sleep(2000);
		action.click(photo2());
		Thread.sleep(1000);
		action.click(photo_select());
		Thread.sleep(1000);
		action.click(photo_submit());
		
	}
	
	//切换取消(软件停止运行)
	public void disselect() throws InterruptedException {
		Thread.sleep(1000);
		action.click(userImg());
		Thread.sleep(1000);
		action.click(userImg_img());
		Thread.sleep(1000);
		action.click(photo());
		Thread.sleep(1000);
		action.click(unphoto());
		Thread.sleep(1000);
		action.click(photo_submit());
	}
	//添加文集-仅添加封面
	public void add_works_pic() throws InterruptedException {
		Thread.sleep(1000);
		action.click(mySpace());
		Thread.sleep(1000);
		action.click(add());
		Thread.sleep(1000);
		action.click(select_works_pic());
		Thread.sleep(1000);
		action.click(photo1());
		Thread.sleep(1000);
		action.click(photo2());
		Thread.sleep(1000);
		action.click(photo_select());
	
	}
	//添加文集-仅填写名字
	public void add_works_name(String workname) throws InterruptedException {
		action.click(mySpace());
		Thread.sleep(1000);
		action.click(add());
		Thread.sleep(1000);
		action.type(workname(), workname);
		Thread.sleep(1000);
	}
	//添加文集-不可见
	public void addwork0() throws InterruptedException {
		Thread.sleep(1000);
		action.click(work_submit());
		Thread.sleep(1000);
		action.click(work_unsubmit());
	}
	//添加文集-可成功
	public void addwork() throws InterruptedException {
		action.click(work_submit());
		Thread.sleep(1000);
		action.click(work_unsubmit());
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		action.click(mySpace());
	}
	//添加文集-两次确认
	public void addwork2() throws InterruptedException {
		Thread.sleep(1000);
		action.click(work_submit());
		Thread.sleep(1000);
		action.click(work_submit());
		Thread.sleep(1000);
		action.click(work_unsubmit());
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		action.click(mySpace());
	}
	//选择文集
	public void s_work() throws InterruptedException{
		Thread.sleep(1000);
		action.click(mySpace());
		Thread.sleep(1000);
		action.click(select_work());
		
	}
	//更换封面
	public void  change_Pic() throws InterruptedException {
		Thread.sleep(1000);
		action.click(mySpace());
		Thread.sleep(1000);
		action.click(click_thr());
		Thread.sleep(1000);
		action.click(change_pic());
		Thread.sleep(2000);
	
	}
	//删除封面
	public void  remove_works() throws InterruptedException {
		Thread.sleep(1000);
		action.click(mySpace());
		Thread.sleep(1000);
		action.click(click_thr());
		Thread.sleep(1000);
		action.click(remove_work());
		Thread.sleep(2000);
		driver.navigate().back();
		action.click(mySpace());	
	}
	//查看评论
	public void  look_comment() throws InterruptedException {
		Thread.sleep(1000);
		action.click(myComment());
	}
	//点击个人中心
	public void  look_center() throws InterruptedException {
		Thread.sleep(1000);
		action.click(myCenter());
	}
	//点击帮助中心
	public void look_help() throws InterruptedException {
		Thread.sleep(1000);
		action.click(myHelp());
	}
	
	//关注
	public void  Attention() throws InterruptedException {
		Thread.sleep(1000);
		action.click(find());
		Thread.sleep(1000);
		action.click(attention());
	}
	//查看关注
	public void   look_attention() throws InterruptedException {
		Thread.sleep(1000);
		action.click(myAttention());
	}
	//取消关注
	public  void delete_attention() throws InterruptedException {
		action.click(myAttention());
		Thread.sleep(1000);
		action.click(attention2());
		Thread.sleep(1000);
		action.click(ret());
		Thread.sleep(1000);
		action.click(myAttention());
		
	}
	//点赞
	public void Agree() throws InterruptedException {
		Thread.sleep(1000);
		action.click(find());
		Thread.sleep(1000);
		action.click(agree());
	}
	//查看点赞
	public void look_agree() throws InterruptedException {
		Thread.sleep(1000);
		action.click(myAgreement());
	}
	
}
