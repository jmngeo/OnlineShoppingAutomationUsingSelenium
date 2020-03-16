package com.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import com.baseclass.wrapperClass;
import com.excelUtility.excelReadWrite;

public class loginPage 
{
	WebDriver driver;
	Actions action;
	
	excelReadWrite excel;
	String excelPath = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\testdata\\keyword Driven.xlsx";	
	
	public int iterator;
	int totalRows;
	int totalColumns;
	
	public loginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	public void navigateToHomePage() 
	{
		driver.navigate().to("https://www.decathlon.in/");
	}
	
	public void clickSignInBtn()
	{
		driver.findElement(By.xpath("//span[text()='Sign in']")).click();
	}
	
	public void enterUsernameAndPassword() throws IOException 
	{
		excel = new excelReadWrite(excelPath);
		totalRows = excel.getTotalRows("Sheet1");
		totalColumns = excel.getTotalcolumns("Sheet1");
		
		System.out.println("iterator  " + iterator);
		for(int column = 0; column < 2; column++)
		{
			if(excel.readExcelData("Sheet1",0,column).equalsIgnoreCase("USERNAME"))
			{
				driver.findElement(By.id("login-username")).sendKeys(excel.readExcelData("Sheet1",iterator, column));
			}
			else if(excel.readExcelData("Sheet1",0,column).equalsIgnoreCase("PASSWORD"))
			{
				driver.findElement(By.id("login-password")).sendKeys(excel.readExcelData("Sheet1",iterator, column));
			}						
		}		
	}
	
	public void clickLogInBtn()
	{
		driver.findElement(By.id("presta-btn-login")).click();
	}
	public void loginScreenshots() throws IOException, InterruptedException
	{		
		switch (iterator)
		{
			case 1: if(driver.findElements(By.xpath("//div[text()='Authentication failed']")).size() != 0 )
					{
						String path = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\screenshots\\LoginAttempt" + iterator + ".jpg";
						wrapperClass.screenShot(path);
						
						excel.writeExcelData("Sheet1",iterator, 3, driver.findElement(By.xpath("//div[text()='Authentication failed']")).getText());
					}
					break;
			
			case 2: if(driver.findElements(By.xpath("//div[text()='Password can not be empty.']")).size() != 0 )
			{
				String path = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\screenshots\\LoginAttempt" + iterator + ".jpg";
				wrapperClass.screenShot(path);
				
				excel.writeExcelData("Sheet1",iterator, 3, driver.findElement(By.xpath("//div[text()='Password can not be empty.']")).getText());
			}
					break;
			
			case 3: if(driver.findElements(By.xpath("//div[text()='Please enter your Email.']")).size() != 0 )
			{
				String path = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\screenshots\\LoginAttempt" + iterator + ".jpg";
				wrapperClass.screenShot(path);
				
				excel.writeExcelData("Sheet1",iterator, 3, driver.findElement(By.xpath("//div[text()='Please enter your Email.']")).getText());
			}
					break;
			
			case 4: if(driver.findElements(By.xpath("//div[text()='Please enter your Email.']")).size() != 0 )
			{
				String path = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\screenshots\\LoginAttempt" + iterator + ".jpg";
				wrapperClass.screenShot(path);
				
				excel.writeExcelData("Sheet1",iterator, 3, driver.findElement(By.xpath("//div[text()='Please enter your Email.']")).getText());
			}
					break;
			case 5: if(driver.findElements(By.xpath("//div[text()='Successfully Login.']")).size() != 0 )
			{
				wrapperClass.sleep(3);
				String path = "C:\\Users\\jomon\\Desktop\\Project\\decathlon\\src\\test\\resources\\com\\screenshots\\LoginAttempt" + iterator + ".jpg";
				wrapperClass.screenShot(path);
				
				excel.writeExcelData("Sheet1",iterator, 3, "Successfully Login.");
			}
					break;
		}
	}
}
