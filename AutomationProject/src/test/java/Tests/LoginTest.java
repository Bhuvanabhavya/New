package Tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import Common.BaseOrCommonClass;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.SignoutPage;

public class LoginTest extends BaseOrCommonClass {
	
	LoginPage lp;
	
	HomePage hp;
	
	SignoutPage sp;

	@BeforeSuite
	public void launchBrowser() {

		browserLaunching("chrome");
		
		// page object model class Object creation
		
		lp = new LoginPage(driver);
		
		// page factory model class Object creation
		
		//Syntax: class Objectname = pagefactory.initElements(web driver object, class.page );
		
		hp = PageFactory.initElements(driver, HomePage.class);
		
		sp = PageFactory.initElements(driver, SignoutPage.class);

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

	@Test(priority = 4)
	public void clickUserDrodown() {

        hp.clickUserDropdown();
        
		System.out.println("i am in @Test clickUserDrodown method");
	}	
	
	@Test(priority = 5)
	public void clickLogout() {

        sp.clickLogout();
        
		System.out.println("i am in @Test clickLogout method");
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
