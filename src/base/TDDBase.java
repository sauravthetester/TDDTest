package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TDDBase {
	
	public static WebDriver driver; // declaration
	public static String configFile = System.getProperty("user.dir")+"/src/config/config.properties";
	public static Properties prop;
	
	public void initialize() throws IOException
	{
		
		prop = new Properties();
        FileInputStream file = new FileInputStream(configFile);
        prop.load(file);
        if(prop.getProperty("browser").equals("chrome"))
        {
			ChromeOptions options = new ChromeOptions();
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
        }
        else if(prop.getProperty("browser").equals("firefox"))
        {
        	  
//            capabilities.setCapability("marionette",true);  
//        	WebDriverManager.firefoxdriver().setup();
//        	driver = new FirefoxDriver(capabilities);
        }
		
		driver.get(prop.getProperty("url"));
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(6, TimeUnit.SECONDS);
	}

}
