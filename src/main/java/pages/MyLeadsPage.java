package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyLeadsPage extends LeafTapsWrappers  {

	public MyLeadsPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Leads | opentaps CRM")){
			reportStep("This is not My Lead Page", "FAIL");
		}
	}

	public CreateLeadPage clickCreateLead (){
		clickByLink(prop.getProperty("MyLeads.CreateLead.Link"));
		return new CreateLeadPage(driver, test);

	}

	public FindLeadsPage clickFindLead (){
		clickByLink(prop.getProperty("MyLeads.FindLeads.Link"));
		return new FindLeadsPage(driver, test);

	}

	public MergeLeadsPage clickMergeLead (){
		clickByLink(prop.getProperty("MyLeads.MergeLeads.Link"));
		return new MergeLeadsPage(driver, test);

	}



}
