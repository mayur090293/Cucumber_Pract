package Steps_Definition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class create_company 
{
  WebDriver driver;
  
  @Given("^User is on CRM login page$")
  public void User_is_on_CRM_login_page()
  {
	  System.setProperty("webdriver.chrome.driver","D:/My Workspace/Cucumber_Pract/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ui.freecrm.com/");
  }
  
  @When("^User enters CRM username and password$")
  public void User_enters_username_and_password(DataTable credentials)
  {
	List<List<String>> data = credentials.raw();
	driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
  }
  
  @Then("^User clicks on login button$")
  public void User_clicks_on_login_button()
  {
	  WebElement loginbutton=driver.findElement(By.xpath("//div[contains(@class,'fluid')]"));
	  JavascriptExecutor js= (JavascriptExecutor)driver;
	  js.executeScript("arguments[0].click();",loginbutton);
  }
  
  @Then("^User should land on home page$")
  public void User_should_land_on_home_page()
  {
	  String title=driver.getTitle();
	  Assert.assertEquals("Cogmento CRM", title);
  }
	
  @Then("^User clicks on Companies menu in left panel$")
  public void User_clicks_on_companies_menu_in_left_panel()
  {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[text()='Companies']")).click();
  }
  
  @Then("^User clicks New button$")
  public void User_clicks_New_button()
  {
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//button[@class='ui linkedin button']/i[@class='edit icon']")).click();
  }
  
  @Then("^User enters \"(.*)\"$")
  public void User_enters_Name(String name)
  {
	  driver.findElement(By.xpath("//div[@class='ui right corner labeled input']/input[@type='text' and @autocomplete=\"off\"]")).sendKeys(name);
  }
  
  @Then("^User changes access to private$")
  public void User_changes_access_to_private()
  {
	  driver.findElement(By.xpath("//button[@aria-pressed='false' and @class='ui small fluid positive toggle button']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  driver.findElement(By.xpath("//div[@class=\"ui fluid multiple selection dropdown\"]")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.findElement(By.xpath("//span[contains(text(),'Mayur Mahagaonkar')and@class='text']")).click();
	  
  }
  
  @Then("^User inputs mobile and home number$")
  public void User_inputs_mobile_and_home_number()
  {
	  driver.findElement(By.xpath("//div[@class='four fields']/div/input[@aria-autocomplete='list']")).sendKeys("India");
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  driver.findElement(By.xpath("//div[@class=\"visible menu transition\"]/div[2]")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  driver.findElement(By.xpath("//input[@name='value' and @placeholder='Number']")).sendKeys("9874589658");
  }
  
  @Then("^User selects Status$")
  public void User_selects_Status()
  {
	  driver.findElement(By.xpath("//div[@name='status']")).click();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	  driver.findElement(By.xpath("//div[@name='status']/div[2]/div[3]/span[contains(text(),'Active')]")).click();
  }
  
  @Then("^User uploads image$")
  public void User_uploads_image() throws IOException
  {
	  driver.findElement(By.xpath("//input[@name=\"image\"]")).click();
	  Runtime.getRuntime().exec("D:\\My Workspace\\Cucumber_Pract\\FileUpload.exe");
  }
  
  @Then("^User saves the company details$")
  public void User_saves_the_company_details()
  {
	  driver.findElement(By.xpath("//button[@class=\"ui linkedin button\"]"));
  }
}






























