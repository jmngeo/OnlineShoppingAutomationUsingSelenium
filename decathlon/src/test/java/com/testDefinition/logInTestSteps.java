package com.testDefinition;

import com.baseclass.wrapperClass;
import com.pages.loginPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class logInTestSteps extends wrapperClass
{
	loginPage loginObject = new loginPage(driver);
	ExtentTest test = report.startTest("logInTest");
	
	@Given("^I am on home page$")
	public void i_am_on_home_page() throws Throwable 
	{		
		loginObject.navigateToHomePage();
		logger("user is in home page");
	}
	
	@Given("^I am running login attempt Number \"([^\"]*)\"$")
	public void i_am_running_login_attempt_Number(String arg1) throws Throwable 
	{
		loginObject.iterator = Integer.parseInt(arg1);
		
		if((loginObject.iterator==1) || (loginObject.iterator==2) || (loginObject.iterator==3) || (loginObject.iterator==4) )
		{
			test.log(LogStatus.FAIL, "Authentication Failed");
		}
		else
		{
			test.log(LogStatus.PASS, "Successfully Logged in");
		}
	}

	@Given("^i click Sign In button$")
	public void i_click_Sign_In_button() throws Throwable
	{
		loginObject.clickSignInBtn();
		logger("user clicks sign in ");
	}
		
	@When("^I enter login values username and password$")
	public void i_enter_login_values_username_and_password() throws Throwable 
	{
		loginObject.enterUsernameAndPassword();
		logger("user enters username and password");
	}

	@Then("^I click logIn button$")
	public void i_click_logIn_button() throws Throwable 
	{
		loginObject.clickLogInBtn();
		logger("user clicks login");
		loginObject.loginScreenshots();	
		logger("user takes screenshots");
		
		loginObject.setSTATUS();
		
		report.endTest(test);
		report.flush();
	}
}
