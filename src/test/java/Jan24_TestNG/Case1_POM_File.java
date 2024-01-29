package Jan24_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Case1_POM_File {
	WebDriver driver;
	
	By createacc = By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[2]/div[2]/div/div/a");
	By firstname = By.name("firstname");
	By lastname = By.name("lastname");
	By email = By.name("email");
	By password = By.name("password");
	By cpassword = By.name("password_confirmation");
	By createaccclick = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button/span");
	
	
	public Case1_POM_File(WebDriver driver2) {
		this.driver=driver2;
	}
	
	public void createaccountclick() {
		driver.findElement(createacc).click();
	}
	
	public void firstname(String fname) {
		driver.findElement(firstname).sendKeys(fname);
	}
	
	public void lastname(String lname) {
		driver.findElement(lastname).sendKeys(lname);
	}
	
	public void email(String emali1) {
		driver.findElement(email).sendKeys(emali1);;
	}
	
	
	public void password(String pwd) {
		driver.findElement(password).sendKeys(pwd);;
	}
	
	public void cpassword(String cpwd) {
		driver.findElement(cpassword).sendKeys(cpwd);
	}
	

	public void clickcreate() {
		driver.findElement(createaccclick).click();
	}
	
}

