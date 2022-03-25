package com.BDD.DemoAvatrade.stepdefinations;

import com.BDD.DemoAvatrade.DriverManager;
import com.BDD.DemoAvatrade.Locators.Locator;
import com.BDD.DemoAvatrade.utility.Base;

import cucumber.api.java.en.*;



public class CreateAccountPage extends Base{
	
	

public static final String tryFreeDemo_xpath = "//a[contains(@href,'demo-account')]"; 
public static final String firstName_id = "name";
public static final String lastName_id = "lastName"; 
public static final String email_id = "email"; 	
public static final String phone_id = "phoneInput"; 		
public static final String createAccount_xpath = "//button[@name='avaWidgetSubmit']"; 	
public static final String closeButton_xpath = "//button[text()='Close']"; 	
public static final String skipTutorial_xpath = "//span[text()='Skip Tutorial']"; 		
public static final String tradeIcon_xpath = "//a[@href='/trade']"; 	
public static final String cryptoOption_xpath = "//a[@href='/trade/crypto']"; 	
public static final String markitFav_xpath = "//tbody/tr//td//div[contains(@class,'watchlist-entity.component_favCell')]"; 	
public static final String symbol_xpath = "//tbody/tr//td//div[contains(@class,'symbolCell')]/span"; 	
	
	
	
	
	
	@Given("^I opned demo url$")
	public static void openSite() throws Exception {
		DriverManager.getDriver().get(Base.dataProvider.getConfigPropertyval("URL"));
		Thread.sleep(3000);
	}
	
	@Given("^I create demo account$")
	public static void createDemoAccount() throws Exception {
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, tryFreeDemo_xpath);
		seleniumUtils.Click(Locator.XPATH, tryFreeDemo_xpath, "Login", "Try Free Demo");
		seleniumUtils.WaitForElementToBeAvailable(Locator.ID, firstName_id);
		seleniumUtils.SendKeys(Locator.ID, firstName_id, getCSVData("First Name"), "Create Account", "First Name");
		seleniumUtils.SendKeys(Locator.ID, lastName_id, getCSVData("Last Name"), "Create Account", "Last Name");
		seleniumUtils.SendKeys(Locator.ID, email_id, getMailID(), "Create Account", "Email");
		seleniumUtils.SendKeys(Locator.ID, phone_id, getCSVData("Phone Number"), "Create Account", "Phone Number");
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, createAccount_xpath);
		seleniumUtils.Click(Locator.XPATH, createAccount_xpath, "Create Account", "Create Account");
	}
	

	

}
