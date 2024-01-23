package hooks;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import steps.DriverInstance;

public class DemoHooks extends DriverInstance {
	@Before
	public  void beforeScenario(Scenario s)
	{
		WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
	driver.manage().window().maximize();
	wait= new WebDriverWait(driver, Duration.ofSeconds(20));
		System.out.println("beforeScenario");
	}
	@BeforeStep
	public  void beforeStep()
	{
		System.out.println("before step1");
	}
	@AfterStep
	public  void afterStep()
	{
		System.out.println("after step 1");
	}
	@After
	public  void afterScenario(Scenario s)
	{
		System.out.println("afterScenario"+s.getStatus());
		if(s.isFailed())
		{
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            s.attach(screenshot, "image/png", "screenshot");

		}
		driver.quit();
	}
}
