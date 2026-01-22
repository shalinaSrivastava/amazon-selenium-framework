package tests.registration;
import org.testng.annotations.Test;


import base.BaseTest;
import pages.RegistrationPage;
import utils.DataProviderUtils;
public class RegistrationTest extends BaseTest{
	@Test(dataProvider="registrationData",dataProviderClass=DataProviderUtils.class)
	public void verifyRegistrationWithValidDetails(String name,String email,String newPassword,String checkPassword) {
		RegistrationPage regidtrationPage = new RegistrationPage(getDriver());
		regidtrationPage.enterCustomerName(name);
		regidtrationPage.enterEmail(email);
		regidtrationPage.enterNewPassword(newPassword);
		regidtrationPage.enterNewPasswordCheck(checkPassword);
		regidtrationPage.clickContinue();
		
	}
}
