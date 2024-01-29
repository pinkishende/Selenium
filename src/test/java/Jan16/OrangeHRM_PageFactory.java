package Jan16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrangeHRM_PageFactory {

	WebDriver driver;
	
	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement Pword;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;

	public void enterusername(String username1)
	{
		uname.sendKeys(username1);
	}
	
	public void enterpassword(String password1)
	{
		Pword.sendKeys(password1);
	}
	
	public void clicklogin()
	{
		loginbutton.click();
	}
}


