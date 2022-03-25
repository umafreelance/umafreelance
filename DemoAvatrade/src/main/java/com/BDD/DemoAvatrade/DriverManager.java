package com.BDD.DemoAvatrade;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;




public class DriverManager {

	private static ThreadLocal<WebDriver> ThreadDriver=new ThreadLocal<WebDriver>() ;
	private static final ThreadLocal<WebDriverWait> wait = new ThreadLocal<WebDriverWait>();
	static DataProvider data = new DataProvider();
	public static String browserType;
	public static String browserName;
	@SuppressWarnings("deprecation")
	public static WebDriver getDriver(){
		WebDriver driver= DriverManager.ThreadDriver.get();
		try{
			if (driver==null){
				switch(browserType){
				case "Chrome":
					String path=System.getProperty("user.dir") +"/Drivers/chromedriver.exe";
					System.out.println("Driver Path **** "+path);
					System.setProperty("webdriver.chrome.driver",path); 
					try {
						DesiredCapabilities cap = DesiredCapabilities.chrome();
						cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
						driver = new EventFiringWebDriver(new ChromeDriver(cap));
					} catch (Exception e) {
						path=System.getProperty("user.dir") +"/Drivers/chromedriver";
						System.out.println("Driver Path **** "+path);
						System.setProperty("webdriver.chrome.driver",path); 
						driver = new EventFiringWebDriver(new ChromeDriver());
					}
					
					System.out.println("created driver *** "+driver);
					break;
				
				
				}
			}
			driver.manage().window().maximize();
			ThreadDriver.set(driver);
			wait.set(new WebDriverWait(driver, 90));
//			System.out.println(driver.getTitle());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}

	public static WebDriverWait getWait(){
		return wait.get();
	}


	public static void setupDriver(String browser){
		System.out.println("Browser is **** "+browser);
		browserType=browser;
	}		

	
	public static void quitDriver(){
		getDriver().quit();
		DriverManager.ThreadDriver.set(null);
	}

}



