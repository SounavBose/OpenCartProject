package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement myAccountHeader;

	@FindBy(xpath = "//a[@title=\"My Account\"]")
	WebElement myAccountBtn;

	@FindBy(xpath = "//div[@class=\"list-group\"]//a[text()='Logout']")
	WebElement logoutBtn;

	public boolean isMyAccountPageExists() {
		try {
			return (myAccountHeader.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	}
	public void hold() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}

	public void logout() {

		//myAccountBtn.click();
		logoutBtn.click();
	}

}
