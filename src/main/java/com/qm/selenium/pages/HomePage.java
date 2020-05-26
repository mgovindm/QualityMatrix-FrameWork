package com.qm.selenium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.qm.SupportedUtils.ProjectSpecificMethods;

public class HomePage extends ProjectSpecificMethods {

	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "NEW_DIALOG_CLOSE_MARK")
	public WebElement eleToCLoseDialogPop;

	@FindBy(how = How.XPATH, using = "//div[@id='MEMBER_TAB_ID_2']//div//i")
	public WebElement eleToClickOnChartNotes;

	public void clickCLoseDialogPop(){
		waitForElementLoad(8000);
		click(eleToCLoseDialogPop);
	}
	
	public void clickOnCharNotes() {
		click(eleToClickOnChartNotes);
		waitForElementLoad(6000);
	}


}
