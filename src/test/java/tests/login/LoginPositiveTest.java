package tests.login;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.DataProviderUtils;

public class LoginPositiveTest extends BaseTest{
	@Test(dataProvider="cridential",dataProviderClass=DataProviderUtils.class)
	public void verifyLoginWithValidCredentials(String emailId,String password) {

		LoginPage loginPage = new LoginPage(getDriver());
		loginPage.enterEmailId(emailId);
		loginPage.continueToSignIn();
		loginPage.enterPassword(password);
		loginPage.clickOnSignIn();
	}


}
