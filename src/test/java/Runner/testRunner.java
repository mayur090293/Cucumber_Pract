package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "D:\\My Workspace\\Cucumber_Pract\\src\\test\\java\\Feature\\newcompany.feature",
		glue={"Steps_Definition"},
		monochrome=true,
		format={"pretty"}
		)
		
public class testRunner 
{

}
