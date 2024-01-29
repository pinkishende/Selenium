package Jan16;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Lab3_PageFactory {
	
	WebDriver driver;
	 
 	@FindBy(linkText="Desktops")
    WebElement desk;
 	
 	@FindBy(linkText="Mac (1)")
    WebElement mac;
 	
 	@FindBy(xpath="//*[@id=\"input-sort\"]")
    WebElement sorting;
 	
 	@FindBy(xpath="//*[@id=\"product-list\"]/div/form/div/div[2]/div[2]/button[1]")
    WebElement addcart;
 	
	public Lab3_PageFactory(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public void desktop() throws Exception {
		WebElement ele = desk;
	    Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	public void mac() {
		mac.click();
	}
	
	public void sort(int i) throws Exception {
		sorting.click();
		Select sort = new Select(sorting);
		Thread.sleep(3000);
		sort.selectByIndex(i);
	}
	
	public void clickaddcart() {
		addcart.click();
	}
	
}