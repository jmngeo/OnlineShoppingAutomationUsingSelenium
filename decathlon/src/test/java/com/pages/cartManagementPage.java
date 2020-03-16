package com.pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartManagementPage 
{
	WebDriver driver;
	public cartManagementPage (WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void navigateToHomePage() 
	{
		driver.navigate().to("https://www.decathlon.in/");
	}
	public void clickCartBtn()
	{
		driver.findElement(By.xpath("//span[@class=\"cart_name\"]")).click();
	}
	public void validateDriverTitle(String title) 
	{
		assertTrue(driver.getTitle().equals(title),"Cart Empty and Not Clickable");
	}
}
