package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();

        if (driver == null) {
            System.out.println("Driver is NULL. Screenshot not captured for: " + result.getMethod().getMethodName());
            return;
        }

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String folder = "C:\\Users\\sharm\\eclipse-workspace\\Project1\\reports\\screenshots\\failed\\";
        new File(folder).mkdirs();

        String fileName = result.getMethod().getMethodName() + "_"
                + new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss").format(new Date())
                + ".png";

        try {
            FileHandler.copy(src, new File(folder + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
