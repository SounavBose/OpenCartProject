package testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC002_LoginTest extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups={"sanity","master"})
	public void LoginTest(String email, String pwd, String res) {
		logger.info("******Starting Login Test******");
		try {
			// Home Page
			logger.info("******HomePage Validations******");
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogin();
			hp.hold();

			// Login Page
			logger.info("******LoginPage Validations******");
			LoginPage lp = new LoginPage(driver);
			{
				lp.emailAdd(email);
				lp.loginPass(pwd);
				lp.loginClick();
				lp.hold();
			}

			// MyAccount Page
			logger.info("******MyAccountPage Validations******");
			MyAccountPage myAcc = new MyAccountPage(driver);
			boolean target = myAcc.isMyAccountPageExists();
			myAcc.hold();

			if (res.equalsIgnoreCase("Valid")) {
				if (target == true) {
					myAcc.hold();
					myAcc.logout();
					Assert.assertTrue(true);
					
				}
			} else {
				Assert.assertTrue(false);
				myAcc.hold();
			}

			if (res.equalsIgnoreCase("Invalid")) {
				if (target == true) {
					myAcc.hold();
					myAcc.logout();
					Assert.assertTrue(false);
					
				}
			} else {
				Assert.assertTrue(true);
				myAcc.hold();

			}
			
		} catch (Exception e) {
			logger.error("***Test FAILED***");
			Assert.fail();
			logger.info("************HomePage Validations******");

		}

	}

}
