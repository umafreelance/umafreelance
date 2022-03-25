package com.BDD.DemoAvatrade;


import org.testng.ITestContext;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentManager {

	public static ExtentReports extent;
	@SuppressWarnings("unused")
	private static ITestContext context;
	static SuppotLibrary suppotLibrary = new SuppotLibrary();

	public synchronized static ExtentReports getInstance() {
		if (extent == null) {
			String reportPath=suppotLibrary.getReportPath();
			extent = new ExtentReports(reportPath,false,suppotLibrary.getnetWorkmode());
		}

		return extent;
	}

	public static void setOutputDirectory(ITestContext context) {
		ExtentManager.context = context;
	}
}
