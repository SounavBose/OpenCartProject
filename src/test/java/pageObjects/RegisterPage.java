package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(id = "input-firstname")
	WebElement firstName;

	@FindBy(id = "input-lastname")
	WebElement lastName;

	@FindBy(id = "input-email")
	WebElement email;

	@FindBy(id = "input-telephone")
	WebElement tele;

	@FindBy(id = "input-password")
	WebElement password;

	@FindBy(id = "input-confirm")
	WebElement confirmPassword;

	@FindBy(xpath = "//label[text()='Yes']")
	WebElement chkButton;

	@FindBy(xpath = "//input[@name=\"agree\"]")
	WebElement privacyPolicychk;

	@FindBy(xpath = "//input[@value=\"Continue\"]")
	WebElement continueBtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	// Perform Action

	public void setFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		lastName.sendKeys(lname);
	}

	public void setEmail(String emailadd) {
		email.sendKeys(emailadd);
	}

	
	public void setTelephone(String telephone) {
		tele.sendKeys(telephone);
	}
	public void setPassword(String pass) {
		password.sendKeys(pass);
	}

	public void confirmPassword(String confirmpass) {
		confirmPassword.sendKeys(confirmpass);
	}

	public void privacyPolicyChk() {
		privacyPolicychk.click();
	}

	public void continueBtn() {
		continueBtn.click();
	}

	
	
	public String getConfirmationMessage() {
		try {
			return(msgConfirmation.getText());
		}catch(Exception e) {
			return e.getMessage();
		}
	}
}
