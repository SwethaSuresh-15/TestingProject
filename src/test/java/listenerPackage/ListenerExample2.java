package listenerPackage;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListenerExample2 implements ITestListener{
public  void onTestStart(ITestResult result) {
	
    System.out.println("on test start");
  }
public void onTestSuccess(ITestResult result) {
	System.out.println("result.getName()"+result.getName());
	System.out.println(result.SUCCESS);
	test.pass(result.getName()+"passed");
   System.out.println("on test sucess");
  }
public void onTestFailure(ITestResult result) {
    System.out.println("on test failure");
  }
public void onStart(ITestContext context) {
	WebDriverManager.chromedriver().setup();
	RemoteWebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	System.out.print("on start");
	htmlreport=new ExtentSparkReporter("test-output/ExtentReport.html");
	
	
	
  }
public void onFinish(ITestContext context) {
   System.out.println("finish");
  }


}
