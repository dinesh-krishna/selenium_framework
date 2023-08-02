package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC006_DeleteLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Delete Lead";
		testDescription="Delete the lead by first name";
		browserName="chrome";
		dataSheetName="TC006_DeleteLead";
		category="Sanity";
		authors="Dinesh";
	}

	@Test(dataProvider="fetchData")
	public void deleteLead(String userName, String password, String firstName) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickonLeads()
		.clickFindLead()
		.enterFirstName_NameID(firstName)
		.clickFindLeadButton();
		Thread.sleep(2000);
		String str1 = new FindLeadsPage(driver, test).captureFirstResultLeadID();
		new FindLeadsPage(driver, test)
		.clickFirstResultLeadID()
		.clickDeleteLead()
		.clickFindLead()
		.enterLeadID_NameID(str1)
		.clickFindLeadButton()
		.verifyNoRecordPresent();		
	}

}
