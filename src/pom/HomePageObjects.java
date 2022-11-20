package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.TDDBase;

public class HomePageObjects {
	
	
	public static WebElement homePageLogo()
	{
		return TDDBase.driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
	}
	
	public static WebElement accountsAndLists()
	{
		return TDDBase.driver.findElement(By.xpath("//a[@id='nav-link-accountList']/span"));
	}

}
