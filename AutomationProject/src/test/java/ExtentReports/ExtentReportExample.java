package ExtentReports;


import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Common.BaseOrCommonClass;
import Pages.LoginPage;


public class ExtentReportExample extends BaseOrCommonClass{	

	public static ExtentReports report;

	public static ExtentTest test;
	
	LoginPage lp;

	@BeforeSuite
	public void startTest() {

		report = new ExtentReports(System.getProperty("user.dir") + "\\LiveTech.html");

		test = report.startTest("Evening Batch");
		
	}	

	@BeforeTest
	public void launchBrowser() {

		browserLaunching("Chrome");
		
		lp = new LoginPage(driver);
		
		System.out.println("i am in @BeforeSuite method");
	}
	
	@BeforeClass
	public void launcURL() {

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		System.out.println("i am in @BeforeClass method");
		
		waitingTime();
	}
	
	@Test(priority = 1)
	public void loginToOrangeHRM() {
		
		lp.enterUsername();

		lp.enterPassword();

		lp.clickLogin();

		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("OrangeHRM")) {

			test.log(LogStatus.PASS, "Title is same");

		} else {

			test.log(LogStatus.FAIL, "Title is not same");
		}

	}
	@AfterClass
	public void endTest() {

		report.endTest(test);

		report.flush();
	}

	@AfterSuite
	public void closeBrowser() {

		browserClosing();
	}

}
