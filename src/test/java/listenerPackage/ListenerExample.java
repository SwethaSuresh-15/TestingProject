package listenerPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import TestPackage.DriverInstance;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerExample extends DriverInstance implements ITestListener {
	
	public void onStart(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("on starts");
		// Initialize ExtentReports and attach the HTML reporter
	    htmlReporter = new ExtentSparkReporter("test-output/ExtentReport.html");
	    extent = new ExtentReports();
	    extent.attachReporter(htmlReporter);
		
	   
	  }
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getMethod().getMethodName());
        test.info("Test started");
	    
		System.out.println("on test starts");
		
		
	  }
	public  void onTestSuccess(ITestResult result) {
		System.out.println("result.getName()"+result.getName());
		System.out.println(result.SUCCESS);
		test.pass(result.getName()+"passed");
		System.out.println("on Test Success");
//		driver.quit();
	}
	
public void onTestFailure(ITestResult result) {
	String screenshotAs = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
	test.addScreenCaptureFromBase64String(screenshotAs, "failedtest");

	//	try {
//		FileUtils.copyFile(screenshotAs ,
//		        new File("screenshot.png"));
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
	System.out.println(result.FAILURE);
	test.fail(result.getName()+"test failed");
	System.out.println("on Test Failure");
//	driver.quit();
}

public void onFinish(ITestContext context) {
	extent.flush();
	System.out.println("on finish");
	driver.quit();
  }
}
