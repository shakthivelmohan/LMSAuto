package seleniumDriverFactory;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import seleniumDriverFactory.DriverFactory;

import dataDriven.xlActions;

public class DriverBaseClass {
	
	String filePath=System.getProperty("user.dir")+"\\src\\main\\resources";
	String fileName="TestData.xlsx";
	String sheetName="QA_Team";
	WebDriver driver; 
	public static ThreadLocal<WebDriver> Dr = new ThreadLocal<WebDriver>();
	
	@BeforeTest
	public void setPreCond() throws IOException{
		xlActions.readExcel(filePath, fileName, sheetName);
	}
	@BeforeMethod
	public void beforeMEthod(){
		
		driver = DriverFactory.createDriverInstance("Chrome");
		setDriver(driver);
	}
	
	public void setDriver(WebDriver driver){
		Dr.set(driver);
	}
	
	public WebDriver getDriver(){
		return Dr.get();
	}
	@AfterMethod
	public void quitDriver(){
		getDriver().close();
	}
}
