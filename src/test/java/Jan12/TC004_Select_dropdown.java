package Jan12;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC004_Select_dropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.findElement(By.linkText("Desktops")).click();
		driver.findElement(By.linkText("Mac (1)")).click();
		Select sl = new Select(driver.findElement(By.id("input-sort")));
		
		List<WebElement> l1 = sl.getOptions();//used to given link all options displayed
		for(int i=0; i<l1.size(); i++)
		{
			System.out.println(l1.get(i).getText());
		}
		sl.selectByIndex(5);
			
	}
}
