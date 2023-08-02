package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MergeLeadsPage extends LeafTapsWrappers  {

	public MergeLeadsPage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Merge Leads | opentaps CRM")){
			reportStep("This is not Merge Lead Page", "FAIL");
		}
	}

	public MergeLeadsPage clickFromLeadIcon (){
		clickByXpath(prop.getProperty("MergeLead.FromLeadIcon.Xpath"));
		return this;
	}

	public MergeLeadsPage clickToLeadIcon (){
		clickByXpath(prop.getProperty("MergeLead.ToLeadIcon.Xpath"));
		return this;
	}

	public MergeLeadsPage clickMergeLeadButton (){
		clickByLinkNoSnap(prop.getProperty("MergeLead.MergeLeadButton.Link"));
		return this;
	}


}
