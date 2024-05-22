package Methods;

import org.openqa.selenium.WebDriver;

import Pages.ForgotYourPasswordPage;

public class ForgotYourPasswordMethods {

	public WebDriver driver;

	public ForgotYourPasswordMethods(WebDriver driver) {

		this.driver = driver;
	}

	ForgotYourPasswordPage fyp = new ForgotYourPasswordPage(driver);

	public void enterUsername(String username) {

		driver.findElement(fyp.username_Textbox).sendKeys(username);
	}
	
	public void clickResetPassword() {

		driver.findElement(fyp.resetPassword_Button).click();
	}
	
	public void clickCancel() {

		driver.findElement(fyp.cancel_Button).click();
	}
}
