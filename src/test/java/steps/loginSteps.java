package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginSteps {
	RemoteWebDriver driver;
	@Given("I want to navigate to website")
	public void iWantToNavigateToWebsite() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		
	}
	@Given("send keys to userName as {string} and password as {string}")
	public void sendKeysToUserNameAsAndPasswordAs(String user, String Password) {
		WebElement userName=driver.findElement(By.id("username"));
		userName.sendKeys(user);
		WebElement password= driver.findElement(By.id("password"));
		password.sendKeys(Password); 
	}

	
	@And("click the login button")
	public void clickTheLoginButton() {
		WebElement submit=driver.findElement(By.id("submit"));
		submit.click();
	}
	@Then("I validate the outcomes")
	public void iValidateTheOutcomes() {
		String expected="https://practicetestautomation.com/logged-in-successfully/";
		String actual=driver.getCurrentUrl();
		Assert.assertEquals(expected,actual);
		System.out.println("logged in succesfully");
	}
}
