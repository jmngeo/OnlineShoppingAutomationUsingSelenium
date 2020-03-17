package com.testDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.wrapperClass;
import com.pages.cartManagementPage;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class cartManagementTestSteps extends wrapperClass
{
	cartManagementPage object = new cartManagementPage(driver);
	ExtentTest test = report.startTest("cartManagementTest");
	
	@Given("^I am on homepage$")
	public void i_am_on_homepage() throws Throwable 
	{
		object.navigateToHomePage();
		logger("user is in home page");
	}

	@When("^I click cart button$")
	public void i_click_cart_button() throws Throwable 
	{
		object.clickCartBtn();
		logger("user clicks cart button");
	}

	@Then("^I validate if the cart is empty or not$")
	public void i_validate_if_the_cart_is_empty_or_not() throws Throwable 
	{
	    object.validateDriverTitle("Cart");
	    logger("user checks the cart");
	}

	@Given("^I am on cart page$")
	public void i_am_on_cart_page() throws Throwable 
	{
	    if(!driver.getTitle().equalsIgnoreCase("Cart"))
	    {
	    	driver.navigate().to("https://www.decathlon.in/cart?action=show");
	    	logger("user is on the cart page");
	    }
	}
	
	@Then("^I increase the product quantity by one$")
	public void i_increase_the_product_quantity_by_one() throws Throwable 
	{
		List<WebElement> cartItems = driver.findElements(By.xpath("//input[@class=\"js-cart-line-product-quantity form-control\"]"));
	    for(WebElement cartItem : cartItems )
	    {  
	    	int currentCartItemCount = Integer.parseInt(cartItem.getAttribute("value"));
	    	int newCartItemCount = (currentCartItemCount + 1);
	    	String newCount = Integer.toString(newCartItemCount);
	    	cartItem.clear();
	    	cartItem.sendKeys(newCount);
	    }
	    logger("user icreases the cart quantity by one");
	}
	
	@Given("^I am on the cart page$")
	public void i_am_on_the_cart_page() throws Throwable
	{
		sleep(5);
	    if(!driver.getTitle().equalsIgnoreCase("Cart"))
	    {
	    	driver.navigate().to("https://www.decathlon.in/cart?action=show");
	    	logger("user is on the cart page");
	    }
	}
	
	@Given("^I click Proceed To CheckOut button$")
	public void i_click_Proceed_To_CheckOut_button() throws Throwable 
	{
		driver.findElement(By.xpath("//span[text()='Proceed to checkout']")).click();
		logger("user clicks the proceed to checkout button");
	}

	@Given("^I click on Select Delivery Options$")
	public void i_click_on_Select_Delivery_Options() throws Throwable 
	{
		if(driver.findElement(By.id("confirm-addresses")).isDisplayed())
		{			
			driver.findElement(By.id("confirm-addresses")).click();
			sleep(5);
			logger("user opt for the delivery option");
		}		
	}

	@Given("^I select Home Delivery as Standard$")
	public void i_select_Home_Delivery_as_Standard() throws Throwable 
	{
		driver.findElement(By.xpath("//input[@id='delivery_option_7039']/following-sibling::*[1]")).click();
		sleep(2);
		driver.findElements(By.xpath("//div[@class=\"popup-address w-100\"]")).get(1).click();
		sleep(5);
		logger("user selects standard home delivery option");
	}

	@When("^I click Pay Securely$")
	public void i_click_Pay_Securely() throws Throwable 
	{
		driver.findElement(By.xpath("//a[@id=\"proceed_to_checkout\"]")).click();
		sleep(3);
		logger("user selects pay securely option");
	}

	@When("^I click on UPI/QR$")
	public void i_click_on_UPI_QR() throws Throwable 
	{
		driver.switchTo().frame(driver.findElement(By.xpath("//*[@id=\"checkout\"]/div[3]/iframe")));
		driver.findElement(By.xpath("//button[@method='upi']")).click();
		sleep(2);
		
		driver.findElement(By.id("modal-close")).click();
		logger("user selects UPI option");
		test.log(LogStatus.PASS, "Selected Payment Method Successfully");
	}

	@Then("^I navigate back to homepage$")
	public void i_navigate_back_to_homepage() throws Throwable
	{
		driver.navigate().to("https://www.decathlon.in/");
		logger("user navigates back to home page");
	}

	@Then("^I LogOut$")
	public void i_LogOut() throws Throwable 
	{
		Actions action = new Actions(driver);		
		action.moveToElement(driver.findElement(By.xpath("//div[@class=\"desktop_account\"]"))).build().perform();;
		driver.findElement(By.xpath("//span[text()='Logout']")).click();
		
		logger("user opts for logout option");
		
		report.endTest(test);
		report.flush();
	}

}
