package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "E:\\My Workspace\\Cucumber_pract_java\\src\\test\\java\\Feature",
		glue={"Steps_Definition"},
		monochrome=true,
		format={"pretty"}
		)
		
public class testRunner 
{

}
