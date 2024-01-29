package Jan24_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Case1_TestNG {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://magento.softwaretestingboard.com/customer/account/");
		Thread.sleep(5000);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a")).click();
		driver.findElement(By.name("firstname")).sendKeys("niki");
		driver.findElement(By.name("lastname")).sendKeys("yadav");
		driver.findElement(By.name("email")).sendKeys("niki12@gmail.com");
		driver.findElement(By.name("password")).sendKeys("niki@123");
		driver.findElement(By.name("password_confirmation")).sendKeys("niki@123");
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span")).click();
		

	}

}
