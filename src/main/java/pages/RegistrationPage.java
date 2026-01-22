package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
	private   WebDriver driver;
	private WebDriverWait wait;

	    @FindBy(id="ap_customer_name")
	    private WebElement customerName;

	    @FindBy(id="ap_email")
	    private WebElement email;
	    @FindBy(id="ap_password")
	    private WebElement password;
	    @FindBy(id="ap_password_check")
	    private WebElement passwordCheck;
	    @FindBy(id="auth-continue")
	    private WebElement  continueBtn;

	    public RegistrationPage(WebDriver driver) {
	        this.driver = driver;
	        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	        PageFactory.initElements(driver, this);
	    }
	    public void enterCustomerName(String name) {
	    	
	        customerName.sendKeys(name);
	    }

	    public void enterEmail(String emailId) {
	        email.sendKeys(emailId);
	    }

	    public void enterNewPassword(String pswd) {
	        password.sendKeys(pswd);
	    }

	    public void enterNewPasswordCheck(String pswdCheck) {
	        passwordCheck.sendKeys(pswdCheck);
	    }

	    public void clickContinue() {
	        continueBtn.click();
	    }
	}