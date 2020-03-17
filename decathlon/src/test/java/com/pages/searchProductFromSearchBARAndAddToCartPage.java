package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.baseclass.wrapperClass;

public class searchProductFromSearchBARAndAddToCartPage 
{
	WebDriver driver;
	public searchProductFromSearchBARAndAddToCartPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void navigateToHomePage() 
	{
		if(!driver.getCurrentUrl().equals("https://www.decathlon.in"))
			driver.navigate().to("https://www.decathlon.in/");
	}
	
	public void productSearch(String product) 
	{
		driver.findElement(By.xpath("//input[@type=\"search\"]")).click();
		driver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys(product);		
	}
		
	public void selectFromDropDown(String fullProductName) throws InterruptedException 
	{
		wrapperClass.sleep(2);
		WebElement ul = driver.findElement(By.xpath("//ul[@class='search-suggestions show-suggestion']"));
		List<WebElement> store=ul.findElements(By.tagName("li"));
		for(int i=1;i<store.size();i++)
		{
			if(fullProductName.contains(store.get(i).findElements(By.tagName("span")).get(0).getText()))
			{
				store.get(i).click();
				break;
			}
		}
	}
	
	public void ApplyFishingFilter()
	{
		driver.findElement(By.xpath("//*[@id=\"gender\"]/div/div[1]/span/div/p")).click();
		driver.findElement(By.xpath("//input[@value='NO GENDER']")).click();
	}
	
	public void ApplySportFilter() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value=\"PREDATOR FISHING\"]")).click();
		wrapperClass.sleep(2);
	}
	
	public void ApplyProductTypeFilter() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value=\"Set\"]")).click();
		wrapperClass.sleep(2);
	}
	
	public void ApplyManufacturerFilter() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@value=\"Caperlan\"]")).click();
		wrapperClass.sleep(2);
	}

	public void FirstProductClick() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"hits\"]/div/div/ol/li/div/div/article/div/a/div[2]/img")).click();;
		wrapperClass.sleep(2);
	}
	
	public void getProductURL() 
	{
		@SuppressWarnings("unused")
		String productURL = driver.getTitle();
	}
	
	public void Add_To_Cart() throws InterruptedException
	{
		driver.findElement(By.id("pr_add_to_cart")).click();
		wrapperClass.sleep(2);
		driver.findElement(By.xpath("//strong[text()='Continue shopping']")).click();
	}	
}
