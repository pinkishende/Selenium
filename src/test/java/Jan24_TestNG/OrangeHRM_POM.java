package Jan24_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRM_POM {

	//creating pom file
		
		WebDriver driver;
		By uname = By.name("username");
		By Pword = By.name("password");
		By loginbutton = By.xpath("//button[@type='submit']");
		 By dashboard = By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]");
		
		public OrangeHRM_POM(WebDriver driver2)
		{
			this.driver=driver2;
		}
		
		public boolean verifyusername()
		{
			boolean isusername_displayed=driver.findElement(uname).isDisplayed();
			return isusername_displayed;
		}
		
		
		
		public void enterusername(String username1)
		{
			driver.findElement(uname).sendKeys(username1);
		}
		
		public boolean verifypassword()
		{
			boolean ispassword_displayed=driver.findElement(Pword).isDisplayed();
			return ispassword_displayed;
		}
		
		public void enterpassword(String password1)
		{
			driver.findElement(Pword).sendKeys(password1);
		}
		
		public boolean verifylogin() {
			boolean isdashboard_displayed;
			try {
			 isdashboard_displayed = driver.findElement(dashboard).isDisplayed();
			}
			catch(Exception e){
				isdashboard_displayed = false;
			}
			return isdashboard_displayed;
			
		}
		
		public void clicklogin()
		{
			driver.findElement(loginbutton).click();
		}
		
		
}
