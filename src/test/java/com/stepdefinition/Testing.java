package com.stepdefinition;

import cucumber.api.java.en.*;

public class Testing {
	
	@Given("^I want to write a step with precondition using java$")
	public void i_want_to_write_a_step_with_precondition_using_java() throws Throwable {
	    
	System.out.println("hello");
	}

	@When("^some other precondition java$")
	public void some_other_precondition_java() throws Throwable {
	    
		System.out.println("hai");
	}


}
