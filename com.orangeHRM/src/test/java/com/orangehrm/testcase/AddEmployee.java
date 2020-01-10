package com.orangehrm.testcase;

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.orangehrm.base.TestBase;

public class AddEmployee extends TestBase {

	/*@Test
	public void clickAdminBtn() {
		driver.findElement(By.xpath(or.getProperty("admin"))).click();
		driver.findElement(By.xpath(or.getProperty("addBtn"))).click();
	}*/

	@Test(dataProvider = "getData")
	public void addEmployee(String empName, String userName, String passWord, String cnfrPswd){ 
		driver.findElement(By.xpath(or.getProperty("employeeName"))).sendKeys(empName);
		driver.findElement(By.xpath(or.getProperty("userName"))).sendKeys(userName);
		driver.findElement(By.xpath(or.getProperty("passWord"))).sendKeys(passWord);
		driver.findElement(By.xpath(or.getProperty("confirmPassword"))).sendKeys(cnfrPswd);
		driver.findElement(By.xpath(or.getProperty("saveBtn"))).click();
		Log.debug("employee added is unsuccessful");
		Reporter.log("employee added is unsuccessful");
	}

	@DataProvider(name = "data")
	public Object[][] getData() {
		String sheetName=" AddEmployee";
		 int rows=excel.getRowCount(sheetName);
		 int cols=excel.getColumnCount(sheetName);
		 System.out.println(cols);
		 Object[][] data =new Object[rows-1][cols];
		 for(int rowNum=2;rowNum<rows;rowNum++)
		 {
			 for (int colNum=0;colNum<cols;colNum++)
			 {
				 data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum);
			 }
		 }
		 
		 
		 
		 
		 
	
		
		return data;
		
	}
}
