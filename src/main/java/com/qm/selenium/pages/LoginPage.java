package com.qm.selenium.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qm.SupportedUtils.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods{
	public  String strtestdatafilename="UiTestData";
	public LoginPage(RemoteWebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver,this);
	}
	@FindBy(how=How.XPATH,using="//span[contains(text(),'Login')]")
	private WebElement eleToClickOnLoginLink;	
	
	@FindBy(how=How.XPATH,using="//input[@id='lid']")
	private WebElement eleToEnterUserName;	
	
	@FindBy(how=How.XPATH,using="//input[@id='pwd']")
	private WebElement eleToEnterPassword;	
	
	@FindBy(how=How.ID,using="signin_submit")
	private WebElement eleToClickOnSignIn;
	
	public void clickLoginLink() {
		click(eleToClickOnLoginLink);
	}
	
	public void enterUserName(String username) {	
		clearAndType(eleToEnterUserName, username);
	}	
	
	public void enterPassword(String password) {	
		clearAndType(eleToEnterPassword, password);
	}
	
	public void clickLogin() {
		click(eleToClickOnSignIn);
		waitForElementLoad(2000);
	}
	
	
}
