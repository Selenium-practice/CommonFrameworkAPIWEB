package com.stepdefinition;

import cucumber.api.java.en.*;

public class sample1 {
	@Given("^user login$")
	public void user_login() throws Throwable {
	   System.out.println("Hi");
	}

	@When("^printing hai$")
	public void printing_hai() throws Throwable {
	    System.out.println("Hello");
	}

	
	


}
