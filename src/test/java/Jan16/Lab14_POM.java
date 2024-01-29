package Jan16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Lab14_POM {

	WebDriver driver;
	By uname = By.name("firstname");
	By lname = By.name("lastname");
	By email = By.name("email");
	By pwd = By.name("password");
	
	 By rdobtn = By.id("input-newsletter-yes");
	 By check = By.xpath("//input[@type='checkbox']");
	 By btn = By.xpath("//button[@type='submit']");
	
	public Lab14_POM(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}

	public void enterfirstname(String firstname1) {
		driver.findElement(uname).sendKeys(firstname1);
	}
	
	public void enterlastname(String enterlastname1) {
		driver.findElement(lname).sendKeys(enterlastname1);
	}
	
	public void enteremail(String email1) {
		driver.findElement(email).sendKeys(email1);
	}
	
	public void enterpassword(String password1) {
		driver.findElement(pwd).sendKeys(password1);
	}

	public void enterradioButton() {
		driver.findElement(rdobtn).click();
	}
	
	public void click() {
		driver.findElement(check).click();
	}
	
	public void submit() {
		driver.findElement(btn).click();
	}	
}
