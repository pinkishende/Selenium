package Jan25_Cucumber;
// step defination file
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_Login
{
	WebDriver driver;
	@Given("Launch the chrome browser")
	public void launch_the_chrome_browser() {
	    // Write code here that turns the phrase above into concrete actions
	   
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	
	}

	@When("User opens the url")
	public void user_opens_the_url() {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@And("User rnter the username and password")
	public void user_rnter_the_username_and_password() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   Thread.sleep(3000);
		driver.findElement(By.name("username")).sendKeys("Admin");
	   driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@And("Click on login button")
	public void click_on_login_butto() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button")).click();
	}

	@Then("Home page should be displayed")
	public void home_page_should_be_displayed() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
	
	    if(dashboard)
	    {
	    	System.out.println("Login Successful");
	    }
	    else
	    {
	    	System.out.println("Login not Successful");
	    }
	}

}
