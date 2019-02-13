package com.fezmob.pages;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Expense_ListingPage extends BasePage {

	public Expense_ListingPage(AndroidDriver<MobileElement> driver) 
	{
		super(driver);
	}
	
	@AndroidFindBy(id="com.fieldez.mobile:id/menu_expense_add")
	private MobileElement addButton;
	
	public void click_AddExpense(){
		addButton.click();
	}
	
}
