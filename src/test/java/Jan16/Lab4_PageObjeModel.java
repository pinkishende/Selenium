package Jan16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class Lab4_PageObjeModel {
		
		public static void main(String[] args) throws Exception {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.opencart.com/");
			
			/*
			 // for page object model
			Lab4_POM obj = new Lab4_POM(driver);
			obj.desktop();
			obj.mac();
			obj.sort(1);
			obj.search();
			obj.search2("Mobile");
			obj.tick();
			obj.searchbutton();
*/
			// for page factory
			Lab4_PageFactory obj = PageFactory.initElements(driver, Lab4_PageFactory.class);
				obj.desktop();
				obj.mac();
				obj.sort(1);
				obj.search();
				obj.search2("Mobile");
				obj.tick();
				obj.searchbutton();	
	}

}
