package testLms;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import dataDriven.xlActions;
import seleniumDriverFactory.DriverBaseClass;

public class NewTest extends DriverBaseClass {
  @Test(enabled = false)
  public void testRun() throws InterruptedException {
	System.out.println("Total Active Rows In Excel are "+xlActions.rowCount);  
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe");  
	WebDriver driver = new ChromeDriver();
  	driver.get("http://kedge.srinsofttech.com/#/kn-pages/auth/login");
  	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  	driver.manage().window().maximize();
  	//Thread.sleep(2000);
  	driver.findElement(By.id("mat-input-0")).sendKeys("SS269");
  	driver.findElement(By.id("mat-input-1")).sendKeys("sst123");
  	Thread.sleep(2000);
  	driver.findElement(By.xpath("html/body/app/vertical-layout-1/div/div/div/div/content/app-login/div/div[2]/div[1]/form/button")).click();
  	Thread.sleep(5000);
  	driver.findElement(By.xpath("//*[@id='container-1']/fuse-sidebar/navbar/navbar-vertical-style-1/div[2]/div[2]/fuse-navigation/div/fuse-nav-vertical-group/div[2]/fuse-nav-vertical-item[2]/a/span")).click();
  	Thread.sleep(5000);
  	java.util.List<WebElement> row = driver.findElements(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr"));
  	java.util.List<WebElement> col = driver.findElements(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr[1]/td"));
  	System.out.println(row.size());
  	System.out.println(col.size());
  	for(int i=1;i<row.size()+1;i++){
	String taskName=driver.findElement(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr["+i+"]/td[1]")).getText();
	System.out.println(taskName);
	if(taskName.contains("PRJ0012124")){
		System.out.println("Task name found on the row "+i);
		System.out.println("Project Found");
		for(int c=2;c<col.size()+1;c++){
			System.out.println("The Cell Count is "+c);
			WebElement hours=driver.findElement(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr["+i+"]/td["+c+"]/mat-form-field/div/div[1]/div[1]/input"));
			hours.click();
			hours.clear();
			hours.sendKeys("08:00");
			Thread.sleep(3000);
			WebElement hours1=driver.findElement(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr["+i+"]/td[2]/mat-form-field/div/div[1]/div[1]/input"));
			hours1.click();
			//driver.findElement(By.id("mat-input-8"));
		}
		break;
	}
			
  	}
  	driver.quit();
  }
  
  @Test
  public void submitTimesheet() throws InterruptedException{
	  System.out.println("Total Active Rows In Excel are "+xlActions.rowCount);
	  getDriver().get("http://kedge.srinsofttech.com/#/kn-pages/auth/login");
	  getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  getDriver().manage().window().maximize();
	  for(int row=1; row<xlActions.rowCount+1;row++){
		  xlActions.getDataFromCell(row, 0);
		  getDriver().findElement(By.id("mat-input-0")).sendKeys(xlActions.actData);
		  xlActions.getDataFromCell(row, 1);
		  getDriver().findElement(By.id("mat-input-1")).sendKeys(xlActions.actData);
		  Thread.sleep(2000);
		  getDriver().findElement(By.xpath("html/body/app/vertical-layout-1/div/div/div/div/content/app-login/div/div[2]/div[1]/form/button")).click();
		  Thread.sleep(5000);
		  getDriver().findElement(By.xpath("//*[@id='container-1']/fuse-sidebar/navbar/navbar-vertical-style-1/div[2]/div[2]/fuse-navigation/div/fuse-nav-vertical-group/div[2]/fuse-nav-vertical-item[2]/a/span")).click();
		  Thread.sleep(5000);
		  java.util.List<WebElement> rowNumber = getDriver().findElements(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr"));
		  java.util.List<WebElement> col = getDriver().findElements(By.xpath("//table[@class='mat-table timesheet-table']/tbody/tr[1]/td"));
		  System.out.println(rowNumber.size());
		  System.out.println(col.size());
	  }
  }
}
