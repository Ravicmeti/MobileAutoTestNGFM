package com.fezmob.pages;


import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class LoginPage extends BasePage {
		
		@AndroidFindBy(id="com.fieldez.mobile:id/et_login")
		private MobileElement unTextBox;
		@AndroidFindBy(id="com.fieldez.mobile:id/et_password")
		private MobileElement pwTextBox;
		@AndroidFindBy(id="com.fieldez.mobile:id/btn_login")
		private MobileElement loginButton;
		
		
		
		public LoginPage(AndroidDriver<MobileElement> driver) {
			super(driver);
		}
		
		public void login(String un,String pw){
			
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALLOW\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALLOW\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALLOW\")").click();
			driver.findElementByAndroidUIAutomator("new UiSelector().text(\"ALLOW\")").click();
			
			try {
			if(unTextBox!=null) {
				unTextBox.sendKeys(un);
			}
			if(pwTextBox!=null)
				pwTextBox.sendKeys(pw);
			if(loginButton!=null)
				loginButton.click();
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(30000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			log.info("Confirm continue");
			new ConfirmContinuePage(driver).clickContinue();
			
		}
		
		
}
