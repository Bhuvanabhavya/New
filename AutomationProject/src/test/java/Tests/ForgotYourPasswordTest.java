package Tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseOrCommonClass;
import Methods.ForgotYourPasswordMethods;
import Pages.LoginPage;

public class ForgotYourPasswordTest extends BaseOrCommonClass {
	
	LoginPage lp;

	ForgotYourPasswordMethods fpm;
	
	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");
		
		lp = new LoginPage(driver);
		
		fpm = new ForgotYourPasswordMethods(driver);

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
	public void clickForgotYourPasswordLink() {

		lp.clickForgotYourPassword();
		
		System.out.println("i am in @Test clickForgotYourPasswordLink method");
	}

	@Test(priority = 2)
	public void enterUsername() {

		fpm.enterUsername("Testing");
		
		System.out.println("i am in @Test enterUsername method");
	}

	@Test(priority = 3)
	public void ClickCancelButton() {

        fpm.clickCancel();
        
		System.out.println("i am in @Test enterPassword method");
	}
	
	@Test(priority = 4)
	public void verifyUsernameOnLoginPage() {

        lp.enterUsername();
        
		System.out.println("i am in @Test verifyUsernameOnLoginPage method");
	}

	@AfterMethod
	public void waitForanAppn() {

		System.out.println("i am in @aftermethod method");
	}

	@AfterSuite
	public void closeBrowser() {

		//browserClosing();

		System.out.println("i am in @afteruite method");
	}


}
