package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadsPage extends LeafTapsWrappers  {

	public FindLeadsPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads | opentaps CRM")){
			reportStep("This is not Find Lead Page", "FAIL");
		}
	}

	public FindLeadsPage enterLeadID_NameID(String id){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.LeadID_NameID.Xpath"), id);
		return this;
	}
	public FindLeadsPage enterFirstName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.FirstName_NameID.Xpath"), text);
		return this;
	}
	public FindLeadsPage enterLastName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.LastName_NameID.Xpath"), text);
		return this;
	}
	public FindLeadsPage enterCompanyName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.CompanyName_NameID.Xpath"), text);
		return this;
	}

	public FindLeadsPage enterPhoneNumber_Phone(String text){
		clickByXpath(prop.getProperty("FindLead.Phone.Xpath"));
		enterByXpath(prop.getProperty("FindLead.Phonenumber_Phone.Xpath"), text);
		return this;
	}

	public FindLeadsPage enterEmailAddress_Email(String text){
		clickByXpath(prop.getProperty("FindLead.Email.Xpath"));
		enterByXpath(prop.getProperty("FindLead.EmailAddress_Email.Xpath"), text);
		return this;
	}
	
	
	public String captureFirstResultLeadName(){
		String firstName_findlead = getTextByXpath(prop.getProperty("FindLead.FirstResultLeadName.Xpath"));
		return firstName_findlead;
	}
	
	public String captureFirstResultLeadID(){
		String leadID_findlead = getTextByXpath(prop.getProperty("FindLead.FirstResultLeadID.Xpath"));
		return leadID_findlead;
	}
	
	public FindLeadsPage clickFindLeadButton(){
		clickByXpath(prop.getProperty("FindLead.FindLeadButton.Xpath"));
		return this;
	}
	
	public ViewLeadPage clickFirstResultLeadID(){
		clickByXpath(prop.getProperty("FindLead.FirstResultLeadID.Xpath"));
		return new ViewLeadPage(driver, test);
	}

	public FindLeadsPage verifyNoRecordPresent (){
		verifyTextByXpath(prop.getProperty("FindLead.NoRecordPresent.Xpath"), "No records to display");
		return this;

	}
	
}
