package com.orangehrm.testcase;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;
public class BtnForAddEmp extends TestBase{
@Test
public void clickAdminBtn() {
		driver.findElement(By.xpath(or.getProperty("admin"))).click();
		driver.findElement(By.xpath(or.getProperty("addBtn"))).click();
		Log.debug("login into homepage");
		Reporter.log("login into homepage");
	}

}
