package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class SignoutPage {

	public WebDriver driver;

	public SignoutPage(WebDriver driver) {

		this.driver = driver;
	}

	//2nd way
	
	@CacheLookup
    @FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
    public WebElement about;
	
	@FindBy(xpath = "//a[text()='Support']")
    public WebElement support;
	
	@FindBy(xpath = "//a[text()='Change Password']")
    public WebElement changePassword;
	
	@FindBy(xpath = "//a[text()='Logout']")
    public WebElement logout;
	
	public void clickLogout() {

		logout.click();
	}
	
	public void clickChangePassword() {

		changePassword.click();
	}
	
	public void clickSupport() {

		support.click();
	}
	
	public void clickAbout() {

		about.click();
	}
}
