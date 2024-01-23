package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DemoSteps {
	RemoteWebDriver driver;
	WebDriverWait wait;
	@Given("User navigate to website")
	public void userNavigateToWebsite() {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://www.saucedemo.com/");
	}
	@When("user enter username and password")
	public void userEnterUsernameAndPassword() {
	    WebElement user=driver.findElement(By.id("user-name"));
	    user.sendKeys("standard_user");
	    WebElement password=driver.findElement(By.id("password"));
	    password.sendKeys("secret_sauce");
	}
	@When("user enter username as {string} and password as {string}")
	public void userEnterUsernameAsAndPasswordAs(String username, String password) {
		 WebElement user=driver.findElement(By.id("user-name"));
		    user.sendKeys(username);
		    WebElement passwordElement=driver.findElement(By.id("password"));
		    passwordElement.sendKeys(password);
		}
	
	@When("user click the login button")
	public void userClickTheLoginButton() {
		WebElement loginBtn=driver.findElement(By.id("login-button"));
		loginBtn.click();
	    
	}
	@Then("user get successfully logged in")
	public void userGetSuccessfullyLoggedIn() {
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");
	    System.out.println("successfully logged in");
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    driver.quit();
	}
}
