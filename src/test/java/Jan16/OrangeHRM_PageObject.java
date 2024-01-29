//creating pom file

package Jan16;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class OrangeHRM_PageObject {
	
	WebDriver driver;
	By uname = By.name("username");
	By Pword = By.name("password");
	By loginbutton = By.xpath("//button[@type='submit']");
	
	public OrangeHRM_PageObject(WebDriver driver2)
	{
		this.driver=driver2;
	}
	
	public void enterusername(String username1)
	{
		driver.findElement(uname).sendKeys(username1);
	}
	
	public void enterpassword(String password1)
	{
		driver.findElement(Pword).sendKeys(password1);
	}
	
	public void clicklogin()
	{
		driver.findElement(loginbutton).click();
	}
}
