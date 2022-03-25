package com.BDD.DemoAvatrade;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.ITestContext;

import com.BDD.DemoAvatrade.Locators.Locator;
import com.BDD.DemoAvatrade.Locators.Selector;



public interface Utils {
	
	int dat = 5;

	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#MoveToElement(com.Automation.NewsPage.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Move the cursor to the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void MoveToElement(Locator locatorType, String locatorValue);

	
	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#Click(com.Automation.NewsPage.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	void Click(Locator locatorType, String locatorValue, String pageName, String elementName);

	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#WaitForElementToBeAvailable(com.Automation.NewsPage.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Wait for an element to be available
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	void WaitForElementToBeAvailable(Locator locatorType, String locatorValue);

	
	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#SendKeys(com.Automation.NewsPage.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Populate a Textbox
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param value Value with Textbox to be populated
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	void SendKeys(Locator locatorType, String locatorValue, String value, String pageName, String elementName);

	
	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#Size(com.Automation.NewsPage.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns Size of the the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return int Size of the element(s)
	 */
	int Size(Locator locatorType, String locatorValue);

	
	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#IsDisplayed(com.Automation.NewsPage.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is displayed
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	boolean IsDisplayed(Locator locatorType, String locatorValue);

	
	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#GetText(com.Automation.NewsPage.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the text of the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Text of the element
	 */
	String GetText(Locator locatorType, String locatorValue);

	

	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#quitBrowser()
	 * @Version 1.01
	 * @description Quits the browser
	 */
	void quitBrowser();

	

	/**
	 * @param element Element to be scrolled upto
	 * @description to scroll upto the element
	 */
	void scrollToElement(WebElement element);

	/**
	 

	/**
	 * @param element Element to be checked if present
	 * @description To check if element is present
	 */
	Boolean isVisibleInViewport(WebElement element);

	/* (non-Javadoc)
	 * @see com.Automation.NewsPage.Utils#ClickwithScroll(com.Automation.NewsPage.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on an element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element
	 */
	


	void waitforElementToBeClickable(Locator locatorType,String locatorValue);

	
	
	
}