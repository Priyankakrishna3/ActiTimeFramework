package com.actitime.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.commonutils.WebDriverUtils;
import com.actitime.configuration.CommonSetup;
import com.actitime.pages.HomePage;

public class VerifyHomeTitleTest extends CommonSetup{
	
	
	@Test
	public void verifyTitle() throws InterruptedException, IOException
	{
		WebDriverUtils wt=new WebDriverUtils();
		HomePage hp=new HomePage(driver);
		Thread.sleep(4000);
		if(driver.getTitle().contains("actiTIME"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			wt.captureFailedScreenshots("VerifyHomeTitleTest", driver);
			Assert.assertTrue(false);
		}
			
		}
		
	}
	
	
	


