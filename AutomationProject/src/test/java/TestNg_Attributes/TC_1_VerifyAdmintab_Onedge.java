package TestNg_Attributes;

//import javax.xml.datatype.Duration;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import TestNg.TC_1_VerifyAdmintab;

//import dev.failsafe.internal.util.Durations;

public class TC_1_VerifyAdmintab_Onedge extends TC_1_VerifyAdmintab {

	public WebDriver driver;
	
	@BeforeSuite
	public void Launchbrowser() {
		
		driver = new ChromeDriver();
		
		System.out.println("I am in before suite method");
		}
	@BeforeClass
	public void LaunchURL() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		System.out.println("I am in before class method");
	}
	@BeforeMethod
	public void Waitfortheapp() {
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		
		System.out.println("I am in before method");
	}
	@Test(priority = 1)
	public void enterusername() {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		System.out.println("I am in test method");
	}
	@Test(priority = 2)
	public void enterpassword() {
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		System.out.println("I am in test password method");
	}
	@Test(priority = 3)
	public void click() {
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("I am in submitt method");
	}
	@Test(priority = 4)
	public void Verifyadmintab() {
			
		WebElement adminTab = driver.findElement(By.xpath("//span[text()='Admin']"));
		
		if(adminTab.isDisplayed()) {
			
			System.out.println("Admin tab is displayed");
			
			adminTab.click();
		}
		else {
		System.out.println("Admin tab is not found");
		}
	}
	//@Test(priority = 5)
	//public void Clickonadmin() {
		
		//driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		//System.out.println("I am in admin page");
	//}
	
	@DataProvider(name = "enterData")
	public Object[][] enterData(){
		
		Object[][] values = new Object[3][2];
		
		values[0][0] = "Bhavya";
		values[0][1] = "Kalesha";
		
		values[1][0] = "Sanju";
		values[1][1] = "Karthik";
		
		values[2][0] = "Vali";
		values[2][1] = "Bhuvana";
		
		return values;
	}
	@Test(priority = 5, dataProvider = "enterData")
	public void Verifyandentertexttothetextbox(String username,String employeename) {
		
		WebElement username_TextBox = driver.findElement(By.xpath(
		"//div[@class='oxd-input-group__label-wrapper']//following-sibling::div//input[@class='oxd-input oxd-input--active']"));
		
		if(username_TextBox.isDisplayed()) {
			
			System.out.println("username_TextBox is displayed on Admin Page");
			
			username_TextBox.sendKeys(username);
		}else {
			System.out.println("username_TextBox is not displayed on Admin Page");
		}
		WebElement employee_TextBox = driver.findElement(By.xpath("//input[@placeholder='Type for hints...']"));
				if(employee_TextBox.isDisplayed()) {
					
					System.out.println("employee_TextBox is displayed on Admin Page");
					
					employee_TextBox.sendKeys(employeename);
				}else {
					System.out.println("employee_TextBox is not displayed on Admin Page");
				} 
	}
	@AfterMethod
	public void Waitforanapp() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6000));
		
		System.out.println("I am in after method");
		
	}
	@AfterSuite
	public void closeBrwoser() {
		//driver.quit();
		
		System.out.println("I am in after suite method");
	}
}
