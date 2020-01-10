package com.orangehrm.testcase;



import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;

public class LoginTest extends TestBase {
	@Test
	public void adminlogin() throws InterruptedException
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		/*System.setProperty("org.uncommons.reportng.escape-output","false");
		Log.debug("Inside Login Test");
		driver.findElement(By.xpath(or.getProperty("bmlogin"))).sendKeys("Admin");
		driver.findElement(By.xpath(or.getProperty("password"))).sendKeys("admin123");
		driver.findElement(By.xpath(or.getProperty("loginbutton"))).click();
		
		
		Thread.sleep(3000);
		Log.debug("login successfully");
		Reporter.log("Login successfully");
		Reporter.log("<a href=\"C:\\Users\\new2\\Desktop\\selenium project\\download.jpg\">screenshot</a>");
		Assert.assertTrue(isElementPresent(By.xpath(or.getProperty("admin"))),"element Not present")*/
		Type("bmlogin_xpath", "Admin");
	}
	
	
	

}
