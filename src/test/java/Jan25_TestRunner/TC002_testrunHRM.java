package Jan25_TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
		
@RunWith(Cucumber.class)
@CucumberOptions(features="Feature", // used here feature folder
glue= {"Jan25_Cucumber"},//used here package folder
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"})


public class TC002_testrunHRM {

}
