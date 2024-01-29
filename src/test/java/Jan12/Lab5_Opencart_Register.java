package Jan12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab5_Opencart_Register {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='input-firstname']")).sendKeys("Nikita");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Yadav");
		driver.findElement(By.name("email")).sendKeys("niki@gmail.com");
		driver.findElement(By.name("password")).sendKeys("niki@123");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,350)", "");
		driver.findElement(By.xpath("//input[@id='input-newsletter-no']")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).submit();
		System.out.println("You are successfully Registered.");
		Thread.sleep(2000);
		driver.quit();
	}

}
