package steps;

import java.rmi.Remote;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.github.dockerjava.api.model.Driver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;


public class BookCartSteps extends DriverInstance {
	
	int currentCartValue=0;
	int valueAfterClick=0;
@Given("i want to navigate to website")
public void iWantToNavigateToWebsite() {
	driver.get("https://bookcart.azurewebsites.net/");
}
@Given("enter username as {string} and password as {string}")
public void enterUsernameAsAndPasswordAs(String username, String pass) throws InterruptedException {
	WebElement loginBtn=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='mat-button-wrapper' and text()='Login']")));
	loginBtn.click();
	WebElement user= driver.findElement(By.id("mat-input-0"));
	user.sendKeys(username);
	Thread.sleep(3000);
	WebElement password= driver.findElement(By.id("mat-input-1"));
	password.sendKeys(pass);
	Thread.sleep(5000);
}
@Then("click the login button and validate the outcomes")
public void clickTheLoginButtonAndValidateTheOutcomes() throws InterruptedException {
    WebElement login=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-card-actions[contains(@class,'mat-card-actions')]//span[text()='Login']")));
    login.click();
    Thread.sleep(3000);
    String actual =driver.getCurrentUrl();
    String expected="https://bookcart.azurewebsites.net/login";
//    Assert.assertNotSame(actual, expected);
//    System.out.println("error");
}
@Then("after the login search the {string} and click the first book")
public void afterTheLoginSearchTheAndClickTheFirstBook(String book)  throws InterruptedException {
	 WebElement search =driver.findElement(By.xpath("//input[@type='search']"));
	    search.sendKeys(book);
	    Thread.sleep(2000);
	    WebElement option=driver.findElement(By.xpath("(//div[@id='mat-autocomplete-0']//mat-option)[1]"));
	    option.click();}

@Then("check the cart and get title")
public void checkTheCartAndGetTitle() throws InterruptedException {
	WebElement cart=driver.findElement(By.id("mat-badge-content-0"));
	currentCartValue=Integer.valueOf(cart.getText());
	System.out.println("currentCartValue"+currentCartValue);
}
@And("add the book to the cart")
public void addTheBookToTheCart() throws InterruptedException {
	WebElement addtocart=driver.findElement(By.xpath("//button[@color='primary']"));
	addtocart.click();
	Thread.sleep(2000);
	WebElement cart=driver.findElement(By.id("mat-badge-content-0"));
	valueAfterClick=Integer.valueOf(cart.getText());
	System.out.println("valueAfterClick"+valueAfterClick);
	
}
@Then("logout from the website")
public void logoutFromTheWebsite() {
	WebElement order=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//mat-icon[text()='arrow_drop_down']")));
	order.click();
	WebElement logout=driver.findElement(By.xpath("(//button[contains(@class,'mat-focus-indicator mat-menu-item')])[2]"));
	logout.click();
	System.out.println("logout");
	
	
	
   
}
}
