package com.fezmob.pages;



import com.fezmob.base.BasePage;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import io.appium.java_client.pagefactory.AndroidFindBy;

public class MenuPage extends BasePage{

	public MenuPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id="com.fieldez.mobile:id/nav_refresh_button")
	private MobileElement refreshButton;
	
	public void click_RefreshButton(){
		refreshButton.click();
	}
	
/*	@FindBy(id="com.fieldez.mobile:id/nav_refresh_button")
	private AndroidElement refreshButton;
	
	@FindBy(name="Home")
	private AndroidElement homeBotton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Home\")")
	private AndroidElement homeBotton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Logout\")")
	private AndroidElement logoutBotton;
	
	@FindBy(name="Logout")
	private AndroidElement logoutButton;

	
	//Methods 
	
	public void click_RefreshButton(){
		refreshButton.click();
	}
	
	public void click_HomeBotton(){
		homeBotton.click();
	}
	
	public void click_LogoutButton(){
		logoutBotton.click();
	}
	
	public void logout()
	{
//		welcome.click();
		click_Menu();
		click_LogoutButton();
	//	Utility.clickUsingJs(driver, menuButton);
		//waitAndClick(logoutBotton);
		click_YesButton();
	}*/
}
