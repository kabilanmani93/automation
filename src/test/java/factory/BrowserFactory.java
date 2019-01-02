package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import dataProvider.ConfigDataProvider;

public class BrowserFactory
{
	static WebDriver driver;
	
	public static WebDriver getBrowser(String browerName)
	{
		if(browerName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.gecko.driver", DataProvideFactory.getConfig().getFireFoxPath());
			driver = new FirefoxDriver();
		}
		else if(browerName.equalsIgnoreCase("Chrome"))
		{			
			System.setProperty("webdriver.chrome.driver", DataProvideFactory.getConfig().getChromePath());
			driver = new ChromeDriver();
		}
		else if(browerName.equalsIgnoreCase("IE"))
		{
			//ConfigDataProvider config = new ConfigDataProvider();
			System.setProperty("webdriver.ie.driver", DataProvideFactory.getConfig().getIEPath());
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}
}
