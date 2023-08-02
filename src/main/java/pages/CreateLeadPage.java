package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class CreateLeadPage extends LeafTapsWrappers  {

	public CreateLeadPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Create Lead | opentaps CRM")){
			reportStep("This is not Create Lead Page", "FAIL");
		}
	}

	public CreateLeadPage enterCompanyName (String compName){
		enterById(prop.getProperty("CreateLead.CompanyName.Id"), compName);
		return this;
	}

	public CreateLeadPage enterFirstName (String firstName){
		enterById(prop.getProperty("CreateLead.FirstName.Id"), firstName);
		return this;

	}

	public CreateLeadPage enterLastName (String lastName){
		enterById(prop.getProperty("CreateLead.LastName.Id"), lastName);
		return this;

	}

	public ViewLeadPage clickCreateLead (){
		clickByName(prop.getProperty("CreateLead.CreateLead.Name"));
		return new ViewLeadPage(driver, test);

	}




}
