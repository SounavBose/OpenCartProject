package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory; 

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//span[(text()='My Account')]")
	WebElement myAccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerBtn;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement loginBtn;
	
	public void hold() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	public void clickMyAccount() {
		myAccount.click();
	}
	
	public void clickRegister() {
		registerBtn.click();
	}
	
	public void clickLogin() {
		loginBtn.click();
		}
}
