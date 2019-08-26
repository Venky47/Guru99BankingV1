package com.inetbanking.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class NewAccountPage {
	public WebDriver ldriver;
	public NewAccountPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
		}
@FindBy(xpath="//a[contains(text(),'New Account')]")
//@FindBy(xpath="//a[contains(text(),'New Customer')]")
@CacheLookup
WebElement newAccount;

@FindBy(name="cusid")
@CacheLookup
WebElement customerId;

@FindBy(name="selaccount")
@CacheLookup
WebElement accountType;

@FindBy(name="inideposit")
@CacheLookup
WebElement initialDeposit;

@FindBy(name="button2")
@CacheLookup
WebElement submit;

public void clickNewAccount() {
	newAccount.click();
}
public void customerId(String id) {
	customerId.sendKeys(id);
}
public void accountType(String account) {
	accountType.click();
	Select select=new Select(accountType);
	select.deselectByVisibleText(account);
}
public void initialDeposit(String deposit) {
	initialDeposit.sendKeys(deposit);
	
}
public void clickSubmit() {
	submit.click();
}

}
