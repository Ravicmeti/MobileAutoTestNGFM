package com.fezmob.pages;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_DetailsPage extends BasePage {

	public Ticket_DetailsPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(accessibility="Navigate up")
	private MobileElement backButton;
	@AndroidFindBy(accessibility="Update Call")
	private MobileElement updateStatusButton;
	@AndroidFindBy(accessibility="My Lines")
	private MobileElement lineItemButton;
	@AndroidFindBy(accessibility="More options")
	private MobileElement moreOptionsButton;
	@AndroidFindBy(accessibility="Customers")
	private MobileElement customerDetails;
	@AndroidFindBy(accessibility="History")
	private MobileElement historyDetails;
	
	public void clickBack()
	{
		backButton.click();
	}
	public void clickUpdateStatus()
	{
		updateStatusButton.click();
	}
	public void clickAddLineItem(){
	    lineItemButton.click();
	}
	public void clickMoreoptions()
	{
		moreOptionsButton.click();
	}
	public void clickCustomerDetails()
	{
		customerDetails.click();
	}
	public void clickHistory()
	{
		historyDetails.click();
	}

}
