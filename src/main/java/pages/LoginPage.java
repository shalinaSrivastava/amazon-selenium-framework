package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private	WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='ap_email']")
	private WebElement  emailId;
	
	
	@FindBy(xpath="//input[@id='ap_password']")
	private WebElement  password;
	@FindBy(xpath="//span[@id='continue']")
	private WebElement continueButton;
	
	@FindBy(id="signInSubmit")
	private WebElement  signInButton;
	
	@FindBy(id="createAccountSubmit")
	private WebElement createAccount;
	 @FindBy(xpath = "//h1[contains(text(),'Sign in')]")
	 private WebElement signInHeader;
	
	
	public void enterEmailId(String id) {
		emailId.sendKeys(id);
	}
	public void enterPassword(String pswd) {
		password.sendKeys(pswd);

	}
	public void continueToSignIn() {
		continueButton.click();
	}
	public void clickOnSignIn() {
		signInButton.click();
	}
   public LoginPage(WebDriver driver) {
	    this.driver = driver;
	    wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	   PageFactory.initElements(driver, this);
	  
   }
   public boolean isOnSignInPage() {
	   try {
	   return wait.until(ExpectedConditions.visibilityOf(signInHeader)).isDisplayed();
	   }catch(Exception e) {
		   return false;
	   }
   }
   public void login(String email,String pswd) {
	   wait.until(ExpectedConditions.visibilityOf(emailId)).sendKeys(email);
	   continueButton.click();
	   
	   wait.until(ExpectedConditions.visibilityOf(password)).sendKeys(pswd);
	   signInButton.click();
   }
   public void clickOnCreateAccount() {
	   wait.until(ExpectedConditions.elementToBeClickable(createAccount)).click();
   }
  
}
