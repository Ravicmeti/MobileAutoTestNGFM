package com.fezmob.pages;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class ConfirmContinuePage extends BasePage{

	@AndroidFindBy(uiAutomator="new UiSelector().resourceId(\"com.fieldez.mobile:id/continueButton\")")
	private MobileElement continueButton;
	
	public ConfirmContinuePage(AndroidDriver<MobileElement> driver){
		super(driver);
	}
	
	public void clickContinue()
	{
		try {
			continueButton.click();
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
