package com.testDefinition;

import com.baseclass.wrapperClass;
import com.pages.searchProductByCategoryAndAddToCartPage;
import com.relevantcodes.extentreports.ExtentTest;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class searchProductByCategoryAndAddToCartTestSteps extends wrapperClass
{		
	searchProductByCategoryAndAddToCartPage object = new searchProductByCategoryAndAddToCartPage(driver);
	ExtentTest test = report.startTest("cartManagementTest");
	
	@Given("^I am on homePage$")
	public void i_am_on_homePage() throws Throwable 
	{
		object.navigateToHomePage();
		logger("user is in home page");
	}

	@Then("^I search a product by category and adding to cart$")
	public void i_search_a_product_by_category_and_adding_to_cart() throws Throwable 
	{		
		object.searchProductAndAddToCart();
		logger("user searches the product and adds to the cart");
		
		report.endTest(test);
		report.flush();
	}
}
