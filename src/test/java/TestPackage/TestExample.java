  package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExample extends DriverInstance{
	@Test(dataProvider = "data")
	public void login(String user,String pass) {
	
		driver.get("https://www.saucedemo.com/v1/index.html");
		WebElement userName=driver.findElement(By.id("user-name"));
		userName.sendKeys(user);
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys(pass);
		WebElement submit= driver.findElement(By.id("login-button"));
		submit.click();
	String expected = "https://www.saucedemo.com/v1/inventory.html";
	String actual = driver.getCurrentUrl();
		Assert.assertEquals(expected, actual);
	}
	@DataProvider
	public Object[][] data(){
		Object[][] userdetails= {{"standard_user","secret_sauce"}
,{"locked_out_user","secret_sauce"},{"problem_user","secret_sauce"},{"performance_glitch_user","secret_sauce"}};
		return userdetails;
	}

}
