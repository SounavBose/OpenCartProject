package testCases;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"regression","master"})
	public void verify_accountRegistration() {

		
		logger.info("****** Starting TC001_AccountRegistrationTest ******");
		try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account...");
		hp.clickRegister();
		logger.info("Clicked on Register...");
		
		RegisterPage rp = new RegisterPage(driver);

		logger.info("Providing Customer Details  ...");
		rp.setFirstName(randomeString().toUpperCase());
		rp.setLastName(randomeString().toUpperCase());
		rp.setEmail(randomeString() + "@gmail.com");
		rp.setTelephone(randomeNumber());

		String password = randomeAlphaNumeric();

		rp.setPassword(password);
		rp.confirmPassword(password);

		rp.privacyPolicyChk();
		rp.continueBtn();

		logger.info("Validating expected message  ...");
		String confirmMsg = rp.getConfirmationMessage();
		if(confirmMsg.equals("Your Account Has Been Created!") )
		{
			Assert.assertTrue(true);
		}
		else 
		{
			logger.error("Test Failed.....");
			logger.debug("Debug logs....");
			Assert.assertFalse(false);
		}
		
		}
		catch(Exception e) {
			
			Assert.fail();
		}

		logger.info("****** Finishing TC001_AccountRegistrationTest ******");
	}

	

}
