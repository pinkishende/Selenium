package Jan17;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Lab13_ObjectRepoPOM 
{
	WebDriver driver;
	By desk = By.linkText("Desktops");
	By mac = By.linkText("Mac (1)");
	By sorting = By.xpath("//*[@id=\"input-sort\"]");

	By sbutton1 = By.xpath("//*[@id=\"search\"]/button");
	By searchbox = By.xpath("//*[@id=\"input-search\"]");
	By clickbox = By.xpath("//*[@id=\"input-description\"]");
	By submitbutton = By.xpath("//*[@id=\"button-search\"]");
	
	public Lab13_ObjectRepoPOM(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public void desktop() throws Exception {
		WebElement ele = driver.findElement(desk);
	    Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void mac() {
		driver.findElement(mac).click();
	}
	
	public void sort(int i) throws Exception {
		driver.findElement(sorting).click();
		Select sort = new Select(driver.findElement(sorting));
		Thread.sleep(3000);
		sort.selectByIndex(i);
	}
	
	public void search() {
		driver.findElement(sbutton1).click();
	}
	
	public void search2(String text) {
		driver.findElement(searchbox).sendKeys(text);
	}
	
	public void click() {
		driver.findElement(clickbox).click();
	}
	
	public void searchbutton() {
		driver.findElement(submitbutton).click();
	}
}

