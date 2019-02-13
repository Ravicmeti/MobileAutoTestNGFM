package com.fezmob.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_AddPage extends BasePage {

	public Ticket_AddPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='1']/android.widget.LinearLayout[@index='0']/android.widget.LinearLayout[@index='1']/android.widget.LinearLayout")
	private List<MobileElement> CustomerDetails;
	
	@AndroidFindBy(id="com.fieldez.mobile:id/submitButton")
	private MobileElement submitButton;
	
	public void enterTicketDetails() {
		
		System.out.println(CustomerDetails.size());
		CustomerDetails.get(0).sendKeys("Selenium Master1");
		CustomerDetails.get(1).sendKeys("Banaglore");
		CustomerDetails.get(2).sendKeys("560050");
	//	CustomerDetails.get(3).sendKeys("Banaglore");	
		System.out.println("Ticket details are entered and ready to save");
	}
	
	public void clickBubmit() {
		submitButton.click();
	}
}
