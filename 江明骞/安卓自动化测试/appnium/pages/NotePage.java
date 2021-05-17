package pages;

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
	
	
	

	// 发现按键
	public AndroidElement faxian() {
		return driver.findElementById("com.example.shoujiedemo:id/item_fround");
	}

	// 中间发布
	public AndroidElement fabu() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.view.View[1]/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView[2]");
	}

	// 图片
	public AndroidElement photo() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_heart_cover");
	}

	// 感悟内容
	public AndroidElement ganwu_content() {
		return driver.findElementById("com.example.shoujiedemo:id/ed_heart_content");
	}

	// 选择分类
	public AndroidElement tag() {
		return driver.findElementById("com.example.shoujiedemo:id/custom_tag");
	}

	// 感悟上传按钮
	public AndroidElement upload_ganwubtn() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_btn_heart_commit");
	}

	// 点击粘贴音乐链接
	public AndroidElement music_link() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_music_song_name");
	}

	// 音乐链接内容
	public AndroidElement link_content() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_song_ed_link");
	}

	// 链接上传
	public AndroidElement link_upload() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_song_item_btn_commit");
	}

	// 链接上传取消
	public AndroidElement link_upload_cancel() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_song_item_btn_dismiss");
	}

	// 音乐想法内容
	public AndroidElement music_content() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_music_ed_mind");
	}

	// 音乐上传按钮
	public AndroidElement upload_musicbtn() {
		return driver.findElementById("com.example.shoujiedemo:id/upload_btn_music_commit");
	}

	// 感悟按钮
	public AndroidElement ganwu() {
		return driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"感悟\"]");
	}

	// 搜索内容
	public AndroidElement search_content() {
		return driver.findElementById("com.example.shoujiedemo:id/ed_search");
	}

	// 搜索按钮
	public AndroidElement search() {
		return driver.findElementById("com.example.shoujiedemo:id/btn_search");
	}

	// 音乐按钮
	public AndroidElement music() {
		return driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"音乐\"]");
	}

	// 下标号控件
	public AndroidElement xiabaio() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_heart_btn_pull");
	}

	// 删除
	public AndroidElement delete() {
		return driver.findElementById("com.example.shoujiedemo:id/follow_heart_ln_report");
	}

	// 删除-确定
	public AndroidElement delete_commit() {
		return driver.findElementById("com.example.shoujiedemo:id/delete_content_item_btn_commit");
	}

	// 删除-取消
	public AndroidElement delete_cancel() {
		return driver.findElementById("com.example.shoujiedemo:id/delete_content_item_btn_dismiss");
	}

	// 第一条用户发布的感悟
	public AndroidElement first_user_ganwu() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.view.View[1]/android.view.View/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.TextView[5]");
	}

	// 第一条用户头像
	public AndroidElement first_user_ganwu_photo() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.view.View[1]/android.view.View/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.RelativeLayout[1]/android.widget.RelativeLayout/android.widget.ImageView[1]");
	}

	// 第一条用户界面音乐
	public AndroidElement first_user_ganwu_music() {
		return driver.findElementByXPath("//androidx.appcompat.app.ActionBar.Tab[@content-desc=\"　　音乐　　\"]");

	}

	// 播放第一条音乐
	public AndroidElement first_user_music() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.view.View[1]/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.RelativeLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button");

	}

	// 进入音乐详细界面
	public AndroidElement music_s() {
		return driver.findElementById("com.example.shoujiedemo:id/already_music_view_cover");

	}

	// 播放第二首音乐
	public AndroidElement second_user_music() {
		return driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.view.View/android.view.View/android.widget.FrameLayout/android.widget.LinearLayout/android.view.View/android.view.View[1]/android.view.View/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.widget.RelativeLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.Button");

	}

//	页面操作方法
	
	
	public void login_sucess(String user, String pwd) throws InterruptedException {
		Thread.sleep(1000);
		action.type(login_user(), user);
		action.type(login_pwd(), pwd);
		action.click(login_submit());
		
	}

	// 发布一条感悟
	public MainPage upload_ganwu(String content, String tag) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.dragAndSlide1(fabu(), 512, 1368);
		action.type(ganwu_content(), content);
		action.type(tag(), tag);
		action.click(upload_ganwubtn());
		return new MainPage(driver);
	}

	// 发布一条错误感悟,返回文本
	public String upload_ganwu_fail(String content, String tag) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.dragAndSlide1(fabu(), 512, 1368);
		action.type(ganwu_content(), content);
		action.type(tag(), tag);
		action.click(upload_ganwubtn());
		return action.getToast();
	}

	// 发布一条音乐
	public MainPage upload_music(String music, String mind) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.dragAndSlide1(fabu(), 599, 1466);
		action.click(music_link());
		Thread.sleep(1000);
		action.type(link_content(), music);
		action.click(link_upload());
		Thread.sleep(3000);
		action.type(music_content(), mind);
		action.click(upload_musicbtn());
		Thread.sleep(1000);
		return new MainPage(driver);
	}

	// 取消上传音乐
	public MainPage upload_music_cancel(String music) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.dragAndSlide1(fabu(), 599, 1466);
		action.click(music_link());
		Thread.sleep(1000);
		action.type(link_content(), music);
		action.click(link_upload_cancel());
		Thread.sleep(1000);
		return new MainPage(driver);
	}

	// 在发现-感悟中搜索
	public MainPage ganwu_search(String text) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.click(ganwu());
		Thread.sleep(1000);
		action.type(search_content(), text);
		action.click(search());
		Thread.sleep(1000);
		return new MainPage(driver);
	}

	// 在发现-音乐中搜索
	public MainPage music_search(String text) throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.click(music());
		Thread.sleep(1000);
		action.type(search_content(), text);
		action.click(search());
		Thread.sleep(1000);
		return new MainPage(driver);
	}

	// 取消删除一条感悟
	public MainPage ganwu_delete_cancel() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.click(ganwu());
		action.click(xiabaio());
		action.click(delete());
		action.click(delete_cancel());
		Thread.sleep(1000);
		return new MainPage(driver);
	}

	// 删除一条感悟
	public String ganwu_delete() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		action.click(ganwu());
		action.click(xiabaio());
		action.click(delete());
		action.click(delete_commit());
		Thread.sleep(1000);
		return action.getToast();
	}

	// 在感悟中点击用户发布内容进入用户发布的感悟
	public MainPage ganwu_enter() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		Thread.sleep(1000);
		action.click(ganwu());
		Thread.sleep(1000);
		action.click(first_user_ganwu());
		return new MainPage(driver);
	}

	// 在感悟中点击用户头像查看用户音乐
	public MainPage ganwu_photo_enter() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		Thread.sleep(1000);
		action.click(ganwu());
		Thread.sleep(1000);
		action.click(first_user_ganwu_photo());
		Thread.sleep(1000);
		action.click(first_user_ganwu_music());
		return new MainPage(driver);
	}

	// 在音乐中点击播放音乐后暂停
	public MainPage music_begin() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		Thread.sleep(1000);
		action.click(music());
		Thread.sleep(3000);
		action.click(first_user_music());
		Thread.sleep(10000);
		action.click(first_user_music());
		return new MainPage(driver);
	}

	// 在音乐中点击播放音乐后暂停
	public MainPage music_enter() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		Thread.sleep(1000);
		action.click(music());
		Thread.sleep(3000);
		action.click(first_user_music());
		Thread.sleep(20000);
		action.click(music_s());
		return new MainPage(driver);
	}

	// 在音乐中同时播放两首音乐
	public MainPage music_begin2() throws InterruptedException {
		Thread.sleep(2000);
		action.click(faxian());
		Thread.sleep(1000);
		action.click(music());
		Thread.sleep(3000);
		action.click(first_user_music());
		action.click(second_user_music());
		Thread.sleep(10000);
		return new MainPage(driver);
	}

}
