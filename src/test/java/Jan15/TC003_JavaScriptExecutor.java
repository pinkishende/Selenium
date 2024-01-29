package Jan15;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC003_JavaScriptExecutor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		//js.executeScript("alert('Hello');");
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		js.executeScript("window.scrollBy(0, 500)");
		System.out.println("Scroll page");
	}

}
