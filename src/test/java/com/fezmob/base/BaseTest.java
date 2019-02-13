package com.fezmob.base;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.fezmob.core.TestListener;
import com.fezmob.core.Utility;
import com.fezmob.pages.LoginPage;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

@Listeners(TestListener.class)
public abstract class BaseTest implements AutomationConstants {
	
	public ExtentTest eTest;
	public String reportFile;
	
	public static Logger log;
	public static String un;
	public static String pw;
	public static long iTimeout;
	public static long eTimeout;
	public static ExtentReports eReport;
	

	public boolean loginRequired=true;
	public boolean logoutRequired=true;
	
	public BaseTest() {
		log=Logger.getLogger(this.getClass());
		
	}

	public AndroidDriver<MobileElement> driver;
	
	
	@BeforeSuite
	public void initReport()
	{
		log.info("Initializing ExtentReport");
		String now=Utility.getFormatedDateTime();
		reportFile=REPORT_PATH+now+".html";
		eReport=new ExtentReports(reportFile);
	}
	
	@AfterSuite
	public void publishReport()
	{
		log.info("Publishing ExtentReport:"+reportFile);
		eReport.flush();
	}
	
	@BeforeTest
	public void initGlobalVar(){
		log.info("Initialize Global Variables");
		un=Utility.getPropertyValue(CONFIG_PATH,"UN");
		pw=Utility.getPropertyValue(CONFIG_PATH,"PW");
		iTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH,"IMPLICIT"));
		eTimeout=Long.parseLong(Utility.getPropertyValue(CONFIG_PATH,"EXPLICIT"));
		System.out.println("completed initglobalvar");
		
	}
	
	@BeforeClass
	public void MobileTestLaunch() throws MalformedURLException{
		
				DesiredCapabilities capabilities = new DesiredCapabilities();
		
				capabilities.setCapability("automationName", "UiAutomator2");
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", "Moto G4 plus");
				capabilities.setCapability("udid", "ZY223K7GT3");
				capabilities.setCapability("appPackage", "com.fieldez.mobile");
				capabilities.setCapability("appActivity", "com.fieldez.android.ui.activities.LoginActivity");
	
			  driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"),capabilities);
			 // System.out.println(driver);
 			//  driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	
	
	@AfterClass
	public void teardown(){
		log.info("Closing App");
		driver.quit();
	}
	
	@BeforeMethod
	public void preCondition(Method method){
		if(loginRequired){
			log.info("Auto login");
			new LoginPage(driver).login(un,pw);
		}
		eTest=eReport.startTest(method.getName());
		log.info("Started executing test:"+method.getName());
	}
	
	@AfterMethod
	public void postCondition(ITestResult testNGTestResult){
		
		if(testNGTestResult.getStatus()==ITestResult.FAILURE)
		{
			String imgPath=	Utility.getScreenShot(driver, REPORT_PATH);
			System.out.println(imgPath);
			String path=eTest.addScreenCapture("."+imgPath);
			System.out.println(path);
			eTest.log(LogStatus.FAIL,"Check log for details",path);
			log.error("Test is FAILED");	
			
		}
		else
		{
			eTest.log(LogStatus.PASS,"Script executed successfully");
			log.info("Test is PASSED");
		}
		eReport.endTest(eTest);
		
		if(logoutRequired){
			log.info("Auto logout");
			//new MenuPage(driver).logout();
		}
		
	}
}
