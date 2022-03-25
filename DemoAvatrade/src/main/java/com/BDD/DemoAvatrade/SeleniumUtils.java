package com.BDD.DemoAvatrade;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestContext;

import com.BDD.DemoAvatrade.Locators.Locator;
import com.BDD.DemoAvatrade.Locators.Selector;



public class SeleniumUtils implements Utils {

	
	public static String noElementFound = "Element Not Found";
	public static String elementStatus = "No Such Element with ";
	
	
	/**
	 * @version 1.01
	 * @description 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */
	WebElement webElement(Locator locatorType,String locatorValue){
//		System.out.println(Utils.dat);
		WebElement element = null;
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			element=DriverManager.getDriver().findElement(selector(locatorType,locatorValue));
		}catch(NoSuchElementException e){
			element = null;
		}catch (WebDriverException e1){
		}
		return element;

	}

	List<WebElement> webElements(Locator locatorType,String locatorValue){
		List<WebElement> element= null;
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			element=DriverManager.getDriver().findElements(selector(locatorType,locatorValue));
		}catch(NoSuchElementException e){
			element = null;
		}
		return element;
	}

	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#MoveToElement(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Move the cursor to the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#MoveToElement(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void MoveToElement(Locator locatorType,String locatorValue){
		try{
			//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
			Actions action= new Actions(DriverManager.getDriver()); 
			action.moveToElement(webElement(locatorType,locatorValue)).build().perform();
		}catch(NoSuchElementException e){

		}
		catch(Exception e){

		}
	}


	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#Click(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Click on the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#Click(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public void Click(Locator locatorType,String locatorValue,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			try {
				DriverManager.getDriver().switchTo().alert().accept();
			} catch (NoAlertPresentException e) {}
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				scrollToElement(element);
				element.click();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				Actions action= new Actions(DriverManager.getDriver()); 
				action.moveToElement(element).click().build().perform();
			}
			
			LogFileControl.logInfo(pageName+" Page, Click on "+elementName, "Clicked");
			//                  ExtentTestManager.getlogger().log(LogStatus.INFO, pageName+" Page, Click on "+elementName, "Clicked");
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}


	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#WaitForElementToBeAvailable(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Wait for an element to be available
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#WaitForElementToBeAvailable(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 */
	@Override
	public  void WaitForElementToBeAvailable(Locator locatorType,String locatorValue){
		try{
			DriverManager.getWait().until(ExpectedConditions.presenceOfElementLocated(selector(locatorType,locatorValue)));
		}catch(Exception e){

		}
	}

	
	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#SendKeys(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 * @Version 1.01
	 * @description Populate a Textbox
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @param value Value with Textbox to be populated
	 * @param pageName Name of the Page
	 * @param elementName Name of the element to be clicked
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#SendKeys(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public  void SendKeys(Locator locatorType,String locatorValue,String value,String pageName,String elementName){
		WebElement element=webElement(locatorType,locatorValue);
		if(element==null){
			try {
				DriverManager.getDriver().switchTo().alert().accept();
			} catch (NoAlertPresentException e) {}
			element=webElement(locatorType,locatorValue);
		}
		if(element!=null){
			try{
				element.clear();
				element.sendKeys(Keys.chord(Keys.HOME));
				element.sendKeys(value);
			}catch(Exception e){
				element.clear();
				MoveToElement(locatorType,locatorValue);
				element.sendKeys(Keys.chord(Keys.HOME));
				element.sendKeys(value);
			}
			LogFileControl.logInfo(pageName+" Page, "+elementName+" Text Box", "Data entered as "+value);
			element.sendKeys(Keys.chord(Keys.TAB));
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}

	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#Size(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns Size of the the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return int Size of the element(s)
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#Size(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 */
	@Override
	public  int Size(Locator locatorType,String locatorValue){
		int size=0;
		try{
			size=webElements(locatorType,locatorValue).size();
		}catch(Exception e){}
		return size;
	}


	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#IsDisplayed(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Check if an element is displayed
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return boolean True/False
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#IsDisplayed(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 */
	@Override
	public  boolean IsDisplayed(Locator locatorType,String locatorValue){
		boolean flag=false;
		try{
			if(webElement(locatorType,locatorValue).isDisplayed()){
				flag=true;
			}
		}catch(Exception e)
		{
			System.out.println();
		}
		return flag;
	}

	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#GetText(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 * @Version 1.01
	 * @description Returns the text of the specified element
	 * @param locatorType (Xpath,ID,LinkText,ClassName,Name)
	 * @param locatorValue (Address of the element)
	 * @return String Text of the element
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#GetText(com.BDD.DemoAvatrade.Locators.Locator, java.lang.String)
	 */
	@Override
	public  String GetText(Locator locatorType,String locatorValue){
		String text=null;
		WebElement element=webElement(locatorType,locatorValue);
		if(element!=null){
			try{
				text=element.getText();
			}catch(Exception e){
				//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
				MoveToElement(locatorType, locatorValue);
				text=element.getText();
			}
		}else{
			try {
				LogFileControl.logFailwithScreenCapture(elementStatus+locatorType+" :" +locatorValue, noElementFound);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return text;
	}

	
	By selector(Locator locatorType,String locatorValue){
		By by = null;
		switch(locatorType){
		case CLASSNAME:
			by=By.className(locatorValue);
			break;
		case CSSSELECTOR:
			by=By.cssSelector(locatorValue);
			break;
		case ID:
			by=By.id(locatorValue);
			break;
		case LINKTEXT:
			by=By.linkText(locatorValue);
			break;
		case NAME:
			by=By.name(locatorValue);
			break;
		case PARTIALLINKTEXT:
			by=By.partialLinkText(locatorValue);
			break;
		case TAGNAME:
			by=By.tagName(locatorValue);
			break;
		case XPATH:
			by=By.xpath(locatorValue);
			break;
		default:
			break;
		}

		return by;

	}
	
	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#quitBrowser()
	 * @Version 1.01
	 * @description Quits the browser
	 */
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#quitBrowser()
	 */
	@Override
	public  void quitBrowser(){
		//WebDriverManager.getDriver() DriverManager.getDriver() = DriverManager.getDriver()Factory.getInstance().getDriverManager.getDriver()();
		DriverManager.getDriver().quit();
	}

	
	
	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#scrollToElement(org.openqa.selenium.WebElement)
	 */
	@Override
	public void scrollToElement(WebElement element){
		try{
			if(!isVisibleInViewport(element)){
				JavascriptExecutor je = (JavascriptExecutor) DriverManager.getDriver();
				je.executeScript("arguments[0].scrollIntoView(true);",element);
			}
		}catch(Exception e){}

	}
	

	/* (non-Javadoc)
	 * @see com.BDD.DemoAvatrade.Utils#isVisibleInViewport(org.openqa.selenium.WebElement)
	 */
	@Override
	public Boolean isVisibleInViewport(WebElement element) {
		return (Boolean)((JavascriptExecutor)DriverManager.getDriver()).executeScript(
				"var elem = arguments[0],                 " +
						"  box = elem.getBoundingClientRect(),    " +
						"  cx = box.left + box.width / 2,         " +
						"  cy = box.top + box.height / 2,         " +
						"  e = document.elementFromPoint(cx, cy); " +
						"for (; e; e = e.parentElement) {         " +
						"  if (e === elem)                        " +
						"    return true;                         " +
						"}                                        " +
						"return false;                            "
						, element);
	}  
	

	@Override
	public void waitforElementToBeClickable(Locator locatorType,String locatorValue){
		By element = selector(locatorType,locatorValue);
		DriverManager.getWait().until(ExpectedConditions.elementToBeClickable(element));
	}

	
	

	
	
	
	
}

