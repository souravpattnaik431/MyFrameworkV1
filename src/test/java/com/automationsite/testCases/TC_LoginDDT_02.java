package com.automationsite.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.automationsite.pageObjects.LoginPage;
import com.automationsite.utilities.XLUtils;

import junit.framework.Assert;

import com.automationsite.utilities.Wait;

public class TC_LoginDDT_02 extends BaseClass{
	
	@Test
	public void loginDDT(String user, String pwd)
	{			
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("user name provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		//Wait.waitTill(15);
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();//Main page
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			//Wait.waitTill(15);
			driver.switchTo().alert().accept();//close the Logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	//User Defined Method
	
	public boolean isAlertPresent()
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
	
		String path=System.getProperty("user.dir")+"src/test/java/com/automationsite/testData/LoginData.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=0;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
	return logindata;
		
	}

}
