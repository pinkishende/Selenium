

import org.testng.annotations.Test;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Jan16.OrangeHRM_PageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC002_NewTest {
	WebDriver driver;
  @Test(dataProvider = "dp")
  public void f(String username, String password) throws Exception 
  {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		OrangeHRM_PageObject obj = new OrangeHRM_PageObject(driver);
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
		obj.enterusername(username);
		obj.enterpassword(password);
		obj.clicklogin();
		boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]")).isDisplayed();
		System.out.println("Dashboard"+dashboard);
		assertEquals(dashboard, true);
  }
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  
	 System.out.println("This is before method");
	 InputStream input = new FileInputStream("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\Logindata.properties");
		
	 Properties prob = new Properties();
		prob.load(input);
		String url = prob.getProperty("url");
		System.out.println("The URL is:" + url);
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get(url);
		//Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
	  driver.quit();
  }
  
  @DataProvider
  public Object[][] dp() throws Exception {
	  File f1 = new File("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\LoginData.xml");
      FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count: "+rowCount);
		String[][] data = new String[3][2];
		
		for(int i=0;i<rowCount;i++) {
			data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			String uname = data[i][0];
			String pwd = data[i][1];
			System.out.println("Username: "+uname);
			System.out.println("Password: "+pwd);	
		}
		return data;
    };
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("This is after class");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("This is before test");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("This is after test");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("This is before suite");
  }
  

  @AfterSuite
  public void afterSuite() {
	  System.out.println("This is after suite");
  }

}