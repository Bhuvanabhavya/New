package Selenium_Intro;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Selenium_chrome {

	
	public static void main(String[] args) {
		// interface object = new class();
		
		WebDriver driver = new EdgeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
	}

}
