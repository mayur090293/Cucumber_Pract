package Steps_Definition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class create_company 
{
  WebDriver driver;
  
  @Given("^User is on login page$")
  public void User_is_on_login_page()
  {
    System.setProperty("WebDriver.chrome.driver", "E:/My Workspace/Cucumber_pract_java/Drivers/chromedriver.exe");
    driver.get("https://ui.freecrm.com/");
  }
  
  @Then("^User enters username and password$")
  public void User_enters_username_and_password(DataTable credentials)
  {
	List<List<String>> data = credentials.raw();
	driver.findElement(By.name("email")).sendKeys(data.get(0).get(0));
	driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
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
	
  @Then("^User clicks on Companies menu in left panel$")
  public void User_clicks_on_companies_menu_in_left_panel()
  {
	  driver.findElement(By.xpath("//span[text()='Companies']")).click();
  }
  
  @Then("^User clicks New button$")
  public void User_clicks_New_button()
  {
	  driver.findElement(By.xpath("//button[@class='ui linkedin button']/i[@class='download icon']")).click();
  }
  
  @Then("^User enters \"(.*)\"$")
  public void User_enters_Name(String name)
  {
	  driver.findElement(By.xpath("//div[@class='ui right corner labeled input']")).sendKeys(name);
  }
  
  @Then("^User changes access to private$")
  public void User_changes_access_to_private()
  {
	  driver.findElement(By.xpath("//button[@aria-pressed='false' and @class='ui small fluid positive toggle button']")).click();
      Select username=new Select(driver.findElement(By.xpath("//div[text()='Select users allowed access']")));
      username.selectByValue("06a5b4f1-ce87-45f9-a460-98194761af0f");
  }
  
  @Then("^User inputs mobile and home number$")
  public void User_inputs_mobile_and_home_number()
  {
	  Select country=new Select(driver.findElement(By.xpath("//div[@class='four fields']/div/input[@aria-autocomplete='list']")));
	  country.selectByVisibleText("India");
	  driver.findElement(By.xpath("//input[@name='value' and @placeholder='Number']")).sendKeys("9874589658");
  }
  
  @Then("^User selects Status$")
  public void User_selects_Status()
  {
	  
  }
}






























