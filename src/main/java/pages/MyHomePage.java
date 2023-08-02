package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class MyHomePage extends LeafTapsWrappers  {

	public MyHomePage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("My Home | opentaps CRM")){
			reportStep("This is not My Home Page", "FAIL");
		}
	}
	


	public MyLeadsPage clickonLeads (){
		clickByLink(prop.getProperty("MyHome.Leads.Link"));
		return new MyLeadsPage(driver, test);
	}

	

}
