package automationcore;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenshotUtility;

public class Base {
	Properties prop;
	public WebDriver driver;
	FileInputStream f;
	@BeforeMethod(alwaysRun=true)
	@Parameters("browsers")
		
		public void initialiseBrowser(String browsers) throws Exception
		
		{
		prop=new Properties();
		f=new FileInputStream(Constant.configfile);
		prop.load(f);
		if(browsers.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browsers.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(browsers.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new Exception("invalidbrowser");
		}
		
			
			
			driver.get(prop.getProperty("url"));		
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit wait
		}
	@AfterMethod(alwaysRun=true)
	 public void driverQuit(ITestResult iTestResult) throws IOException { 
		  
 		if (iTestResult.getStatus() == ITestResult.FAILURE) { 
  
 			ScreenshotUtility screenShot = new ScreenshotUtility(); 
 			screenShot.getScreenshot(driver, iTestResult.getName()); 
 		} 
 		//driver.quit(); 
  
 	}

	}






