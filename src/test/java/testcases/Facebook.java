package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProvideFactory;

public class Facebook {
	
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
   	public void setUP()
	{
		//report = new ExtentReports("./Reports/LoginPageReport.html",true);
		//logger = report.startTest("Verify Login Page","This Page will verify the Profile img after login");
		
		logger=DataProvideFactory.getReport().startReport("Verify Login Page","This Page will verify the Profile img after login");
		driver = BrowserFactory.getBrowser("Chrome");		
		driver.get("http://www.facebook.com");	
		logger.log(LogStatus.INFO,"Application is up an running");
	}
   	
	@Test
    public void facebookSend()
    {    	
        WebElement email= driver.findElement(By.id("email"));
        Actions builder = new Actions(driver);
        Actions seriesOfActions = builder.moveToElement(email).click().sendKeys(email, "gati.naveen@gmail.com");
        seriesOfActions.perform();
        WebElement pass = driver.findElement(By.id("pass"));
        WebElement login =driver.findElement(By.id("u_0_b"));
        Actions seriesOfAction = builder.moveToElement(pass).click().sendKeys(pass, "naveench").click(login);
        seriesOfAction.perform();
        driver.close();
    }    
}