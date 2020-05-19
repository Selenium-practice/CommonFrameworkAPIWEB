package com.stepdefinition;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
public class Hooks {	
	WebDriver driver;
	
	
	//@Before
	public void beforeScenario(Scenario scenario) {
		System.out.println("Before Execution");
       /* System.setProperty("webdriver.chrome.driver","C:/Users/42131/eclipse-workspace/Selenium/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.get("https://google.com");
	    Reporter.assignAuthor("ToolsQA - Lakshay Sharma");
	*/}
	
	//@After
	public void AfterSteps() {
		//testContext.getWebDriverManager().quitDriver();
		System.out.println("After Execution");
	}
}