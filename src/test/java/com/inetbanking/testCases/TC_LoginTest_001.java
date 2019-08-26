package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("user id entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickSubmit();
		
		if(driver.getTitle().contains("GTPL Bankkk Manager HomePage")) {
			logger.info("title test passed");
			Assert.assertTrue(true, "title is matched");
		}else {
			captureScreen(driver,"loginTest");
			logger.info("title test is failed");
			Assert.assertTrue(false,"title is not matched");
			
		}
	}

}
