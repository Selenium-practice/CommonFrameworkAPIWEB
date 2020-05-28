package com.testCases;


import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pages.LoginPage;
import com.web.util.ReadProperty;
import com.web.util.Webutils;

public class TC1 {
	
	ReadProperty read = new ReadProperty();	
	@BeforeSuite
	public void invokeBrowser()
	{
		LoginPage.initiateBrowser("chrome");
	}
	
	@Test
	public void TestCase1() {		
		
		new LoginPage(Webutils.getDriver()).launchOnboardingUrl("QA").enterUserName(read.getProperty("userName"))
		.enterPassword(read.getProperty("password")).clickOnLoginBtnb().closeWindow();
		
	/*	lp.launchOnboardingUrl("QA");
		lp.enterUserName(read.getProperty("userName"));
		lp.enterPassword(read.getProperty("password"));
		lp.clickOnLoginBtnb();
		lp.closeWindow();*/
		
	}

}
