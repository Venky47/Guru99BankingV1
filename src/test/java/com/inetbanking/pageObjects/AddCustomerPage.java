package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
public WebDriver ldriver;
public AddCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver,this);
	
}
@FindBy(xpath="//a[contains(text(),'New Customer')]")
@CacheLookup
WebElement lnkNewCustomer;

@FindBy(name="name")
@CacheLookup
WebElement txtCustomerName;

@FindBy(name="rad1")
@CacheLookup
WebElement btnGender;
 
@FindBy(id="dob")
@CacheLookup
WebElement txtDOB;

@FindBy(name="addr")
@CacheLookup
WebElement txtAddress;

@FindBy(name="city")
@CacheLookup
WebElement txtCity;

@FindBy(name="state")
@CacheLookup
WebElement txtState;

@FindBy(name="pinno")
@CacheLookup
WebElement txtPIN;

@FindBy(name="telephoneno")
@CacheLookup
WebElement txtTelephoneNumber;

@FindBy(name="emailid")
@CacheLookup
WebElement txtEmail;

@FindBy(name="sub")
@CacheLookup
WebElement lnkSubmit;

//action methods
public void clickNewCustomer() {
	lnkNewCustomer.click();
}
public void customerName(String cname) {
	txtCustomerName.sendKeys(cname);
}
public void custGender(String cgender) {
	btnGender.click();
}
public void custDOB(String mm,String dd,String yy) {
	txtDOB.sendKeys(mm);
	txtDOB.sendKeys(dd);
	txtDOB.sendKeys(yy);
}
public void custAddress(String caddress) {
	txtAddress.sendKeys(caddress);
}
public void custcity(String ccity) {
	txtCity.sendKeys(ccity);
}

public void custstate(String cstate) {
	txtState.sendKeys(cstate);
}

public void custpinno(String cpinno) {
	txtPIN.sendKeys(String.valueOf(cpinno));//converts String  to numbers 
}

public void custtelephoneno(String ctelephoneno) {
	txtTelephoneNumber.sendKeys(ctelephoneno);
}

public void custemailid(String cemailid) {
	txtEmail.sendKeys(cemailid);
}

//public void custpassword(String cpassword) {
//	txtpassword.sendKeys(cpassword);
//}

public void custsubmit() {
	lnkSubmit.click();
}



}















