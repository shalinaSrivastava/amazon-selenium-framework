package tests.checkout;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCartPage;
import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchResultsPage;
import utils.ConfigReader;
import utils.DataProviderUtils;

public class LoggedInCheckoutTest extends BaseTest {
	
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
	    public void verifyLoggedInUserCanProceedToCheckout(String productName) {

	        HomePage homePage = new HomePage(getDriver());
	        homePage.clickTosignIn();

	        LoginPage loginPage = new LoginPage(getDriver());
	        loginPage.login(
	                ConfigReader.get("amazon.email"),
	                ConfigReader.get("amazon.password")
	        );

	 
	        // Add item after login
	        addOneItem(productName);
      // Go to cart and proceed to checkout
      CartPage cartPage = new CartPage(getDriver());
      cartPage.openCart();
      cartPage.clickProceedToCheckout();

      // Assertion: verify checkout step page is shown (address/payment/review)
      CheckoutPage checkoutPage = new CheckoutPage(getDriver());
      Assert.assertTrue(
              checkoutPage.isOnCheckoutStepPage(),
              
              "Not on logged-in checkout step page! Title=" + getDriver().getTitle() + " | URL=" + getDriver().getCurrentUrl()
    	        );
    	    }
    	}

