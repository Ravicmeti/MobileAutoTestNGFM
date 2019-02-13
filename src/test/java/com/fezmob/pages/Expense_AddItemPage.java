package com.fezmob.pages;

import java.util.List;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Expense_AddItemPage extends BasePage {

	public Expense_AddItemPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@id='com.fieldez.mobile:id/allfieldslinearlayout']/android.widget.LinearLayout")
	private List<MobileElement> itemList;
	
	public void getListItems(){
		System.out.println(itemList.size());
	}
	
}
