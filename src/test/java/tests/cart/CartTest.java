package tests.cart;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AddToCartPage;
import pages.CartPage;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.DataProviderUtils;

public class CartTest extends BaseTest{
	 @Test(groups = {"regression"},dataProvider="productSmoke",dataProviderClass=DataProviderUtils.class)
	    public void cart(String productName) {
		 
		    addOneItem(productName);
		    
		    CartPage cartPage = new CartPage(getDriver());
		    cartPage.openCart();
		    Assert.assertTrue(cartPage.verifyItemInCart(), "Item not visible in cart");


	 }
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
		 Assert.assertTrue(cart.isItemAddedMessageDisplayed(), "Item not added to cart");
		 

	 }

}
