package TestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestExample2 {
	@Test(dataProvider ="datas")
public void login(String user,String pass) {
	
	driver.get("https://practicetestautomation.com/practice-test-login/");
	WebElement userName=driver.findElement(By.id("username"));
	userName.sendKeys(user);
	WebElement password= driver.findElement(By.id("password"));
	password.sendKeys(pass);
	WebElement submit=driver.findElement(By.id("submit"));
	submit.click();
	String expected="https://practicetestautomation.com/logged-in-successfully/";
	String actual=driver.getCurrentUrl();
	Assert.assertEquals(expected,actual);
}@DataProvider
public Object[][] datas(){
	Object[][] userdetails= {{"student","Password123"},{"incorrectUser","Password123"},{"student","incorrectPassword"}};
	return userdetails;
}


}
