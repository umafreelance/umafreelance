package com.BDD.DemoAvatrade.utility;

import com.BDD.DemoAvatrade.DriverManager;
import com.BDD.DemoAvatrade.ExtentManager;
import com.BDD.DemoAvatrade.ExtentTestManager;
import com.BDD.DemoAvatrade.LogFileControl;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hook {
	private static String scenarioName;
	
	@Before("smoke")
	public void extentSetup() {
		try {
			//ExtentManager.setOutputDirectory(context);
			ExtentTestManager.extent = ExtentManager.getInstance();
			org.apache.log4j.PropertyConfigurator.configure(System.getProperty("user.dir") + "\\Log4j.properties");
			LogFileControl.logInfo(" Suite Started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Before
	public void setUp(Scenario scenario)
	{
		
		DriverManager.setupDriver(Base.dataProvider.getConfigPropertyval("Browser"));
		scenarioName=scenario.getName();
		String csvFileName = null;
		if(scenarioName.contains("_")) {
			csvFileName = scenarioName.split("_")[0];
		}else {
			LogFileControl.logInfo("Scenario Name is not as per Standared!!!");
		}
		Base.setCSVFileName(csvFileName);
		System.out.println("smoke before");
		Base.setScriptId(scenarioName);
		ExtentTestManager.setlogger(ExtentTestManager.startTest(Base.getScriptId()));
		
	}
	
	@After("smoke")
	public void afterSuite() {
		try{
			ExtentTestManager.extent.close();
			LogFileControl.logInfo(" Suite Ended");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@After
	public void tearDown()
	{
		ExtentTestManager.endTest();  // new
		ExtentTestManager.extent.flush();
		DriverManager.quitDriver();
	}
	
	public static String getScenarioName()
	{
		return scenarioName;
	}
}
