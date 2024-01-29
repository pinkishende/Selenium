package Case1_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Luma_POM_File {

WebDriver driver;
	
	By fname = By.name("firstname");
	By lname = By.name("lastname");
	By email = By.name("email");
	By pword = By.name("password");
	By pword1 = By.name("password_confirmation");
	By loginbtn = By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button");
	By dashboard = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");
	

	public Luma_POM_File(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}
	public boolean verifyusername()
	{
		boolean isusername_displayed=driver.findElement(lname).isDisplayed();
		return isusername_displayed;
	}
	public boolean verifypassword()
	{
		boolean ispassword_displayed=driver.findElement(pword).isDisplayed();
		return ispassword_displayed;
	}
	
	public void enterfname(String userfname) {
		driver.findElement(fname).sendKeys(userfname);
	}
	
	public void enterlname(String userlname) {
		driver.findElement(lname).sendKeys(userlname);
	}
	
	public void enteremail(String email1) {
		driver.findElement(email).sendKeys(email1);
	}
	
	public void enterpword(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(pword).sendKeys(password);
	}
	public void confirmpass(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(pword1).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(loginbtn).click();
	}
	
	public boolean verifylogin()
	{boolean isdashboard_displayed;
		try
		{
		 isdashboard_displayed=driver.findElement(dashboard).isDisplayed();
		}
		catch(Exception e)
		{
			isdashboard_displayed=false;
		}
		
		return isdashboard_displayed;
	}
}
