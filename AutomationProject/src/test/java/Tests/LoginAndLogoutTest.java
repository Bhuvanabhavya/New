package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseOrCommonClass;
import Pages.LoginPage;

public class LoginAndLogoutTest extends BaseOrCommonClass {
	
	LoginPage lp;

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");
		
		lp = new LoginPage(driver);

		System.out.println("i am in @BeforeSuite method");
	}

	@BeforeClass
	public void launchURL() {

		urlLaunching("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");

		maximizeWindow();

		System.out.println("i am in @BeforeClass method");

	}

	@BeforeMethod
	public void waitForanApplicaton() {

		waitingTime();

		System.out.println("i am in @Beforemethod method");
	}

	@Test(priority = 1)
	public void enterUsername() {

		lp.enterUsername();
		
		System.out.println("i am in @Test enterUsername method");
	}

	@Test(priority = 2)
	public void enterPassword() {

        lp.enterPassword();
        
		System.out.println("i am in @Test enterPassword method");
	}

	@Test(priority = 3)
	public void clickLogin() {

        lp.clickLogin();
        
		System.out.println("i am in @Test clickLogin method");
	}	

	@AfterMethod
	public void waitForanAppn() {

		System.out.println("i am in @aftermethod method");
	}

	@AfterSuite
	public void closeBrowser() {

		browserClosing();

		System.out.println("i am in @afteruite method");
	}


}
