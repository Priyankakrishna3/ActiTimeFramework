package com.actitime.testscripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest   {
	
	@Test
	public void loginTest() throws IOException, InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver=new FirefoxDriver();	
		LoginPage lp=new LoginPage(driver);
		WebDriverUtils utils=new WebDriverUtils();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.actitime.com/login.do");
		String user=utils.getDataFromProperties("username");
		String pass=utils.getDataFromProperties("password");
		lp.loginOperation(user, pass);
		Thread.sleep(5000);
		if(driver.getTitle().contains("actiTIME"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
			
		}
		
		
		
		
	}
	

}
