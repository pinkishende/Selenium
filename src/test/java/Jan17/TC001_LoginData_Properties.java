package Jan17;

import java.io.File;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import Jan16.OrangeHRM_PageObject;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TC001_LoginData_Properties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		/* 
		// code for creating properties file and access it.
		InputStream input = new FileInputStream("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\Logindata.properties");
		
		Properties prob = new Properties();
		prob.load(input);
		String url = prob.getProperty("url");
		System.out.println("The url is:" +url);
		
		File f1 = new File("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\InputData.xlsx");
		FileInputStream fis = new FileInputStream(f1);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(1);
		
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:" +rowcount);
		String[][] data = new String[3][2];
		
		for(int i=0; i<rowcount; i++)
		{
			data[i][0]=sheet.getRow(i).getCell(0).getStringCellValue();
			data[i][1]=sheet.getRow(i).getCell(1).getStringCellValue();
			String uname = data[i][0];
			String pword = data[i][1];
			
			System.out.println("Username:" +uname);
			System.out.println("Password:" +pword);
			*/
		
		//code for creating xml file and access it.
		
			File xmlfile = new File("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\LoginData.xml"); 
			DocumentBuilderFactory DBFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dbuilder = DBFactory.newDocumentBuilder();
			Document doc = dbuilder.parse(xmlfile);
			NodeList nl = doc.getChildNodes();
			Node n = nl.item(0);
			
			Element ele = (Element)n;
			String url= ele.getElementsByTagName("url").item(0).getTextContent();
			String username= ele.getElementsByTagName("username").item(0).getTextContent();
			String password= ele.getElementsByTagName("password").item(0).getTextContent();
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			System.out.println("Username: "+username);
			System.out.println("Password: "+password);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			OrangeHRM_PageObject obj = new OrangeHRM_PageObject(driver);
			obj.enterusername(username);
			obj.enterpassword(password);
			obj.clicklogin();
			driver.quit();
		}
	}
