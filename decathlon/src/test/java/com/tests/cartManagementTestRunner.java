package com.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.baseclass.wrapperClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@CucumberOptions(
		features="src/test/resources/com/features",
		tags = {"@cartEmptinessCheck,@IncreasingProductQuantity,@CheckOut"},
		glue={"com.testDefinition"},
		format=
				{"pretty",
				"html:target/cucumber-reports/cucumber-pretty",
				"json:target/cucumber-reports/CucumberTestReport.json",
				"rerun:target/cucumber-reports/re-run.txt"}
		)
public class cartManagementTestRunner extends wrapperClass
{
	private TestNGCucumberRunner testRunner;
	
	@BeforeClass
	public void setUP()
	{
		testRunner = new TestNGCucumberRunner(cartManagementTestRunner.class);			
	}
	
	@Test(description="login",dataProvider="features")
	public void login(CucumberFeatureWrapper cFeature)
	{
		testRunner.runCucumber(cFeature.getCucumberFeature());
	}
	
	@DataProvider(name="features")
	public Object[][] getFeatures()
	{
		return testRunner.provideFeatures();
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException
	{		
		testRunner.finish();
		sleep(5);
		quit();
	}
}
