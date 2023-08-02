package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class ViewLeadPage extends LeafTapsWrappers  {
	

	public ViewLeadPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("View Lead | opentaps CRM")){
			reportStep("This is not View Lead Page", "FAIL");
		}
	}


	public ViewLeadPage verifyFirstName (String text){
		verifyTextContainsById(prop.getProperty("ViewLead.FirstName.Id"), text);
		return this;
	}

	public ViewLeadPage verifyCompanyName (String text){
		verifyTextContainsById(prop.getProperty("ViewLead.CompanyName.Id"), text);
		return this;
	}


	public EditLeadPage clickEditLead (){
		clickByLink(prop.getProperty("ViewLead.Edit.Link"));
		return new EditLeadPage(driver, test);

	}
	
	public DuplicateLeadPage clickDuplicateLead (){
		clickByLink(prop.getProperty("ViewLead.Duplicate.Link"));
		return new DuplicateLeadPage(driver, test);

	}
	
	public MyLeadsPage clickDeleteLead (){
		clickByLink(prop.getProperty("ViewLead.Delete.Link"));
		return new MyLeadsPage(driver, test);

	}

	
	public String returnFirstName (){
		String firstName_viewlead= getTextById(prop.getProperty("ViewLead.FirstName.Id"));
		return firstName_viewlead;
	}
	
	public FindLeadsPage clickFindLead (){
		clickByLink(prop.getProperty("MyLeads.FindLeads.Link"));
		return new FindLeadsPage(driver, test);

	}
	
//	public String verifyReturnFirstName (String text){
//		firstName_viewlead= getTextById(prop.getProperty("ViewLead.FirstName.Id"));
//		return firstName_viewlead;
//	}
	
}
