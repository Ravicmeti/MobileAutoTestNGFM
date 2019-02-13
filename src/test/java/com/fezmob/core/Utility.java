package com.fezmob.core;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Utility 
{
	
	public static String getFormatedDateTime(){
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		return simpleDate.format(new Date());
	}
	public static String getCurrentMonth(){
		SimpleDateFormat s=new SimpleDateFormat("MMM");
		return s.format(new Date());
	}
	
	public static String getCurrentYear(){
		SimpleDateFormat s=new SimpleDateFormat("YYYY");
		return s.format(new Date());
	}
	
	public static String getSelectedOptioninListBox(WebElement listBox){
		
		Select select=new Select(listBox);
		return select.getFirstSelectedOption().getText();
	}
	
	
	
	/*public static void moveToElement(WebDriver driver,WebElement element){
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}*/
	
	public static boolean verifyElementsIsPresent(WebDriver driver, WebElement element)
	  {
		WebDriverWait wait = new WebDriverWait(driver,5);
		  try
		  {
			  wait.until(ExpectedConditions.visibilityOf(element));
			  return true;
		  }
		  catch(Exception e)
		  {
			  return false;
		  }
	  }
	
	
	public static void clickUsingJs(AndroidDriver driver, AndroidElement e)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		//j.executeScript("arguments[0].click()", e);
		j.executeScript("mobile:tap", e);
	}
	
	public static void enterUsingJs(WebDriver driver, WebElement e, String v)
	{
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].value=aruments[1]",e,v);
	}
	
	public static boolean checkArrayListHasDuplicate(ArrayList<String> allText)
	{
		HashSet<String> clone = new HashSet<String>();
		for(String s:allText)
		{
			if(clone.add(s))//This will add ListBox individually to Set Object
			{
				System.out.println(s+" -> Not Duplicate");
			}
			else
			{
				System.out.println(s+" ->Duplicate");
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<String> getAllTextFromListBox(WebElement listbox, int startIndex)
	{
		Select select = new Select(listbox);
		List<WebElement> allOptions = select.getOptions();
		ArrayList<String> allText = new ArrayList<String>();
		for(int i=startIndex;i<allOptions.size();i++)
		{
			String text = allOptions.get(i).getText();
			allText.add(text);
		}
		return allText;
	}
	public static boolean checkArrayListIsSorted(ArrayList<String> allText)
	{
		ArrayList<String> clone = new ArrayList<String>(allText);
		Collections.sort(clone,String.CASE_INSENSITIVE_ORDER);
		System.out.println("-----------------------------------");
		for(int i=0;i<clone.size();i++)
		{
			System.out.println(allText.get(i)+"==="+clone.get(i));
		}
		System.out.println("-----------------------------------");
		return allText.equals(clone);
	}
	
	public static String getScreenShot(AndroidDriver<MobileElement> driver, String imageFolderPath)
	{
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
	//	TakesScreenshot page=(TakesScreenshot) driver;
		try
		{
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE), new File(imagePath));
	
		}catch(Exception e)
		{
			
		}
		return imagePath;
		
	}
	
	public static String getScreenShot(String imageFolderPath)
	{
		String imagePath=imageFolderPath+"/"+getFormatedDateTime()+".png";
		
		try
		{
			Dimension desktopSize=Toolkit.getDefaultToolkit().getScreenSize();
			BufferedImage image = new Robot().createScreenCapture(new Rectangle(desktopSize));
			ImageIO.write(image, "png", new File(imagePath));
		}
		catch(Exception e)
		{
		}

		return imagePath;
		
	}
	public static String getPropertyValue(String filePath,String key)
	{
		String value="";
		Properties ppt=new Properties();
		try{
			ppt.load(new FileInputStream(filePath));
			value=ppt.getProperty(key);
		}
		catch(Exception e){
		}
		return value;
	}
	public static int getExcelRowCount(String path,String sheet)
	{
		int r=0;
		try{
			
			r=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getLastRowNum();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return r;
	}
	
	public static String getExcelCellValue(String path,String sheet,int r,int c)
	{
		String v="";
		try{
			
			v=WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return v;
	}
}
