package com.fezmob.pages;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Expense_Add extends BasePage {

	public Expense_Add(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(id="com.fieldez.mobile:id/fromDateEditTextView")
	private MobileElement expDate;
	@AndroidFindBy(id="com.fieldez.mobile:id/ok")
	private MobileElement okButton;
	@AndroidFindBy(id="com.fieldez.mobile:id/button1")
	private MobileElement tagCalls;
	@AndroidFindBy(id="com.fieldez.mobile:id/add_line_item")
	private MobileElement addItem;

	
	public void click_expDateButton(){
		expDate.click();
	}
	public void click_OK(){
		okButton.click();
	}
	public void click_tagCalls(){
		tagCalls.click();
	}
	public void click_addItem(){
		addItem.click();
	}
	
}
