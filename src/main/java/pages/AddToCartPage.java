package pages;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class AddToCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(xpath =
            "(//div[@id='tp-inline-twister']//li[not(contains(@class,'swatchUnavailable'))]//span[contains(@class,'swatch-text')])[1]"
          + " | (//ul[contains(@class,'a-unordered-list') and contains(@class,'a-nostyle')][.//span[contains(.,'Size')]]//li[not(contains(@class,'swatchUnavailable'))]//span)[1]")
    private WebElement firstAvailableSize;

   
    @FindBy(xpath =
            "//*[self::h1 or self::span or self::div][contains(.,'Added to Cart') or contains(.,'Added to Basket') or contains(.,'Added to your Cart')]")
    private WebElement addedHeader;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
       this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
       

        PageFactory.initElements(driver, this);
    }
    
    private void safeClick(WebElement el) {
        wait.until(ExpectedConditions.visibilityOf(el));
        wait.until(ExpectedConditions.elementToBeClickable(el));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", el);
        try {
            el.click();
        } catch (ElementClickInterceptedException e) {
           
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
        }
    }


    public void selectSizeIfPresent() {
        try {
         
            safeClick(firstAvailableSize);
        } catch (Exception ignored) {
          
        }
    }

    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public boolean isItemAddedMessageDisplayed() {
        return wait.until(ExpectedConditions.urlContains("cart"));
    }



    }

    
