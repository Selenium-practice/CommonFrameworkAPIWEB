package com.stepdefinition;

import org.testng.Assert;

import cucumber.api.java.en.*;

public class sample{

	@Given("^I want to write a step with precondition$")
	public void i_want_to_write_a_step_with_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	    
	    System.out.println("korada");
	}

	@When("^some other precondition$")
	public void some_other_precondition() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("hareesh");
	}

	@Then("^check success$")
	public void check_success() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
      
	  System.out.println("harish");
	}

	@Then("^hhhhhhh$")
	public void hhhhhhh() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}



}

