package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test(dataProvider="NewCustomer")
	public void addNewCustomer(String cname,String cgender,String cday,String cmonth,String cyear,String caddress
,String city,String state,String pinno,String telNo,String emailId) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust=new AddCustomerPage(driver);
		
		addcust.clickNewCustomer();
		
		logger.info("providing customer details....");
		
		addcust.customerName(cname);
		addcust.custGender(cgender);
		addcust.custDOB(cday,cmonth,cyear);
		addcust.custAddress(caddress);
		addcust.custcity(city);
		addcust.custstate(state);
		addcust.custpinno(pinno);
		addcust.custtelephoneno(telNo);
		addcust.custemailid(emailId);
		addcust.custsubmit();
		Thread.sleep(2000);
		
		/*addcust.customerName("Pavan");
		addcust.custGender("male");
		
		addcust.custDOB("10","15","1985");
		Thread.sleep(5000);
		addcust.custAddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		//addcust.custpassword("abcdef");
		addcust.custsubmit();*/
		
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
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	@DataProvider(name="NewCustomer")
	String [][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\NewCustomer.xlsx";
		
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