package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.FindLeadsWindowPage;
import pages.LoginPage;
import pages.MergeLeadsPage;
import pages.ViewLeadPage;
import wrappers.LeafTapsWrappers;

public class TC007_MergeLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Merge Lead";
		testDescription="Merge two leads";
		browserName="chrome";
		dataSheetName="TC007_MergeLead";
		category="Sanity";
		authors="Dinesh";
	}

	@Test(dataProvider="fetchData")
	public void mergeLead(String userName, String password, String firstName, String firstName2) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickonLeads()
		.clickMergeLead()
		.clickFromLeadIcon();
		switchToLastWindow();
		new FindLeadsWindowPage(driver, test)
		.enterFirstName_NameID(firstName)
		.clickFindLeadButton();
		Thread.sleep(3000);
		String str1= new FindLeadsWindowPage(driver, test).captureFirstResultLeadID();
		new FindLeadsWindowPage(driver, test)
		.clickFirstResultLeadID();
		switchToParentWindow();
		new MergeLeadsPage(driver, test)
		.clickToLeadIcon();
		switchToLastWindow();
		new FindLeadsWindowPage(driver, test)
		.enterFirstName_NameID(firstName2)
		.clickFindLeadButton();
		Thread.sleep(3000);
		new FindLeadsWindowPage(driver, test)
		.clickFirstResultLeadID();
		switchToParentWindow();
		new MergeLeadsPage(driver, test)
		.clickMergeLeadButton();
		acceptAlert();
		new ViewLeadPage(driver, test)
		.clickFindLead()
		.enterLeadID_NameID(str1)
		.clickFindLeadButton();
		Thread.sleep(2000);
		new FindLeadsPage(driver, test)
		.verifyNoRecordPresent();
	}
}
