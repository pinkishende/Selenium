package Jan12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_FindElements {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		System.out.println("Verify  My Account"+ driver.findElement(By.linkText("My Account")));
		
		System.out.println("Text of my account "+driver.findElement(By.linkText("My Account")).getText());

		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		//System.out.println("Text of Myaccount "+driver.findElement(By.linkText("My Account")).getText());
		Thread.sleep(5000);
		List<WebElement> li = driver.findElements(By.xpath("//input[@class='form-control']"));
       System.out.println(li.size());
       Actions act = new Actions(driver);
       act.sendKeys("nisha@yahoo.com");
       act.sendKeys(Keys.TAB);
       act.sendKeys("welcome");
       act.sendKeys(Keys.TAB);
       act.sendKeys(Keys.TAB);
       act.sendKeys(Keys.ENTER);
       act.sendKeys(Keys.ENTER);
       act.perform();
       
	}
}
