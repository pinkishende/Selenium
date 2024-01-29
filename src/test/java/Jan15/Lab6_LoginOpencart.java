package Jan15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab6_LoginOpencart {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.name("email")).sendKeys("niki@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Niki@123");
		driver.findElement(By.tagName("button")).click();
		
		WebElement ele = driver.findElement(By.linkText("Components"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Monitors (2)")).click();
		
		WebElement showDropdown = driver.findElement(By.id("input-limit"));
		showDropdown.sendKeys("25");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		//js.executeScript("window.scrollBy(0, 800)");
		System.out.println("Scroll page");
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[1]/h4/a")).click();
		
		WebElement addToCartButton = driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[1]/form/div/div[2]/div[1]/h4/a"));
		addToCartButton.click();
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		driver.findElement(By.id("input-option-value-5")).click();
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		driver.findElement(By.id("input-option-value-10")).click();
		
		
		
	}
}
