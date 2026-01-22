package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	private  WebDriver driver;
	private  WebDriverWait wait;

    @FindBy(xpath = "(//div[@data-component-type='s-search-result']//a[contains(@class,'a-link-normal')])[1]")
    private WebElement firstProduct;

    @FindBy(id = "sp-cc-accept")
    private WebElement acceptCookiesBtn;

    @FindBy(id = "sp-cc-rejectall-link")
    private WebElement rejectAllBtn;

    @FindBy(xpath = "//input[@aria-label='Close']")
    private WebElement closeBannerBtn;

    @FindBy(xpath = "(//button[contains(.,'Add to cart') or contains(.,'Add to Cart')])[1]")
    private WebElement firstAddToCartOnResults;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

    public void closeCookieBannerIfPresent() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesBtn)).click();
        } catch (Exception e1) {
            try {
                rejectAllBtn.click();
            } catch (Exception e2) {
                try {
                    closeBannerBtn.click();
                } catch (Exception e3) {
                    // banner not present
                }
            }
        }
    }

    public void clickFirstProduct() {
        closeCookieBannerIfPresent();
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }

    public void switchToNewTabIfOpened() {
        String current = driver.getWindowHandle();
        for (String win : driver.getWindowHandles()) {
            if (!win.equals(current)) {
                driver.switchTo().window(win);
                break;
            }
        }
    }
    public void clickAddToCartFromResults() {
        closeCookieBannerIfPresent(); // you already have this
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartOnResults)).click();
    }

}
