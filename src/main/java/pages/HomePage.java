package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	private   WebDriverWait wait;

	    @FindBy(id = "nav-link-accountList")
	    private WebElement accountList;

	    @FindBy(xpath = "//span[@class='nav-action-inner'][1]")
	    private WebElement signIn;

	    @FindBy(id = "twotabsearchtextbox")
	    private WebElement searchProduct;
	    @FindBy(css = "span.a-color-state.a-text-bold")
	    private WebElement searchKeywordText;
	    @FindBy(id = "nav-cart-count")
	    private WebElement cartCount;

	   


	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }
	    public void hoverOverOnAccountList() {
	        wait.until(ExpectedConditions.visibilityOf(accountList));
	        new Actions(driver).moveToElement(accountList).perform();
	    }

	    public void clickTosignIn() {
	        wait.until(ExpectedConditions.elementToBeClickable(signIn)).click();
	    }
	    public void searchProduct(String productName) {
	        wait.until(ExpectedConditions.elementToBeClickable(searchProduct)).clear();
	        searchProduct.sendKeys(productName);
	        searchProduct.sendKeys(Keys.ENTER);
	        wait.until(ExpectedConditions.visibilityOf(searchKeywordText));
	    }
	    public boolean isSearchResultShown(String keyword) {
	        try {
	        	String txt = wait.until(ExpectedConditions.visibilityOf(searchKeywordText))
	                    .getText()
	                    .replace("\"", "")
	                    .trim();

	            return txt.toLowerCase().contains(keyword.toLowerCase());
	        } catch (Exception e) {
	            return false;
	        }
	    }
	    public int getCartCount() {
	    	try {
	    		String countText = wait.until(ExpectedConditions.visibilityOf(cartCount)).getText().trim();
	    		return Integer.parseInt(countText);
	    	}catch(Exception e) {
	    		return -1;
	    	}
	    }
	    public boolean isCartCountIncreased(int beforeCount) {
	    	try {
	    		return wait.until(d->getCartCount()>beforeCount);//WebDriver parameter d
	    	}catch (Exception e) {
	    		return false;
	    	}
	    }
	    public boolean waitForCartCountToIncrease(int before, int seconds) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
	        try {
	            return wait.until(d -> getCartCount() > before);
	        } catch (TimeoutException e) {
	            return false;
	        }
	    }


	}