package com.testCases;


import com.pages.LoginPage;
import com.web.util.ReadProperty;
import com.web.util.Webutils;

public class TC1 {
	public static void main(String[] args) {
		LoginPage lp=new LoginPage(Webutils.getDriver());
		ReadProperty read = new ReadProperty();
		
		lp.initiateBrowser("chrome");
		lp.launchOnboardingUrl("QA");
		lp.enterUserName(read.getProperty("userName"));
		lp.enterPassword(read.getProperty("password"));
		lp.clickOnLoginBtnb();
		
	}

}
