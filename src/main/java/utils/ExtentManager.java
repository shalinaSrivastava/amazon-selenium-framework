package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

	private static ExtentReports extent;
	public static ExtentReports getExtent() {
	    if (extent == null) {
	        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	        String reportPath = "reports/ExtentReport_" + time + ".html";

	        new File("reports").mkdirs();

	        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
	        spark.config().setReportName("Automation Test Report");
	        spark.config().setDocumentTitle("Amazon Test Execution Report");

	        extent = new ExtentReports();
	        extent.attachReporter(spark);  
	        extent.setSystemInfo("Project", "Amazon QA");
	        extent.setSystemInfo("Tester", "Shalina");
	    }
	    return extent;
	}


}
