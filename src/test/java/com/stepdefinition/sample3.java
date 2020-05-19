package com.stepdefinition;

import cucumber.api.java.en.*;

public class sample3 {
	
	@Given("^I want to write a steep with \"(.*?)\"$")
	public void i_want_to_write_a_steep_with(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println(arg1);
	}

	@When("^I check forr the \"(.*?)\" in step$")
	public void i_check_forr_the_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println(arg1);
	}

	@Then("^I verify theee \"(.*?)\" in step$")
	public void i_verify_theee_in_step(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		System.out.println(arg1);
	}



}
