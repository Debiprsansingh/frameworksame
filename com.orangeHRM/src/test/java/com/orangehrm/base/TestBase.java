package com.orangehrm.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.ClickAction;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.utilities.ExcelReader;

import bsh.org.objectweb.asm.Type;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties config=new Properties();
	public static Properties or=new Properties();
	public static FileInputStream fis;
	public static Logger Log= Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel=new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\resources\\excel\\testdata.xlsx");
	
	// new push
	
	
	
	
	
	

	@BeforeSuite
	public void setUp()
	{
		if(driver==null) 
		{
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				Log.debug("config file loded");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			 try {
				fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				try {
					or.load(fis);
					Log.debug("OR file loded");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			//	if(config.getProperty("browser").equals("firefox"))
				//{
					//System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
					//driver=new FirefoxDriver();
			//	}
				 if(config.getProperty("browser").equals("chrome"))
				{
					System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\chromedriver.exe");
					driver=new ChromeDriver();
					Log.debug("chrome launched");
				}
				else if(config.getProperty("browser").equals("ie"))
				{
					System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\IEDriverServer.exe");
					driver=new InternetExplorerDriver();
					Log.debug("IE launched");
				}
				driver.get(config.getProperty("testurl"));
				Log.debug("Navigated to test"+config.getProperty("testurl"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				}
				}
	public boolean isElementPresent(By by)
	{
		try
		{
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e )
		{
			return false;
		}
	}
	public void Type(String locators, String value )
	{
		if(locators.endsWith("_xpath")){
			driver.findElement(By.xpath(or.getProperty(locators))).sendKeys(value);
		}
	}
	public void click(String locators)
	{
		driver.findElement(By.xpath(or.getProperty(locators))).click();
	}
	
	@AfterSuite
	public void tearDown()
	{
		
			driver.quit();
		Log.debug("test execution completed ");

	}
	
	

}
