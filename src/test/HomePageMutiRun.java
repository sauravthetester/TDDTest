package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TDDBase;
import pom.HomePageObjects;
import util.ReusableFunctions;

public class HomePageMutiRun extends TDDBase{

	TDDBase obj;
	
	// Browser open / intitiate
	@BeforeMethod
	public void setUp() throws IOException
	{
		obj = new TDDBase();
		obj.initialize();
	}
	
	
	// Main Test Case
	@Test
	public void checkHomePageLogoExists()
	{
		ReusableFunctions.waitForElement(HomePageObjects.homePageLogo());
    	boolean logoDisplayed = HomePageObjects.homePageLogo().isDisplayed();	
		Assert.assertEquals(logoDisplayed, true);
		
	}
	
	
	// Browser close / quit
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
