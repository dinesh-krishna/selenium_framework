package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class FindLeadsWindowPage extends LeafTapsWrappers  {

	public FindLeadsWindowPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Find Leads")){
			reportStep("This is not Find Lead Page", "FAIL");
		}
	}

	public FindLeadsWindowPage enterLeadID_NameID(String id){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.LeadID_NameID.Xpath"), id);
		return this;
	}
	public FindLeadsWindowPage enterFirstName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.FirstName_NameID.Xpath"), text);
		return this;
	}
	public FindLeadsWindowPage enterLastName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.LastName_NameID.Xpath"), text);
		return this;
	}
	public FindLeadsWindowPage enterCompanyName_NameID(String text){
		clickByXpath(prop.getProperty("FindLead.NameID.Xpath"));
		enterByXpath(prop.getProperty("FindLead.CompanyName_NameID.Xpath"), text);
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

	public FindLeadsWindowPage clickFindLeadButton(){
		clickByXpath(prop.getProperty("FindLead.FindLeadButton.Xpath"));
		return this;
	}

	public FindLeadsWindowPage clickFirstResultLeadID(){
		clickByXpathNoSnap(prop.getProperty("FindLead.FirstResultLeadID.Xpath"));
		return this;
	}

}
