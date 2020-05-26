package com.qm.selenium.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.qm.SupportedUtils.ProjectSpecificMethods;

public class ChartNotesPage extends ProjectSpecificMethods {

	public ChartNotesPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.XPATH, using = "//td[contains(text(),'Dr.DeepScribe Dev : In Person')]")
	public WebElement eleToClickOnPatientLinkToNavigateToEditPage;

	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Edit')]")
	public WebElement eleToClickOnEditChartNotes;

	@FindBy(how = How.XPATH, using = "//div[@id='editor_1']//iframe[@class='ze_area']")
	public WebElement eleToSwitchComplaintTextXpath;
	
	@FindBy(how = How.XPATH, using = "//body[@class='ze_body']")
	public WebElement eleToEnterNotes;
	
	@FindBy(how = How.XPATH, using = "//div[@id='editor_1_2']//iframe[@class='ze_area']")
	public WebElement eleToSwitchSymptomTextXpath;
	
	@FindBy(how = How.ID, using = "saveContentDiv")
	public WebElement eleToClickOnSaveButton;
	
	@FindBy(how = How.ID, using = "encounterTab_2")
	public WebElement eleToClickOnHistoryTab;
	
	@FindBy(how = How.XPATH, using = "//div[@id='editor_2']//iframe[@class='ze_area']")
	public WebElement eleToSwitchHistoryFramePresentIllnessTextXpath;
	
	@FindBy(how = How.XPATH, using = "//div[@id='editor_2_4']//iframe[@class='ze_area']")
	public WebElement eleToSwitchHistoryFramePastIllnessTextXpath;
	
	@FindBy(how = How.ID, using = "encounterTab_3")
	public WebElement eleToClickOnPhysicalExaminationTab;
	
	@FindBy(how = How.XPATH, using = "//div[@id='PE_VIEW']//div//table//tbody//tr//td//div//div[contains(text(),'Templates')]")
	public WebElement eleToClickOnPhysicalExaminationTemplateLink;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'IM Skin Growth - PE')]")
	public WebElement eleToClickOnPhysicalExaminationSkinGrowthTemplate;
	
	@FindBy(how = How.XPATH, using = "//input[@id='VALUE_46_0_10_568039000000029581']")
	public WebElement eleToClickOnLesonCheckBox;
	
	@FindBy(how = How.XPATH, using = "//input[@name='VALUE_46_0_11']")
	public WebElement eleToClickOnMaculaCheckBox;
	
	@FindBy(how = How.XPATH, using = "/html[1]/body[1]/div[22]/table[1]/tbody[1]/tr[1]/td[1]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/input[1]")
	public WebElement eleToEnterHypomelanoticSize;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	public WebElement eleToClickOnOk;
	
	@FindBy(how = How.XPATH, using = "//iframe[@class='ze_area']")
	public WebElement eleToPhysicalExaminationAssesmentAndSelfNotesTextXpath;
	
	@FindBy(how = How.ID, using = "encounterTab_5")
	public WebElement eleToClickOnAssessmentNotesTab;
	
	@FindBy(how = How.ID, using = "encounterTab_6")
	public WebElement eleToClickOnDiagnosesTab;
	
	@FindBy(how = How.ID, using = "encounterTab_7")
	public WebElement eleToClickOnSelfNotes;
	
	@FindBy(how = How.ID, using = "FUNCTIONAL_STATUS")
	public WebElement eleToEnterFunctionalStatus;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Add Dx')]")
	public WebElement eleToClickOnAddDx;
	
	@FindBy(how = How.XPATH, using = "//li[1]//div[1]//div[1]//span[3]")
	public WebElement eleToclickOnHypermiea;
	
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Add')]")
	public WebElement eleToclickOnAddHypermiea;
	
	@FindBy(how = How.ID, using = "diagnosis_0")
	public WebElement eleToEnterDiagnosis;
	
	public void clickOnPatientLinkToNavigateToEditPage(){
		waitForElementLoad(12000);
		click(eleToClickOnPatientLinkToNavigateToEditPage);
	}
	
	public void clickOnEditChartNotes() {
		waitForElementLoad(3000);
		click(eleToClickOnEditChartNotes);
	}
	

	public void enterNotesInChiefComplaints(String complaintsNotes) {
		waitForElementLoad(3000);
		switchToFrame(eleToSwitchComplaintTextXpath);
		clearAndType(eleToEnterNotes,complaintsNotes);
	}
	
	public void enterNotesInSymptoms(String symptoms) {
		defaultContent();
		waitForElementLoad(3000);
		switchToFrame(eleToSwitchSymptomTextXpath);
		clearAndType(eleToEnterNotes,symptoms);
	}

	public void clickOnSaveNotes() {
		defaultContent();
		click(eleToClickOnSaveButton);
		waitForElementLoad(2000);
	}
	
	public void clickOnHistoryTab() {
		click(eleToClickOnHistoryTab);
	}

	public void enterNotesInHistoryPresentIllnessTextPath(String presentIllness) {
		waitForElementLoad(3000);
		switchToFrame(eleToSwitchHistoryFramePresentIllnessTextXpath);
		clearAndType(eleToEnterNotes,presentIllness);
	}
	
	public void enterNotesInHistoryPastIllnessTextPath(String PastIllnessText) {
		defaultContent();
		waitForElementLoad(3000);
		switchToFrame(eleToSwitchHistoryFramePastIllnessTextXpath);
		clearAndType(eleToEnterNotes,PastIllnessText);
	}
	
	public void clickOnPhysicalExaminationTab() {
		click(eleToClickOnPhysicalExaminationTab);
	}
	
	public void enterPhysicalExaminationAssesmentAndSelfNotesTextXpath(String physicalExaminationAndAssesmentText) {
		waitForElementLoad(3000);
		switchToFrame(eleToPhysicalExaminationAssesmentAndSelfNotesTextXpath);
		clearAndType(eleToEnterNotes,physicalExaminationAndAssesmentText);
	}
	
	public void clickOnAssessmentNotesTab() {
		click(eleToClickOnAssessmentNotesTab);
	}
	
	public void clickOnSelfNotesTab() {
		click(eleToClickOnSelfNotes);
	}
	
	public void clickOnPhysicalExaminationTemplateLink() {
		click(eleToClickOnPhysicalExaminationTemplateLink);
	}
	
	public void clickOnPhysicalExaminationSkinGrowthTemplate() {
		clickBySingleAction(eleToClickOnPhysicalExaminationSkinGrowthTemplate,"SkinGrowth");
		waitForElementLoad(2000);
	}
	
	public void clickOnLesonCheckBox() {
		click(eleToClickOnLesonCheckBox);
	}

	public void clickOnMaculaCheckBox() {
		click(eleToClickOnMaculaCheckBox);
	}
	
	public void enterHypomelanoticSize(String hypomelanoticSize) {
		clearAndType(eleToEnterHypomelanoticSize,hypomelanoticSize);
	}
	
	public void clickOnOkay() {
		click(eleToClickOnOk);
	}
	
	public void enterFunctionalStatus(String status) {
		clearAndType(eleToEnterFunctionalStatus, status);
	}
	
	public void clickOnAddDx() {
		click(eleToClickOnAddDx);
	}
	
	public void clickOnDiagnosesTab() {
		click(eleToClickOnDiagnosesTab);
	}
	
	public void enterDiagnosis(String diagnosis) {
		clearAndType(eleToEnterDiagnosis, diagnosis);
		waitForElementLoad(2000);
	}
	public void clickOnHypermiea() {
		click(eleToclickOnHypermiea);
	}
	
	public void clickOnAddHypermiea() {
		click(eleToclickOnAddHypermiea);
		waitForElementLoad(2000);
	}
}
