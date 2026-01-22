package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
	private WebDriver driver;
	private WebDriverWait wait;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15));
		PageFactory.initElements(driver,this);
	}  
	    
	    @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	private WebElement signInHeader;
	    @FindBy(xpath = "//h1[contains(text(),'Secure checkout')]")
	    private WebElement checkoutStepText;
	    @FindBy(id = "ap_email")
	private WebElement emailField;
	public boolean isOnGuestCheckOutPage() {
		try {
			return wait.until(ExpectedConditions.visibilityOf(signInHeader)).isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public boolean isEmailFieldDisplayed() {
		try {
			  return wait.until(ExpectedConditions.visibilityOf(emailField)).isDisplayed();
		}catch(Exception e) {
		return false;
		
	}
	

}
	 public boolean isOnCheckoutStepPage() {
	        try {
	            return wait.until(ExpectedConditions.visibilityOf(checkoutStepText)).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
}
