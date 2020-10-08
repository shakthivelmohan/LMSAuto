package seleniumDriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
	
public static WebDriver createDriverInstance(String BrowserName){
	WebDriver driver=null;
	if(BrowserName.toUpperCase().contains("CHROME")){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");  
		driver = new ChromeDriver();
		return driver;
	}
	
	if(BrowserName.toUpperCase().contains("FIREFOX")){
		driver = new FirefoxDriver();
        return driver;
	}
	
	return driver;
	}
}
