package Jan16;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_OrangeHRM_Login {

	public static void main(String[] args) 	{	
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		//for page object model
		/* OrangeHRM_PageObject  pageobj = new OrangeHRM_PageObject(driver);
		pageobj.enterusername("Admin");
		pageobj.enterpassword("admin123");
		pageobj.clicklogin();
		*/
		
		//for page factory 
		OrangeHRM_PageFactory objFactory = PageFactory.initElements(driver, OrangeHRM_PageFactory.class);
		objFactory.enterusername("Admin");
		objFactory.enterpassword("admin123");
		objFactory.clicklogin();
		
		//driver.findElement(By.name("username")).sendKeys("Admin");
		//driver.findElement(By.name("password")).sendKeys("admin123");
		//driver.findElement(By.xpath("//button[@type='submit']")).click();
		System.out.println("Login OrangeHRM Page");
	}

}
