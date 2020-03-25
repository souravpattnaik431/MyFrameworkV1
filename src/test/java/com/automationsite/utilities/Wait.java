package com.automationsite.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	static WebDriver driver;
	
	

	public static void waitForElement(WebElement element,int waitTime,WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitTill(int waitImplicit)
	{
		try{
		driver.manage().timeouts().implicitlyWait(waitImplicit,TimeUnit.SECONDS);
		}
		catch(Exception e){
			System.out.println(e);
	
		}
	}

}