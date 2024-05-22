package TestNgScreenshot;

import java.io.File;
import java.io.IOException;
//import javax.xml.datatype.Duration;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

//import dev.failsafe.internal.util.Durations;

public class Screenshot {

	public WebDriver driver;
	
	@BeforeSuite
	public void Launchbrowser() throws IOException {
		
		driver = new EdgeDriver();
		
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
	public void enterusername() throws IOException {
		
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
		}
		else
		System.out.println("Admin tab is not found");
		
	}
	@Test(priority = 5)
	public void Clickonadmin() {
		
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		
		System.out.println("I am in admin page");
	}
	public void screenshotHandling(String image) throws IOException{
		File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenshot,new File("C:\\Users\\kavya\\eclipse-workspace\\3012"
				+ "\\bhavya\\AutomationProject\\src\\test\\java\\Screenshots\\"+image+".pngobjects"));
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