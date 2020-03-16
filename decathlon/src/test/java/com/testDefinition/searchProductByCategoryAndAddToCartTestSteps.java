package com.testDefinition;

import com.baseclass.wrapperClass;
import com.pages.searchProductByCategoryAndAddToCartPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class searchProductByCategoryAndAddToCartTestSteps extends wrapperClass
{		
	searchProductByCategoryAndAddToCartPage object = new searchProductByCategoryAndAddToCartPage(driver);
	
	@Given("^I am on homePage$")
	public void i_am_on_homePage() throws Throwable 
	{
		object.navigateToHomePage();
	}

	@Then("^I search a product by category and adding to cart$")
	public void i_search_a_product_by_category_and_adding_to_cart() throws Throwable 
	{		
		object.searchProductAndAddToCart();
	}
}
