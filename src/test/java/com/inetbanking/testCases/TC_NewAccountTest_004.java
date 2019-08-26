package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewAccountPage;
import com.inetbanking.utilities.XLUtils;

public class TC_NewAccountTest_004 extends BaseClass {

	
	@Test(dataProvider="NewAccount")
	public void loginDDT(String cusid,String accotype,String initDepo) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		
		Thread.sleep(3000);
		NewAccountPage nap=new NewAccountPage(driver);
		nap.clickNewAccount();
		logger.info("providing account details....");
		nap.customerId(cusid);
		nap.accountType(accotype);
		nap.initialDeposit(initDepo);
		nap.clickSubmit();
Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewAccount");
			Assert.assertTrue(false);
		}
			
	}
		
	
	
	
	
	
	
	@DataProvider(name="NewAccount")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\NewAccount.xlsx";
		
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}
				
		}
	return logindata;
	}
}
