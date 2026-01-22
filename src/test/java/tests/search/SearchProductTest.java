package tests.search;


import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import utils.DataProviderUtils;

public class SearchProductTest extends BaseTest {
	
	@Test( groups = {"smoke", "regression"},dataProvider = "productSmoke",dataProviderClass = DataProviderUtils.class)
	public void verifySearchProduct(String productName) {
		HomePage homePage = new HomePage(getDriver());
		homePage.searchProduct(productName);
		Assert.assertTrue(
			    homePage.isSearchResultShown(productName),
			    "Search keyword not shown for: " + productName +
			    " | Title: " + getDriver().getTitle() +
			    " | URL: " + getDriver().getCurrentUrl()
			);
	}

}
