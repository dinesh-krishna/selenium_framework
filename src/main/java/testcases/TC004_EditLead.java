package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC004_EditLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Edit Lead";
		testDescription="Edit a Lead's Company Name and confirm the changes";
		browserName="chrome";
		dataSheetName="TC004_EditLead";
		category="Sanity";
		authors="Dinesh";
	}

	@Test(dataProvider="fetchData")
	public void editLead(String userName, String password, String firstName, String compName, String chkcompanyName){

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickonLeads()
		.clickFindLead()
		.enterFirstName_NameID(firstName)
		.clickFindLeadButton()
		.clickFirstResultLeadID()
		.clickEditLead()
		.updateCompanyName(compName)
		.clickUpdateButton()
		.verifyCompanyName(chkcompanyName);
	}

}
