package Jan16;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab3_PageObjectModel {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
	/*
		WebElement ele = driver.findElement(By.linkText("Desktops"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.linkText("Mac (1)")).click();
		
		Select show = new Select(driver.findElement(By.id("input-sort")));
		show.selectByIndex(1);
				
		//For scrolling page
		Thread.sleep(2000);
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//*[@id=\"product-list\"]/div/form/div/div[2]/div[1]/h4/a")).click();
		//js.executeScript("window.scrollBy(0,100)");
		
		Thread.sleep(3000);
		// add to cart
		driver.findElement(By.id("button-cart")).click();
	*/
		//For page object model
		Lab3_POM obj=new Lab3_POM (driver);
		obj.clickOnDeskstops();
		obj.clickOnMac();
		obj.handledropdown();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800)");
		obj.clickonaddcart();
		 
		/*
		 // for page factory
		Lab3_PageFactory obj = PageFactory.initElements(driver, Lab3_PageFactory.class);
		obj.desktop();
		obj.mac();
		obj.sort(1);
			
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(3000);			
		obj.clickaddcart();
		*/
	}

}
