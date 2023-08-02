package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.FindLeadsPage;
import pages.LoginPage;
import pages.ViewLeadPage;
import wrappers.LeafTapsWrappers;

public class TC005_DuplicateLead extends LeafTapsWrappers{

	@BeforeClass
	public void setData() {
		testCaseName="Duplicate Lead";
		testDescription="Duplicate a Lead and verify first name";
		browserName="chrome";
		dataSheetName="TC005_DuplicateLead";
		category="Sanity";
		authors="Dinesh";
	}

	@Test(dataProvider="fetchData")
	public void duplicateLead(String userName, String password, String email) throws InterruptedException{

		new LoginPage(driver, test)
		.enterUserName(userName)
		.enterPassword(password)
		.clickLogin()
		.clickCRMSFA()
		.clickonLeads()
		.clickFindLead()
		.enterEmailAddress_Email(email)
		.clickFindLeadButton();
		Thread.sleep(2000);
		String str1= new FindLeadsPage(driver, test).captureFirstResultLeadName();	
		new FindLeadsPage(driver, test)
		.clickFirstResultLeadID()
		.clickDuplicateLead()
		.verifySectionHeaderTitle()
		.clickCreateLead();
		String str2= new ViewLeadPage(driver, test).returnFirstName();
		if (str1.equals(str2))

		{
			System.out.println("FindLead_FirstName "+str1+" and ViewLead_FirstName "+str2+" Matches");
			reportStep("FindLead_FirstName and ViewLead_FirstName Matches", "PASS");

		}
		else 
		{
			System.out.println("FindLead_FirstName "+str1+" and ViewLead_FirstName "+str2+" Does not Match");
			reportStep("FindLead_FirstName and ViewLead_FirstName does not Matches", "FAIL");

		}
	}

}
