package Jan22_TestNG;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_TestNG {
	WebDriver driver;
	
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws Exception {
	  
	 
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      Thread.sleep(3000);
      
      driver.findElement(By.name("username")).sendKeys(username);
      driver.findElement(By.name("password")).sendKeys(password);
      driver.findElement(By.tagName("button")).click();
      boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
      assertEquals(dashboard, true);
      
	 // System.out.println("This is the test");
  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  System.out.println("This is before method");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
  }


  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "Admin", "admin123" },
      new Object[] { "Niki", "niki123" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite");
  }

}
