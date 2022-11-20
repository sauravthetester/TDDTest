package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TDDBase;
import pom.HomePageObjects;

public class ReusableFunctions {

	public static void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(TDDBase.driver, Duration.ofSeconds(20));
    	wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}

}
