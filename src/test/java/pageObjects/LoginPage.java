package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
			
}
	
	
	@FindBy (id="input-email")
	WebElement emailAdd;
	
	@FindBy (id="input-password")
	WebElement loginPwd;
	
	@FindBy (xpath="//input[@type=\"submit\"]")
	WebElement clickLogin;
	
	
	
	public void hold() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	public void emailAdd(String email) {
		emailAdd.sendKeys(email);
	}
	
	public void loginPass(String pass) {
		loginPwd.sendKeys(pass);
	}
	
	public void loginClick() {
		clickLogin.click();
	}
	
	
}
