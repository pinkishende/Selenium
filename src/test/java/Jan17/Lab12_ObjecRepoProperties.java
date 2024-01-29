package Jan17;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lab12_ObjecRepoProperties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		InputStream input1 = new FileInputStream("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\Lab12_ObjectRepo.properties");
		Properties prop = new Properties();
		prop.load(input1);
		String url = prop.getProperty("url");
		String prdt = prop.getProperty("product");
		System.out.println("The URL is: "+ url);
		System.out.println("The product is: "+ prdt);
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		
		Lab12_ObjectRepoPOM obj = new Lab12_ObjectRepoPOM(driver);
		obj.desktop();
		obj.mac();
		obj.sort(1);
		obj.search();
		obj.search2(prdt);
		obj.click();
		obj.searchbutton();
		driver.quit();
	}
}
