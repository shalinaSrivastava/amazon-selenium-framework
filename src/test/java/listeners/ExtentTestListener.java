package listeners;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import utils.ExtentManager;

public class ExtentTestListener implements ITestListener{
	private static final ExtentReports extent = ExtentManager.getExtent();
	private static final ThreadLocal<ExtentTest> tltest = new ThreadLocal<>();
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		tltest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result) {
		tltest.get().pass("PASSED");
	}
	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest test = tltest.get();
		test.fail(result.getThrowable());
		try {
			 WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
	            if (driver != null) {
	                String path = takeScreenshot(driver, result.getMethod().getMethodName());
	                test.addScreenCaptureFromPath(path);
	                test.info("URL: " + driver.getCurrentUrl());
	                test.info("Title: " + driver.getTitle());
	            }
	        } catch (Exception e) {
	            test.warning("Screenshot failed: " + e.getMessage());
	        }
	    
	}
	@Override
    public void onTestSkipped(ITestResult result) {
		tltest.get().skip("SKIPPED: " + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }


	private String takeScreenshot(WebDriver driver, String testName) throws Exception {
		new File("reports/screenshots").mkdirs();
		String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String dest = "reports/screenshots/" + testName + "_" + time + ".png";

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(src, new File(dest));
        return dest;
	}

}
