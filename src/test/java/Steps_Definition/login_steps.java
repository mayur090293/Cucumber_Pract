package Steps_Definition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class login_steps 
{
	
    WebDriver driver;
    
	@Given("^User is on login page$")
	public void User_is_on_login_page()
	{
		System.setProperty("webdriver.chrome.driver","D:/My Workspace/Cucumber_Pract/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.freecrm.com/");
	}
	
	@When("^User enters \"(.*)\" and \"(.*)\"$")
	public void User_enter_username_and_password(String username, String password)
	{
		driver.findElement(By.name("email")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@Then("^Login button is clicked$")
	public void Login_button_is_clicked() 
	{
	    
		WebElement loginbutton=driver.findElement(By.xpath("//div[contains(@class,'fluid')]"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",loginbutton);
	}
	
	@Then("^User should be navigated to the home page$")
	public void User_should_be_navigated_to_the_home_page()
	{
	    String title=driver.getTitle();
		Assert.assertEquals("Cogmento CRM", title);
	}
	
	@Then("^Close browser instance$")
	public void Close_browser_instance()
	{
		
		driver.quit();
	}
}

