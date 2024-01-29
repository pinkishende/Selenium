package Jan24_TestNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.openqa.selenium.Capabilities;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_NewTest {
	WebDriver driver;
	// @Parameters("Browser") not use here it used beforemehtod
	 
	  @Test(dataProvider = "dp")
 public void f(String uname, String pwd) throws Exception
   {	
	  long timestamp = new Date().getTime();
	  System.out.println("Time is:" +timestamp);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	// using for open browser below 3 lines
	   org.openqa.selenium.Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    System.out.println(browserName);
	  
	  OrangeHRM_POM obj = new OrangeHRM_POM(driver);
		String title= driver.getTitle();
		Assert.assertEquals(title, "OrangeHRM");
		
		ExtentReports extent = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter(timestamp +"24Jan2024.html");
		extent.attachReporter(spark);
		//ExtentTest test= extent.createTest("Verfiy the title of OrangeHRM");
		
		//for browser
		ExtentTest test= extent.createTest("Verfiy login" +browserName);
		
		if(title.equals("orangeHRM"))
		{       //     change o here
			test.pass("OrangeHRM  title is displayed");
		}
		else {
			Thread.sleep(3000);
			File sfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dfile = new File("p1.png");
			FileUtils.copyFile(sfile, dfile);
			String path = dfile.getAbsolutePath();
			test.fail("OrangeHRM  title is not displayed"
					,MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			test.addScreenCaptureFromPath(path);
		}
		
		//verify username
		if(obj.verifyusername()) {
			test.pass("username is displayed");
		}
		else {
			Thread.sleep(3000);
			File sfile1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dfile1 = new File("p2.png");
			FileUtils.copyFile(sfile1, dfile1);
			String path1 = dfile1.getAbsolutePath();
			test.fail("username is not displayed",
					MediaEntityBuilder.createScreenCaptureFromPath(path1).build());
					test.addScreenCaptureFromPath(path1);
		}
		
		//verify password
		if(obj.verifyusername()) {
			test.pass("password is displayed");
		}
		else {
			Thread.sleep(3000);
			File sfile2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dfile2 = new File("p3.png");
			FileUtils.copyFile(sfile2, dfile2);
			String path2 = dfile2.getAbsolutePath();
			test.fail("password is not displayed"
					,MediaEntityBuilder.createScreenCaptureFromPath(path2).build());
			test.addScreenCaptureFromPath(path2);
		}
		
		// verify login button
		if(obj.verifylogin()) {
			test.pass("login is displayed");
		}
		else {
			Thread.sleep(3000);
			File sfile3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dfile3 = new File("p4.png");
			FileUtils.copyFile(sfile3, dfile3);
			String path3 = dfile3.getAbsolutePath();
			test.fail("login is not displayed"
					,MediaEntityBuilder.createScreenCaptureFromPath(path3).build());
			test.addScreenCaptureFromPath(path3);
		}
		
		extent.flush(); // we used upper data to save the flush
		
		obj.enterusername(uname);
		obj.enterpassword(pwd);
		obj.clicklogin();
		
		driver.findElement(By.tagName("button")).click();
	    boolean dashboard = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed();
	    //assertEquals(dashboard, true);	
  }
  
 @Parameters("Browser")// using for open browser
  @BeforeMethod
  public void beforeMethod(String browser) throws Exception {
	  
	 System.out.println("This is before method");
	 InputStream input1 = new FileInputStream("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\Logindata.properties");
		Properties prob = new Properties();
		prob.load(input1);
		String url = prob.getProperty("url");
		System.out.println("The URL is:" + url);
		
		
		// using for open browser
		 // used for parallel tabs opened
		System.out.println("The Browser is:" + browser);
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//driver.get("https://www.google.com/");
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			//driver.get("https://www.google.com/");
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.get("https://www.google.com/");
		}
		
		else
		{
			System.out.println("The browser is not matched");
		}
		
	
		
		WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		driver.get(url);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10))
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("This is after method");
	 // driver.quit();
  }
  
  @DataProvider
  public Object[][] dp() throws Exception {
	  File f1 = new File("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\InputData.xlsx");
      
      FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row Count: "+rowCount);
		String[][] data = new String[2][2];
		
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

