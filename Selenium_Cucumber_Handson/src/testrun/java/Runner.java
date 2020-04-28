import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		//features="Feature",
		features="C:\\Users\\manoj\\workspace\\Qspider\\Selenium_Cucumber_Handson\\Feature\\newtours.feature",
		glue={"com/org/implementation"},
		plugin={"html:target/cucumber-html-report"},
		monochrome=true,
		strict=true,
		dryRun=false
		)

public class Runner 
{
	//table/tbody/tr[1]/td[2]/b/font
}
