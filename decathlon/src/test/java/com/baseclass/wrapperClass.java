package com.baseclass;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class wrapperClass 
{
	public static WebDriver driver;	
	public void launchApplication(String browser, String URL)
	{
		try 
		{
			//Launch chrome Browser
			if(browser.equalsIgnoreCase("chrome"))
			{
				//Chrome driver root path integration
				System.setProperty("webdriver.chrome.driver", "src//test//resources//com//drivers//chromedriver.exe");
				//Creating an object for chrome Browser
				driver = new ChromeDriver();
			}
			
			//Launch firefox Browser
			else if(browser.equalsIgnoreCase("firefox"))
			{
				//Gecko driver root path integration
				System.setProperty("webdriver.gecko.driver", "src//test//resources//com//drivers//geckodriver.exe");
				//Creating an object for firefox Browser
				driver = new FirefoxDriver();
			}
			
			//Launch edge Browser
			else if(browser.equalsIgnoreCase("edge"))
			{
				//edge driver root path integration
				System.setProperty("webdriver.edge.driver", "src//test//resources//com//drivers//msedgedriver.exe");
				//Creating an object for edge Browser
				driver = new EdgeDriver();
			}
			
			
			//To maximize the window
			driver.manage().window().maximize();
			//To create implicit time waits
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			//To get the application URL
			driver.get(URL);
		}
		catch(WebDriverException e)
		{
			System.out.println("browser could not be instantiated " + e);
		}
	}
	
	//To take Screenshot
	public static void screenShot(String path) throws IOException
	{
		  TakesScreenshot screen = ((TakesScreenshot)driver);
		  File source = screen.getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(source, new File(path));
	}
	
	//to sleep the application for a specific timeOut in seconds
	public static void sleep(int timeout) throws InterruptedException 
	{
		TimeUnit.SECONDS.sleep(timeout);
	}
	
	//To close the browser
	public void quit()
	{
		driver.quit();
	}
}
