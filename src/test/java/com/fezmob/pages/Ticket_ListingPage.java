package com.fezmob.pages;



import java.util.List;

import com.fezmob.base.BasePage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Ticket_ListingPage extends BasePage {

	public Ticket_ListingPage(AndroidDriver<MobileElement> driver) {
		super(driver);
	}

	@AndroidFindBy(id="com.fieldez.mobile:id/menu_call_search")
	private MobileElement searchButton;
	@AndroidFindBy(id="com.fieldez.mobile:id/menu_call_add")
	private MobileElement addCallButton;
	@AndroidFindBy(id="com.fieldez.mobile:id/menu_assignee_filter")
	private MobileElement userFilterButton;
	
	/*@AndroidFindBy(id="com.fieldez.mobile:id/menu_assignee_filter")
	private MobileElement userFilterButton;*/
	
	/*@AndroidFindBy(id="android:id/text1")
	private MobileElement ticketTypeButton;
	@AndroidFindBy(id="com.fieldez.mobile:id/menu_assignee_filter")
	private MobileElement userFilterButton;*/
	
	@AndroidFindBy(xpath="//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout")
	 private List<MobileElement> TicketList;
		
	
	//Methods
	public void selectTicket(int i){		
	System.out.println(TicketList.size());
		if(TicketList.size()==0){
			System.out.println("Ticket listing page is empty");}
		else if(TicketList.size()<i){
			System.out.println("No not exists");}
		else{
			TicketList.get(i).click();}
	}
	
	public void clickAddTicket(){		
		addCallButton.click();
		}
	
}
