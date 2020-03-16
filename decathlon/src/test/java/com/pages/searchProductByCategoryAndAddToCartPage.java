package com.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.baseclass.wrapperClass;
import com.excelUtility.excelReadWrite;

public class searchProductByCategoryAndAddToCartPage 
{
	WebDriver driver;
	public searchProductByCategoryAndAddToCartPage (WebDriver driver) 
	{
		this.driver = driver;
	}
	
	int totalRows;
	int totalColumns;
	String InputCategory;
	String SubCategory1;
	String SubCategory1_XPath;
	String SubCategory2;
	String SubCategory2_XPath;
	String ProductName;
	String ProductSize;
	String PINCode;
	String ProductID;
	
	excelReadWrite excel;
	String excelPath = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\testdata\\keyword Driven.xlsx";
	
	Actions action;
	
	public void navigateToHomePage() 
	{
		driver.navigate().to("https://www.decathlon.in/");
	}
	
	public void searchProductAndAddToCart() throws IOException, InterruptedException
	{
		excel = new excelReadWrite(excelPath);
		totalRows = excel.getTotalRows("Sheet2");
		totalColumns = excel.getTotalcolumns("Sheet2");
		
		for(int row = 1; row <= totalRows; row++)
		{			
			if(excel.readExcelData("Sheet2",row, 0).equals("SEARCH AND ADD TO CART"))
			{				
				for(int column = 1; column < totalColumns; column++)
				{
					if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("CATEGORY"))
					{
						InputCategory=excel.readExcelData("Sheet2",row, column);	
						driver.findElement(By.xpath("//button[@tabindex='1']")).click();
						List<WebElement> categories = driver.findElements(By.xpath("//div[@class='part-1']")).get(0).findElements(By.tagName("ul"));
						for(WebElement element : categories)
						{
							if(element.findElement(By.tagName("a")).getText().equalsIgnoreCase(InputCategory))
							{								
								element.findElement(By.tagName("a")).click();
								break;
							}
						}
					}
					
					else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("SUB CATEGORY 1"))
					{					
						SubCategory1 =excel.readExcelData("Sheet2",row, column);
						SubCategory1_XPath = "//a[text()=\"" + SubCategory1 + "\"]";						
						driver.findElement(By.xpath(SubCategory1_XPath)).click();
					}
					
					else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("SUB CATEGORY 2"))
					{
						SubCategory2 =excel.readExcelData("Sheet2",row, column);
						SubCategory2_XPath = "//a[text()=\"" + SubCategory2 + "\"]";						
						driver.findElement(By.xpath(SubCategory2_XPath)).click();
					}
					
					else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("PRODUCT NAME"))
					{
						ProductName = excel.readExcelData("Sheet2",row, column);

						action = new Actions(driver);
						action.sendKeys(Keys.PAGE_DOWN).build().perform();
						wrapperClass.sleep(2);action.sendKeys(Keys.DOWN).build().perform();
						wrapperClass.sleep(1);action.sendKeys(Keys.DOWN).build().perform();
						wrapperClass.sleep(1);action.sendKeys(Keys.DOWN).build().perform();
						wrapperClass.sleep(1);action.sendKeys(Keys.DOWN).build().perform();
						
						List<WebElement> products = driver.findElements(By.xpath("//div[@class='ais-Hits']"));						
						for(WebElement element : products)
						{
							List<WebElement> productsList = element.findElements(By.tagName("h4"));
							for(WebElement productElement : productsList)
							{
								if(productElement.getText().equalsIgnoreCase(ProductName))
								{
									productElement.click();
									break;
								}
							}				
						}						
					}
					
					else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("SIZE"))
					{
						wrapperClass.sleep(3);
						ProductSize = excel.readExcelData("Sheet2",row, column);
						driver.findElements(By.xpath("//button[@id='select_size']")).get(1).click();
						List<WebElement> productSizes = driver.findElements(By.xpath("//li[@class='input-container ']"));
						for(int i =(productSizes.size()/2)-1;i<productSizes.size();i++)
						{
							if(productSizes.get(i).findElement(By.tagName("span")).getText().equalsIgnoreCase(ProductSize))
							{
								productSizes.get(i).click();
								break;
							}
						}
					}
					
					else if(excel.readExcelData("Sheet2",0,column).equalsIgnoreCase("PIN CODE"))
					{
						PINCode = excel.readExcelData("Sheet2",row, column);
						
						action = new Actions(driver);
						action.sendKeys(Keys.PAGE_DOWN).build().perform();
						
						wrapperClass.sleep(2);
						driver.findElement(By.xpath("//button[@id='modal_id']")).click();
						WebElement PIN = driver.findElement(By.xpath("//input[@class='input_pincode']"));
						PIN.clear();
						PIN.sendKeys(PINCode);
						
						driver.findElement(By.xpath("//button[@class='save_pincode']")).click();
						
						//To add to cart
						wrapperClass.sleep(3);
						action.sendKeys(Keys.PAGE_UP).build().perform();
						wrapperClass.sleep(4);
						driver.findElement(By.xpath("//*[@id='pr_add_to_cart']")).click();
						
						//To continue shopping
						wrapperClass.sleep(5);
						driver.findElement(By.xpath("//strong[text()='Continue shopping']")).click();
						
						//To write the PRODUCT ID to excel
						ProductID = driver.findElement(By.xpath("//h5[@class=\"ref_id\"]")).getText().split(" ")[1];
						excel.writeExcelData("Sheet2",row, (column+2), ProductID);
					}
				}
			}
		}
	}
}
