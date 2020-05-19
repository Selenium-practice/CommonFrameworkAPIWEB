package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.web.util.ReadProperty;
import com.web.util.Webutils;

public class LoginPage extends Webutils {

	ReadProperty read = new ReadProperty();
	String QA = "QA";
	private By Username = By.xpath("//input[@name='userName']");
	private By Password = By.xpath("//input[@name='password']");
	private By loginBtn = By.xpath("//input[@name='login']");
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void launchOnboardingUrl(String env) {
		switch (env) {
		case "QA":
			navigateUrl(read.getProperty("URL"));
			break;
		case "DEV":
			navigateUrl(read.getProperty("Dev_URL"));
			break;
		default:
			navigateUrl(read.getProperty("Onboarding"));
			break;
		}

	}

	public void enterUserName(String text) {
		enterTextinTextbox(getElement(Username), text);
	}
	
	public void enterPassword(String text) {
		enterTextinTextbox(getElement(Password), text);
	}

	public void clickOnLoginBtnb()

	{
		getElement(loginBtn).click();
	}

	
}