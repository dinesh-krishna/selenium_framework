package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.LoginPage;
import wrappers.LeafTapsWrappers;

public class TC003_CreateLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Create Lead";
		testDescription="Create Lead and verify the First name of the lead";
		browserName="chrome";
		dataSheetName="TC003_CreateLead";
		category="Regression";
		authors="Dinesh";
	}

	@Test(dataProvider="fetchData")
	public void createLead(String userName, String password, String compName, String firstName, String lastName, String chkfirstName){

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickonLeads()
		.clickCreateLead()
		.enterCompanyName(compName)
		.enterFirstName(firstName)
		.enterLastName(lastName)
		.clickCreateLead()
		.verifyFirstName(chkfirstName);
	}

}
