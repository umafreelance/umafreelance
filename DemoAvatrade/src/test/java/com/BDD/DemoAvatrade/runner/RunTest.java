package com.BDD.DemoAvatrade.runner;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.BDD.DemoAvatrade.ExtentManager;
import com.BDD.DemoAvatrade.ExtentTestManager;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;




@CucumberOptions(features={"src//test//java//com//BDD//DemoAvatrade//features"}
					,glue={"com.BDD.DemoAvatrade.stepdefinations","com.BDD.DemoAvatrade.utility"}
					,plugin = {"pretty", "html:target/cucumber"}
					
					
		)
@Test
public class RunTest extends AbstractTestNGCucumberTests{

}






