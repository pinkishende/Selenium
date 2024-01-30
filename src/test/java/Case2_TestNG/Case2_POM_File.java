package Case2_TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Case2_POM_File {
	
WebDriver driver;
	
	By signin = By.xpath("/html/body/div[2]/header/div[1]/div/ul/li[2]/a");
	By name = By.name("login[username]");
	By pword = By.name("login[password]");
	By loginbtn = By.xpath("//*[@id=\"send2\"]");
	
	By dashboard = By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[1]/h1/span");
	By menshop = By.xpath("//*[@id=\"ui-id-5\"]/span[2]");
	By addcart = By.xpath("//*[@id=\"maincontent\"]/div[3]/div[1]/div[4]/ol/li[2]/div/div/strong/a");
	By size = By.id("option-label-size-143-item-168");
	By clr = By.id("option-label-color-93-item-50");
	By addtocart = By.xpath("//*[@id=\"product-addtocart-button\"]");
	By cart = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a");
	By check = By.xpath("//*[@id='minicart-content-wrapper']/div[2]/div[1]/span[2]");

	public Case2_POM_File(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		this.driver=driver2;
	}
	public boolean verifyusername()
	{
		boolean isusername_displayed=driver.findElement(name).isDisplayed();
		return isusername_displayed;
	}
	public boolean verifypassword()
	{
		boolean ispassword_displayed=driver.findElement(pword).isDisplayed();
		return ispassword_displayed;
	}
	public void gotologin() {
		driver.findElement(signin).click();
	}
	
	public void entername(String userfname) {
		driver.findElement(name).sendKeys(userfname);
	}
	
	public void enterpword(String password) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(pword).sendKeys(password);
	}
	
	public void clicklogin() {
		driver.findElement(loginbtn).click();
	}
	
	public void menshopclick() {
		WebElement ele = driver.findElement(menshop);
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();
		driver.findElement(By.xpath("//*[@id=\"ui-id-17\"]/span[2]")).click();
		//driver.findElement(menshop);
	}
	
	public void addcart() {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(addcart).click();
	}
	
	public void selectsize() {
		driver.findElement(size).click();
	}
	public void selectclr() {
		driver.findElement(clr).click();
	}
	public void addtocart() {
		driver.findElement(addtocart).click();
	}
	public void checkcart() {
		driver.findElement(cart).click();
	}
	public boolean checkitem() {
		boolean isadded;
		try {
		isadded=driver.findElement(check).isDisplayed();
		}catch(Exception e){
			isadded = false;
		}
		return isadded;
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

