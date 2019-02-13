package com.fezmob.scripts;


import org.testng.annotations.Test;

import com.fezmob.base.BaseTest;
import com.fezmob.pages.Expense_Add;
import com.fezmob.pages.Expense_AddItemPage;
import com.fezmob.pages.Expense_ListingPage;
import com.fezmob.pages.HomePage;


public class Test_AddExpense extends BaseTest {

	@Test
	public void testAddExpense() {
		HomePage hp=new HomePage(driver);
		hp.click_Expense();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		Expense_ListingPage elp=new Expense_ListingPage(driver);
		elp.click_AddExpense();
		
		Expense_Add ae = new Expense_Add(driver);
		ae.click_expDateButton();
		ae.click_OK();
		ae.click_addItem();
		
		Expense_AddItemPage aeip=new Expense_AddItemPage(driver);
		aeip.getListItems();
	}
}
