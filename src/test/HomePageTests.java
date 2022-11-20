package test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.TDDBase;
import pom.HomePageObjects;



public class HomePageTests extends TDDBase {

	TDDBase obj;
	
	@BeforeMethod
	public void setUp() throws IOException
	{
		obj = new TDDBase();
		obj.initialize();
	}
	
	
	@Test
	public void checkHomePageLogoExists()
	{
		WebDriverWait wait = new WebDriverWait(TDDBase.driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated((By) HomePageObjects.homePageLogo()));
    	
		boolean logoDisplayed = HomePageObjects.homePageLogo().isDisplayed();	
		
		Assert.assertEquals(logoDisplayed, true);
	}
	
	@Test
	public void checkHomePageLogoExists2()
	{
		// Main Test case
		WebDriverWait wait = new WebDriverWait(TDDBase.driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.presenceOfElementLocated((By) HomePageObjects.homePageLogo()));
		boolean logoDisplayed = HomePageObjects.homePageLogo().isDisplayed();	
		
		Assert.assertEquals(logoDisplayed, true); // Hard Assert
	}
	
	@Test
	public void clickOnSignInAndVerifyContinueButton()
	{
		WebDriverWait wait = new WebDriverWait(TDDBase.driver, Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		
		Actions action = new Actions(TDDBase.driver);
		
		action.moveToElement(HomePageObjects.accountsAndLists()).build().perform();
		action.moveByOffset(0, 5).build().perform();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='nav-al-signin']//a/span[text()='Sign in' and @class='nav-action-inner']")));
    	WebElement signInButton = driver.findElement(By.xpath("//div[@id='nav-al-signin']//a/span[text()='Sign in' and @class='nav-action-inner']"));
    	
    	signInButton.click();
    	
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue']")));
    	
    	boolean continueBtnDisplayed = driver.findElement(By.xpath("//input[@id='continue']")).isDisplayed();
    	String labelText = driver.findElement(By.xpath("//label")).getText().trim(); // trim() will remove left and right spaces
    	
    	
    	Assert.assertEquals(continueBtnDisplayed, true);
    	Assert.assertEquals(labelText, "Email or mobile phone number");
	}
	
	@Test
	public void clickOnAccountListsAndVerifyContinueButton()
	{
		WebDriverWait wait = new WebDriverWait(TDDBase.driver, Duration.ofSeconds(10));
		
		
		Duration.ofSeconds(10);
		
		driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span")).click();
		
    	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='continue']")));
    	
    	boolean continueBtnDisplayed = driver.findElement(By.xpath("//input[@id='continue']")).isDisplayed();
    	String labelText = driver.findElement(By.xpath("//label")).getText().trim(); // trim() will remove left and right spaces
    	
    	
    	Assert.assertEquals(continueBtnDisplayed, true);
    	Assert.assertEquals(labelText, "Email or mobile phone number");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
