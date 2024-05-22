package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {
	
	public WebDriver driver;
	
	Login_Page(WebDriver driver){
		
		this.driver = driver;//****inform compiler that this webDriver belongs to this page only that is why we 
		//use this object and we use this keyword when construction creation using page object model//
	} 
	
	private By username_Textbox = By.xpath("//input[@name='username']");
	
	private By password_Textbox = By.xpath("//input[@name='password']");
	
	private By login_button = By.xpath("//button[@type='submit']");

	private By Forgetyourpassword = By.xpath("//*[text()='Forgot your password? ']]");
	
	public void enterUsername() {
		
		driver.findElement(username_Textbox).sendKeys("Admin");
	}
	public void enterPassword() {
		
		driver.findElement(password_Textbox).sendKeys("admin123");
	}
	public void clickLogin() {
		
		driver.findElement(login_button).click();
	}
	public void clickForgetyourpassword() {
		
		driver.findElement(Forgetyourpassword).click();
}
}