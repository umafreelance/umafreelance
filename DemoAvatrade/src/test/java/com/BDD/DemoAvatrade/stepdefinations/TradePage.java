package com.BDD.DemoAvatrade.stepdefinations;

import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.BDD.DemoAvatrade.Locators.Locator;
import com.BDD.DemoAvatrade.LogFileControl;
import com.BDD.DemoAvatrade.utility.Base;

import cucumber.api.java.en.*;



public class TradePage extends Base{
	

public static final String closeButton_xpath = "//button[contains(@class,'close-button.child_container')]"; 	
public static final String skipTutorial_xpath = "//span[text()='Skip Tutorial']"; 		
public static final String tradeIcon_xpath = "//a[@href='/trade']"; 	
public static final String cryptoOption_xpath = "//a[@href='/trade/crypto']"; 	
public static final String FavTab_xpath = "//a//div[text()='Favorites']"; 	
public static final String symbol_xpath = "//tbody/tr//td//div[contains(@class,'symbolCell')]/span"; 	
	
	
	
	
	@Then("^I navigate to Trade tab$")
	public static void navigateToTrade() throws Exception {
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, closeButton_xpath);
		seleniumUtils.Click(Locator.XPATH, closeButton_xpath, "Home", "Close");
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, skipTutorial_xpath);
		seleniumUtils.Click(Locator.XPATH, skipTutorial_xpath, "Home", "Skip Tutorial");
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, tradeIcon_xpath);
		seleniumUtils.Click(Locator.XPATH, tradeIcon_xpath, "Home", "Trade");
	}
	
	@Then("^I navigate to Crypto option$")
	public static void navigateToCry() throws Exception {
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, cryptoOption_xpath);
		seleniumUtils.Click(Locator.XPATH, cryptoOption_xpath, "Trade", "Crypto option");
	}
	
	@Then("^I navigate to favorite option$")
	public static void navigateToFav() throws Exception {
		seleniumUtils.waitforElementToBeClickable(Locator.XPATH, FavTab_xpath);
		seleniumUtils.Click(Locator.XPATH, FavTab_xpath, "Trade", "Favorites");
	}
	
	public static List<String> symbolList= new ArrayList<String>() ;
	
	@Then("^I mark some of the crypto as my favorite$")
	public static void markItAsFev() {
		try {
			int availableCryptoSize = seleniumUtils.Size(Locator.XPATH, "//tbody/tr");
			symbolList.clear();
			List<Integer> rows= new ArrayList<Integer>();
			Random rnd = new Random();
			for(int i=0;i<5;i++) {
				int r;
					r= rnd.nextInt(availableCryptoSize-1)+1;
				while(rows.contains(r)) {
					r= rnd.nextInt(availableCryptoSize-1)+1;
				}
				seleniumUtils.MoveToElement(Locator.XPATH, "//tbody/tr["+r+"]");
				Thread.sleep(1000);
				seleniumUtils.Click(Locator.XPATH, "//tbody/tr["+r+"]//td//div[contains(@class,'watchlist-entity.component_favCell')]", "Trade", "Fav Icon - row "+r);
				Thread.sleep(1000);//too fast so that providing hard wait time
				String symbol = seleniumUtils.GetText(Locator.XPATH, "//tbody/tr["+r+"]//td//div[contains(@class,'symbolCell')]/span");
				rows.add(r);
				symbolList.add(symbol);
				LogFileControl.logInfo("Crypto option", symbol+" marked as favorite");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Then("^I verify the newly favorite cryptos in favorites tab$")
	public static void verifyCrypto() {
		try {
			int availableCryptoSize = seleniumUtils.Size(Locator.XPATH, "//tbody/tr");
			seleniumUtils.MoveToElement(Locator.XPATH, "//tbody/tr["+availableCryptoSize+"]");
			String data="";
			boolean flag = false;
			for(int i=0;i<symbolList.size();i++) {
				Thread.sleep(1000);
				if(seleniumUtils.IsDisplayed(Locator.XPATH, "//div[contains(@class,'symbolCell')]//span[text()='"+symbolList.get(i).trim()+"']"))
					flag = true;
				else {
					flag = false;
					data = symbolList.get(i).trim();
					break;
				}
					
			}
			if(flag) {
				LogFileControl.logPass("Verify the newly favorite cryptos in favorites tab", "All favorite cryptos are available in the favorites tab");
			}else {
				LogFileControl.logFailwithScreenCapture("Verify the newly favorite cryptos in favorite tab", "All favorite cryptos are not available in the favorites tab, "+data+" not found in favourite tab");
			}
			assertTrue(flag, "All favorite cryptos are not available in the favorites tab");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Then("^I remove cryptos from favorite$")
	public static void removeFromFev() {
		try {
			int availableCryptoSize = seleniumUtils.Size(Locator.XPATH, "//tbody/tr");
			seleniumUtils.MoveToElement(Locator.XPATH, "//tbody/tr["+availableCryptoSize+"]");
			for(int i=0;i<symbolList.size();i++) {
				seleniumUtils.Click(Locator.XPATH, "//div[contains(@class,'symbolCell')]//span[text()='"+symbolList.get(i).trim()+"']//following::div[contains(@class,'watchlist-entity.component_favCell')][1]", "Trade", "Fav Icon - Symbol "+symbolList.get(i).trim());
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
