package stepDefinition;

import junit.framework.Assert;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefinition {
	
	WebDriver driver;
	
	@Given ("^user is already on Login Page$")
	public void user_already_on_login_page(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Selenium Drivers\\chromedriver.exe"); 		
		driver=new ChromeDriver();
		driver.get("https://www.freecrm.com");
	}
	
	@When("^title of the page is FreeCRM$")
	public void title_of_login_page_is_free_CRM(){
		String title =driver.getTitle();
		System.out.println(title);
		Assert.assertEquals("Free CRM in the cloud software boosts sales",title);
	}
	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password() {
	    driver.findElement(By.name("username")).sendKeys("naveenk");
	    driver.findElement(By.name("password")).sendKeys("test@123");
	}
	
	@Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Exception {
		
		WebElement loginBtn=driver.findElement(By.xpath("//input[@value='Login']"));
		Thread.sleep(5000);
		loginBtn.click();
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("argument[0].click();",loginBtn);
	    
	}

	@Then("^user is on home page$")
	public void user_is_on_home_page(){
		
		String title=driver.getTitle();
		System.out.println("Home page title::" +title);
		Assert.assertEquals("CRMPRO", title);
			
	}
	
	@Then("^close the browser$")
	public void close_the_browser(){
		driver.quit();
	}
	

}
