package com.qm.selenium.ui.testcases;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.qm.SupportedUtils.JsonComponent;
import com.qm.SupportedUtils.PermittedCharacters;
import com.qm.SupportedUtils.ProjectSpecificMethods;
import com.qm.SupportedUtils.RandomGenerator;
import com.qm.selenium.pages.ChartNotesPage;
import com.qm.selenium.pages.HomePage;
import com.qm.selenium.pages.LoginPage;

public class EditPatientChartNotes extends ProjectSpecificMethods {
	public String strtestdatafilename = "UiTestData";
	JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);

	@BeforeTest
	public void setValues() {
		testSuiteName = "EditPatientChartNotes";
		testSuiteDescription = "Testing the functionality of EditPatientChartNotes";
		nodes = "EditPatientChartNotes";
	}

	public void login() {
		LoginPage loginPage = new LoginPage(driver, test);
		JSONObject jsonsuitetestData = JsonComponent.getJsonData("suiteLevelData", strtestdatafilename);
		loginPage.clickLoginLink();
		loginPage.enterUserName((String) jsonsuitetestData.get("username"));
		loginPage.enterPassword((String) jsonsuitetestData.get("password"));
		loginPage.clickLogin();
	}
	
	@Test
	public void TC001_verify_user_is_able_to_edit_the_patient_history_details_successfully() {
		String testName = "TC001_verify_user_is_able_to_edit_the_patient_history_details_successfully";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		ChartNotesPage chartnotepage=new ChartNotesPage(driver, test);
		String randomString = RandomGenerator.randomString();

		try {
			login();
			homePage.clickCLoseDialogPop();
			homePage.clickOnCharNotes();
			chartnotepage.clickOnPatientLinkToNavigateToEditPage();
			chartnotepage.clickOnEditChartNotes();
			chartnotepage.clickOnHistoryTab();
			chartnotepage.enterNotesInHistoryPresentIllnessTextPath(randomString);
			chartnotepage.enterNotesInHistoryPastIllnessTextPath(randomString);
			chartnotepage.clickOnSaveNotes();
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test(enabled = true)
	public void TC002_verify_user_is_able_to_select_the_physical_examination_checkbox_successfully() {
		String testName = "TC002_verify_user_is_able_to_select_the_physical_examination_checkbox_successfully";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		ChartNotesPage chartnotepage=new ChartNotesPage(driver, test);

		try {
			login();
			homePage.clickCLoseDialogPop();
			homePage.clickOnCharNotes();
			chartnotepage.clickOnPatientLinkToNavigateToEditPage();
			chartnotepage.clickOnEditChartNotes();
			chartnotepage.clickOnPhysicalExaminationTab();
			chartnotepage.clickOnPhysicalExaminationTemplateLink();
			chartnotepage.clickOnPhysicalExaminationSkinGrowthTemplate();
			chartnotepage.clickOnLesonCheckBox();
			chartnotepage.clickOnMaculaCheckBox();
			chartnotepage.enterHypomelanoticSize( RandomGenerator.random(2, PermittedCharacters.NUMERIC));
			chartnotepage.clickOnOkay();
			chartnotepage.clickOnSaveNotes();
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC003_verify_user_is_able_to_edit_the_physical_examination_details_successfully() {
		String testName = "TC003_verify_user_is_able_to_edit_the_patient_history_details_successfully";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		ChartNotesPage chartnotepage=new ChartNotesPage(driver, test);
		String randomString = RandomGenerator.randomString();

		try {
			login();
			homePage.clickCLoseDialogPop();
			homePage.clickOnCharNotes();
			chartnotepage.clickOnPatientLinkToNavigateToEditPage();
			chartnotepage.clickOnEditChartNotes();
			chartnotepage.clickOnPhysicalExaminationTab();
			chartnotepage.enterFunctionalStatus(randomString);
			chartnotepage.clickOnSaveNotes();
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC004_verify_user_is_able_to_add_diagonisis_details_successfully() {
		String testName = "TC004_verify_user_is_able_to_add_diagonisis_details_successfully";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		ChartNotesPage chartnotepage=new ChartNotesPage(driver, test);

		try {
			login();
			homePage.clickCLoseDialogPop();
			homePage.clickOnCharNotes();
			chartnotepage.clickOnPatientLinkToNavigateToEditPage();
			chartnotepage.clickOnEditChartNotes();
			chartnotepage.clickOnDiagnosesTab();
			chartnotepage.clickOnAddDx();
			chartnotepage.enterDiagnosis((String) jsonsuitetestData.get("diagonisis"));
			chartnotepage.clickOnHypermiea();
			chartnotepage.clickOnAddHypermiea();
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
	
	@Test
	public void TC005_verify_user_is_able_to_edit_the_patient_cheif_Complaints_chart_notes_successfully() {
		String testName = "TC005_verify_user_is_able_to_edit_the_patient_cheif_Complaints_chart_notes_successfully";
		// setting Report data
		reportUpdate(testName);
		HomePage homePage = new HomePage(driver, test);
		ChartNotesPage chartnotepage=new ChartNotesPage(driver, test);
		String randomString = RandomGenerator.randomString();

		try {
			login();
			homePage.clickCLoseDialogPop();
			homePage.clickOnCharNotes();
			chartnotepage.clickOnPatientLinkToNavigateToEditPage();
			chartnotepage.clickOnEditChartNotes();
			chartnotepage.enterNotesInChiefComplaints(randomString);
			chartnotepage.enterNotesInSymptoms(randomString);
			chartnotepage.clickOnSaveNotes();
		} catch (Exception e) {
			test.log(Status.ERROR, "StackTrace Result: " + e);
			Assert.fail(e.getMessage());
			reportStep("Test Case Not executed Successfully", "fail");
		}
	}
}
