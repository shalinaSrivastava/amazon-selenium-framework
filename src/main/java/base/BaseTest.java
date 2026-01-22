package base;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import org.testng.annotations.Optional;


public class BaseTest {

    protected WebDriver driver;
    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(@Optional("chrome") String browser) {

        if (browser == null) browser = "chrome";
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new RuntimeException("Unsupported browser: " + browser);
        }
        tlDriver.set(driver);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.ca/"); 
    

       
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = tlDriver.get();
        try {
            if (driver != null) {
                driver.quit(); 
            }
        } finally {
            tlDriver.remove();  
        }
    }


    public WebDriver getDriver() {
     
    	 return tlDriver.get();
    }
    
    
}

