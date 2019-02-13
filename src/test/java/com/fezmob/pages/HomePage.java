package com.fezmob.pages;



import com.fezmob.base.BasePage;



import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomePage extends BasePage {
	
	public HomePage(AndroidDriver<MobileElement> driver) 
	{
		super(driver);
	}
 
	@AndroidFindBy(accessibility="Open navigation drawer")
	private MobileElement menuButton;
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Lead\")")
	private MobileElement leadEntityButton;
	@AndroidFindBy(uiAutomator="new UiSelector().text(\"Expense\")")
	private MobileElement expenseButton;
	
	public void click_Menu(){
		menuButton.click();
	}
	
	public void click_Lead(){
		leadEntityButton.click();
	}
	
	public void click_Expense(){
		expenseButton.click();
	}
	/*@FindBy(name="Open navigation drawer")
	private AndroidElement menuButton;
	
	@AndroidFindBy(uiAutomator = "new UiSelector().text(\"Job\")")
	private MobileElement jobsLink;
	@FindBy(name="Jobs")
	private WebElement jobsLink;
	
	@FindBy(name="Dashboard")
	private MobileElement dashboardLink;
	
	@FindBy(name="Customer")
	private MobileElement customerLink;
	
	@FindBy(name="Leave")
	private MobileElement leaveLink;
	
	@FindBy(name="Asset")
	private MobileElement assetLink;
	
	@FindBy(name="Calendar")
	private MobileElement calendarLink;
	
	@FindBy(name="Messages")
	private MobileElement messagesLink;
	
	@FindBy(name="Attendance")
	private MobileElement attendanceLink;
	
	@FindBy(name="Tracker")
	private MobileElement trackerLink;
	
	@FindBy(name="Expense")
	private MobileElement expenseLink;
	
	@FindBy(name="Pin Location")
	private MobileElement pin_LocationLink;
	
	//Header items
	@FindBy(name="Search")
	private MobileElement search;
	
	@FindBy(name="Add")
	private MobileElement addCall;
	
	@FindBy(name="Select Assignee")
	private MobileElement userDropdown;
	
	//Confirmation
	@FindBy(id="android:id/button1")
	private MobileElement YesButton;
	
	@FindBy(id="android:id/button2")
	private MobileElement NoButton;
	
	public void click_Menu(){
		menuButton.click();
	}
	
	public JobListingPage click_Jobs(){
	   // jobsLink.click();
	    JobListingPage jlp= new JobListingPage(driver);
		return jlp;
	}
	
	public void click_Customer(){
		customerLink.click();
	}
	
	public void click_Leave(){
		leaveLink.click();
	}
	
	public void click_Asset(){
		assetLink.click();
	}
	
	public void click_Calendar(){
		calendarLink.click();
	}
	
	public void click_Messages(){
		messagesLink.click();
	}
	
	public void click_Dashboard(){
		dashboardLink.click();
	}
	
	public void click_Attendance(){
		attendanceLink.click();
	}
	
	public void click_Tracker(){
		trackerLink.click();
	}
	public void click_Expense(){
		dashboardLink.click();
	}
	
	public void click_PinLocation(){
		pin_LocationLink.click();
	}
	
	public void click_Search(){
		search.click();
	}
	
	public void click_AddCall(){
		addCall.click();
	}
	public void click_UserDropDown(){
		userDropdown.click();
	}
	
	public void click_YesButton(){
		YesButton.click();
	}
	public void click_NoButton(){
		NoButton.click();
	}*/
	
}