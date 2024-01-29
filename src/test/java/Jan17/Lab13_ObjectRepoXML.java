package Jan17;

import java.io.File;
import java.time.Duration;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;

import Jan16.OrangeHRM_PageObject;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Lab13_ObjectRepoXML {

	public static void main(String[] args) throws Exception 
	{
		File xmlfile = new File("C:\\Users\\pinki.shende\\eclipse-workspace\\Jan2024_Selenium\\src\\test\\java\\Jan17\\Lab13_ObjectRepo.xml");
        DocumentBuilderFactory DBFactory=DocumentBuilderFactory.newInstance();
        DocumentBuilder dbuilder=DBFactory.newDocumentBuilder();
        Document doc = dbuilder.parse(xmlfile);
        NodeList n1 =doc.getChildNodes();
        Node n =n1.item(0);
        Element ele=(Element)n;
        String url=ele.getElementsByTagName("url").item(0).getTextContent();
     
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		 // for filexml
		Lab13_ObjectRepoPOM obj = new Lab13_ObjectRepoPOM(driver);
		obj.desktop();
		obj.mac();
		obj.sort(1);
		obj.search();
		obj.search2("Mobile");
		obj.click();
		obj.searchbutton();
		driver.quit();
		}
		
	}



