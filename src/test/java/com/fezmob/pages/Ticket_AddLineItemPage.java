package com.fezmob.pages;

import java.util.List;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_AddLineItemPage extends BasePage{

	public Ticket_AddLineItemPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}
	
	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='3']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
	private List<MobileElement> LineItemLevelFields;

	public void setItemLevelFieldVales(){
		
		System.out.println(LineItemLevelFields.size());
		if(LineItemLevelFields.size()<=0){
			System.out.println("No status exists");}
		else{
			LineItemLevelFields.get(0).sendKeys("4");
			LineItemLevelFields.get(1).sendKeys("No");
			LineItemLevelFields.get(2).sendKeys("At5");
			LineItemLevelFields.get(3).sendKeys("One10");
			LineItemLevelFields.get(4).sendKeys("OneAlp");
			System.out.println("Line Item details are entered and ready for save");
		}
   }
}
