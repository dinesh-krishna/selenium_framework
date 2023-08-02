package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class EditLeadPage extends LeafTapsWrappers  {

	public EditLeadPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("opentaps CRM")){
			reportStep("This is not Edit Lead Page", "FAIL");
		}
	}


	public EditLeadPage updateCompanyName (String text){
		enterById(prop.getProperty("EditLead.CompanyName.Id"), text);
		return this;
	}


	public ViewLeadPage clickUpdateButton (){
		clickByXpath(prop.getProperty("EditLead.UpateButton.Xpath"));
		return new ViewLeadPage(driver, test);
	}

}
