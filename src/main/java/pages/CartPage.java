package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	private WebDriver driver;
	private	WebDriverWait wait;
	
	@FindBy(id="nav-cart")
	private WebElement cartIcon;
	
	@FindBy(css = "span.sc-product-title")
	private WebElement cartItemTitle;

	
	@FindBy(name = "quantity")
	private WebElement quantityDropdown;
	
	@FindBy(name = "submit.delete")
	private WebElement deleteButton;

	
	 @FindBy(xpath = "//h1[contains(normalize-space(),'Your Amazon Cart is empty') or contains(normalize-space(),'Your cart is empty')]")
	private WebElement emptyCartMessage;
	 @FindBy(name = "proceedToRetailCheckout")
	private WebElement proceedToCheckoutButton;


	 public boolean verifyItemInCart() {
		 try {
			 return wait.until(ExpectedConditions.visibilityOf(cartItemTitle)).isDisplayed();
		 }catch(Exception e) {
			 return false;
		 }
	 }
	 public void updateQuantity(int qty) {
		 wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
		 Select select = new Select(quantityDropdown);
		 select.selectByValue(String.valueOf(qty));
		 wait.until(driver->select.getFirstSelectedOption().getDomAttribute("value").equals(String.valueOf(qty)));
	 }
	
   public CartPage(WebDriver driver) {
	   this.driver = driver;
	    this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    PageFactory.initElements(driver, this);
	   
   }
   public void openCart() {
	   wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
   }
   public void removeItem() {
	   wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
	   try {
		   wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
	   }catch(Exception e) {
		 
	   }
	   
   }
   public void clickProceedToCheckout() {
	   wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton)).click();
   }
   public boolean isCartEmpty() {
	    return driver.findElements(By.name("proceedToRetailCheckout")).isEmpty();
	}


   public int getSelectedQuantity() {
	   try {
		   wait.until(ExpectedConditions.elementToBeClickable(quantityDropdown));
		   Select select = new Select(quantityDropdown);
		   return Integer.parseInt(select.getFirstSelectedOption().getAttribute("value"));
	   }catch(Exception e) {
		   return -1;
	   }
   }

}
