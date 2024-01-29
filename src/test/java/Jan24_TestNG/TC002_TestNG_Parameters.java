package Jan24_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC002_TestNG_Parameters {
		WebDriver driver;
	@Parameters("Browser")
	@Test//(groups = {"sanity"})
	
	public void test1(String browser) {
		System.out.println("The browser is:"+browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://www.google.com/");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get("https://www.google.com/");
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get("https://www.google.com/");
		}
		
		else
		{
			System.out.println("The browser is not matched");
		}
	}
}
