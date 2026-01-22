package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import utils.DataProviderUtils;

public class GuestCheckoutTest extends BaseTest
{

	
	private void addOneItem(String productName) {
		HomePage homePage = new HomePage(getDriver());
		homePage.searchProduct(productName);
		
		SearchResultsPage results = new SearchResultsPage(getDriver());
		results.closeCookieBannerIfPresent();
		results.clickFirstProduct();
		results.switchToNewTabIfOpened();
		
		AddToCartPage cart = new AddToCartPage(getDriver());
		cart.selectSizeIfPresent();
		cart.clickAddToCart();
		
	}
	 @Test(groups = {"smoke", "regression"},dataProvider="productSmoke",dataProviderClass=DataProviderUtils.class)
	    public void verifyGuestCheckoutRedirectsToSignIn(String productName) {

	        addOneItem(productName);
	        
	        CartPage cartPage = new CartPage(getDriver());
	        cartPage.openCart();
	        cartPage.clickProceedToCheckout();

	        LoginPage loginPage = new LoginPage(getDriver());
	        Assert.assertTrue(
	                loginPage.isOnSignInPage(),
	                "Guest checkout did NOT redirect to Sign-in page! Title=" + getDriver().getTitle() + " | URL=" + getDriver().getCurrentUrl()
	        );
	    }
	}
