package com.fezmob.pages;

import java.util.List;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_StatusUpdatePage extends BasePage {

	
	public Ticket_StatusUpdatePage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(xpath="//android.widget.FrameLayout[@index='3']/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout")
	private List<MobileElement> StatusLevelFields;

	
public void setStatusLevelFieldVales(){
		
		//System.out.println(StatusLevelFields.size());
		StatusLevelFields.get(1).sendKeys("test123");
		StatusLevelFields.get(2).sendKeys("Adding remarks");
		System.out.println("Status details are entered and ready for save");

   }
}


