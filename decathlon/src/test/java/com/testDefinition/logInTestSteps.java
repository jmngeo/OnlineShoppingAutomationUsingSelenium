package com.testDefinition;

import com.baseclass.wrapperClass;
import com.pages.loginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class logInTestSteps extends wrapperClass 
{
	loginPage loginObject = new loginPage(driver);
	
	@Given("^I am on home page$")
	public void i_am_on_home_page() throws Throwable 
	{		
		loginObject.navigateToHomePage();
	}
	
	@Given("^I am running login attempt Number \"([^\"]*)\"$")
	public void i_am_running_login_attempt_Number(String arg1) throws Throwable 
	{
		loginObject.iterator = Integer.parseInt(arg1);
	}

	@Given("^i click Sign In button$")
	public void i_click_Sign_In_button() throws Throwable
	{
		loginObject.clickSignInBtn();
	}
		
	@When("^I enter login values username and password$")
	public void i_enter_login_values_username_and_password() throws Throwable 
	{
		loginObject.enterUsernameAndPassword();
	}

	@Then("^I click logIn button$")
	public void i_click_logIn_button() throws Throwable 
	{
		loginObject.clickLogInBtn();
		loginObject.loginScreenshots();			
	}
}
