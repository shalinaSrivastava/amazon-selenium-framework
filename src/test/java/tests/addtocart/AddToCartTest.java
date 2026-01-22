package tests.addtocart;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.AddToCartPage;
import pages.HomePage;
import pages.SearchResultsPage;
import utils.DataProviderUtils;

public class AddToCartTest extends BaseTest {
	 HomePage homePage ;
	 int beforeCount=0;
    private void searchProduct(String productName) {
    	homePage = new HomePage(getDriver());
    	 beforeCount = homePage.getCartCount();
    	 homePage.searchProduct(productName);
    }
    @Test(groups={"smoke","regression"}, dataProvider ="productSmoke", dataProviderClass=DataProviderUtils.class)
    public void verifyAddToCartFromProductPage(String productName) {

        searchProduct(productName);

        SearchResultsPage results = new SearchResultsPage(getDriver());
        results.closeCookieBannerIfPresent();
        results.clickFirstProduct();
        results.switchToNewTabIfOpened();

        AddToCartPage cart = new AddToCartPage(getDriver());
        cart.selectSizeIfPresent();
        cart.clickAddToCart();

     
        homePage = new HomePage(getDriver());

      
        Assert.assertTrue(
                cart.isItemAddedMessageDisplayed(),
                "Added-to-cart confirmation message not shown! Title=" + getDriver().getTitle()
                        + " | URL=" + getDriver().getCurrentUrl()
        );

      
        Assert.assertTrue(
                homePage.waitForCartCountToIncrease(beforeCount, 12),
                "Cart count did not increase! Before=" + beforeCount
                        + " | After=" + homePage.getCartCount()
                        + " | Title=" + getDriver().getTitle()
                        + " | URL=" + getDriver().getCurrentUrl()
        );
    }
}
