package Jan16;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Lab3_POM {
	
	WebDriver driver;
	
	By desk =By.linkText("Desktops");
	
	By Mac1 = By.linkText("Mac (1)");
	
	By dropdown =By.xpath("//select[@id='input-sort']");
	
	By addcart=By.xpath("//*[@id=\"product-list\"]/div/form/div/div[2]/div[2]/button[1]");
	
	public Lab3_POM(WebDriver driver2) {
		this.driver =driver2;
	}

	public void clickOnDeskstops()
	{
		WebElement ele=driver.findElement(desk);
	Actions op= new Actions(driver);
	op.moveToElement(ele).perform();
	}
	
	public void clickOnMac()
{
		driver.findElement(Mac1).click();
}
	
	public void handledropdown() throws InterruptedException
	{
		Select drop=new Select(driver.findElement(dropdown));
		Thread.sleep(1000);
		drop.selectByIndex(1);
	}
	
	public void clickonaddcart() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.findElement(addcart).click();
	}	
}