package com.fezmob.pages;

import java.util.List;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_StatusesOptionListPage extends BasePage {

	public Ticket_StatusesOptionListPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='1']/android.support.v7.widget.RecyclerView[@index='0']/android.widget.RelativeLayout")
	private List<MobileElement> StatusOptions;
	
	public void selectStatus(int i)
	{
		System.out.println(StatusOptions.size());
		if(StatusOptions.size()<0){
			System.out.println("No status exists");}
		else if(StatusOptions.size()<i){
			System.out.println("Mentioned status not exists");}
		else{
			StatusOptions.get(i).click();}  
		}
	}
