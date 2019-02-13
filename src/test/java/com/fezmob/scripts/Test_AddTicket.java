package com.fezmob.scripts;

import org.testng.annotations.Test;

import com.fezmob.base.BaseTest;
import com.fezmob.pages.Ticket_AddPage;
import com.fezmob.pages.HomePage;
import com.fezmob.pages.Ticket_ListingPage;

public class Test_AddTicket extends BaseTest {

	@Test
	public void testAddJob() {
	
	HomePage hp=new HomePage(driver);
	hp.click_Lead();
	
	Ticket_ListingPage tp=new Ticket_ListingPage(driver);
	tp.clickAddTicket();
	
	Ticket_AddPage ap = new Ticket_AddPage(driver);
	ap.enterTicketDetails();
	ap.clickBubmit();
	}
}
