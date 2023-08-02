package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentTest;

import wrappers.LeafTapsWrappers;

public class HomePage extends LeafTapsWrappers  {

	public HomePage(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;

		if(!verifyTitle("Leaftaps - TestLeaf Automation Platform")){
			reportStep("This is not Home Page", "FAIL");
		}
	}

	public HomePage verifyLoggedName(String data) {
		verifyTextContainsByXpath(prop.getProperty("Home.UserName.Xpath"), data);
		return this;
	}

	public LoginPage clickLogout() {
		clickByClassName(prop.getProperty("Login.LoginButton.Class"));
		return new LoginPage(driver,test);

	}

	public MyHomePage clickCRMSFA() {
		clickByLink(prop.getProperty("Home.CRMSFA.Link"));
		return new MyHomePage(driver,test);

	}

}
