package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class DuplicateLeadPage extends LeafTapsWrappers  {

	public DuplicateLeadPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Duplicate Lead | opentaps CRM")){
			reportStep("This is not Duplicate Lead Page", "FAIL");
		}
	}

	public DuplicateLeadPage enterCompanyName (String compName){
		enterById(prop.getProperty("CreateLead.CompanyName.Id"), compName);
		return this;
	}

	public DuplicateLeadPage enterFirstName (String firstName){
		enterById(prop.getProperty("CreateLead.FirstName.Id"), firstName);
		return this;

	}

	public DuplicateLeadPage enterLastName (String lastName){
		enterById(prop.getProperty("CreateLead.LastName.Id"), lastName);
		return this;

	}

	public DuplicateLeadPage verifySectionHeaderTitle (){
		verifyTextByXpath(prop.getProperty("DuplicateLead.SectionHeaderTitle.Xpath"), "Duplicate Lead");
		return this;

	}


	public ViewLeadPage clickCreateLead (){
		clickByName(prop.getProperty("CreateLead.CreateLead.Name"));
		return new ViewLeadPage(driver, test);

	}




}
