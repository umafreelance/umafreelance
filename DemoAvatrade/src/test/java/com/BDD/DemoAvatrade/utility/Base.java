/**
 * 
 */
package com.BDD.DemoAvatrade.utility;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


import com.BDD.DemoAvatrade.DataProvider;
import com.BDD.DemoAvatrade.DriverManager;
import com.BDD.DemoAvatrade.LogFileControl;
import com.BDD.DemoAvatrade.ReadCSV;
import com.BDD.DemoAvatrade.SeleniumUtils;
import com.BDD.DemoAvatrade.SuppotLibrary;
import com.BDD.DemoAvatrade.Utils;



public class Base {
	private static String scenarioName;


	public static Utils seleniumUtils = new SeleniumUtils();
	public static DataProvider dataProvider = new DataProvider();
	public static DriverManager driverManager = new DriverManager();
	public static ReadCSV readCSV = new ReadCSV();
	public static SuppotLibrary suppotLibrary = new SuppotLibrary();
	public static ThreadLocal<String> threadscriptId=new ThreadLocal<String>() ;
	public static ThreadLocal<String> threadmethodName=new ThreadLocal<String>() ;
	static Base base=new Base();
	public static String url=null , browser = null, environment = null, group = null,parallelCount =null;
	//	public static ExtentReports extentReports;

	public static String getScriptId(){
		return (threadscriptId.get());
	}
	public static void setScriptId(String value) {
		threadscriptId.set(new String(value));
		LogFileControl.setScriptId_report(value);
	}


	private static final ThreadLocal<String> csvFileName = new ThreadLocal<String>();

	public static String getCSVFileName() {
		return (csvFileName.get());
	}

	public static void setCSVFileName(String value) {
		csvFileName.set(new String(value));
	}

	
	public static String getMailID() {
        String CHARS = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder id = new StringBuilder();
        Random rnd = new Random();
        while (id.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * CHARS.length());
            id.append(CHARS.charAt(index));
        }
        String saltStr = id.toString();
        return saltStr+"@testdemo.com";

    }
	
	public static String getCSVData(String columnName) {
		String data = null;
		data = readCSV.getCSVValue(getCSVFileName(), getScriptId(), columnName);
		return data;
	}


}
