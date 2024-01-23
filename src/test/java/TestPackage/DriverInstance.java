package TestPackage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class DriverInstance {

	public static RemoteWebDriver driver;
	public static WebDriverWait wait;
	public static ExtentSparkReporter htmlReporter;
	public static ExtentReports  extent;
	public static ExtentTest test;
}
