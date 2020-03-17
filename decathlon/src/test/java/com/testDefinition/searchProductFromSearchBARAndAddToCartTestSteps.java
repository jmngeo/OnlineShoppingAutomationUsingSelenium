package com.testDefinition;

import com.baseclass.wrapperClass;
import com.pages.searchProductFromSearchBARAndAddToCartPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class searchProductFromSearchBARAndAddToCartTestSteps extends wrapperClass
{
	searchProductFromSearchBARAndAddToCartPage object = new searchProductFromSearchBARAndAddToCartPage(driver);
	ExtentTest test = report.startTest("searchProductFromSearchBARAndAddToCartPageTest");
	
	@Given("^I am on the homepage to do a single keyword search$")
	public void i_am_on_the_homepage_to_do_a_single_keyword_search() throws Throwable 
	{
		object.navigateToHomePage();
		logger("user is in the home page");
	}

	@When("^I do a single keyword search for \\(\\.\\.\\.\\)$")
	public void i_do_a_single_keyword_search_for() throws Throwable 
	{
	   object.productSearch("fishing");
	   logger("user searches for an item");
	}
	
	@Given("^I have search a keyword and then i select from dropdown$")
	public void i_have_search_a_keyword_and_then_i_select_from_dropdown() throws Throwable
	{
		object.selectFromDropDown("fishing set");
		logger("user selects an item from the dropdown");
	}
	
	@When("^I filter on \\(\\.\\.\\.\\)$")
	public void i_filter_on() throws Throwable 
	{
	    object.ApplyFishingFilter();
	    logger("user applies the fishing filter");
	    object.ApplySportFilter();
	    logger("user applies sport filter");
	    object.ApplyProductTypeFilter();
	    logger("user applies product type filter");
	    object.ApplyManufacturerFilter();
	    logger("user applies manufacture filter");
	}

	@Given("^I select one of the items$")
	public void i_select_one_of_the_items() throws Throwable 
	{
		object.FirstProductClick();
		logger("user clicks on the image");
	}

	@When("^I am on the Product detail page of the selected item$")
	public void i_am_on_the_Product_detail_page_of_the_selected_item() throws Throwable 
	{
	    object.getProductURL();
	}

	@Then("^I can see details of the product$")
	public void i_can_see_details_of_the_product() throws Throwable 
	{
	  object.Add_To_Cart();
	  logger("user adds the product to the cart");
	  test.log(LogStatus.PASS, "Successfully Added to the cart");
	  	  
	  report.endTest(test);
	  report.flush();
	}

}
