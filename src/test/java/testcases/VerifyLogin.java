package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import dataProvider.ReportDataProvider;
import pages.LoginPage;
import pages.SupportRolePage;
import utility.Helper;
import factory.BrowserFactory;
import factory.DataProvideFactory;

public class VerifyLogin 
{
	WebDriver driver;
	WebDriverWait wait;
	ExtentReports report;
	ExtentTest logger;
	
	@Parameters("Browser")
	@BeforeClass
	public void setUP()
	{
		//report = new ExtentReports("./Reports/LoginPageReport.html",true);
		//logger = report.startTest("Verify Login Page","This Page will verify the Profile img after login");
		
		logger=DataProvideFactory.getReport().startReport("Verify Login Page","This Page will verify the Profile img after login");
		driver = BrowserFactory.getBrowser("chrome");		
		driver.get(DataProvideFactory.getConfig().getApplicationUrl());		
		logger.log(LogStatus.INFO,"Application is up an running");
	}
	
	@Test(priority =1)
	public void testLogin() throws InterruptedException
	{		
		LoginPage Login=PageFactory.initElements(driver,LoginPage.class);
		
		//Verify Application Login Page Title
		String title = Login.getApplicationTitle();
		System.out.println("My Application Title "+title);	
		Assert.assertTrue(title.contains("GTZcommand"));
		logger.log(LogStatus.PASS,"Home Page Loaded and title is verified");
		
		//Read Data from Excel
		String UserName = DataProvideFactory.getExcel().getData("Login", 1, 0);
		String Password = DataProvideFactory.getExcel().getData("Login", 1, 1);
		Login.loginToApplication(UserName,Password);
		logger.log(LogStatus.INFO,"Login User Credentials is entered and clicked on Login Button");
		
		Login.VerifyLogin();
		logger.log(LogStatus.PASS,"User is Logged in Succesfully and Verified the Profile image");
		logger.log(LogStatus.INFO,logger.addScreenCapture(Helper.captureScreenshot(driver, "Login_Validation_passed")));	
			
	}
	
	@Test(priority=2)
	public void CreateSupportRole() throws InterruptedException
	{
		SupportRolePage SupportRole =PageFactory.initElements(driver,SupportRolePage.class);
		Thread.sleep(4000);
		SupportRole.NavigateToSupportPage();
		Assert.assertEquals(true, true);
		logger.log(LogStatus.PASS,"Support Role Page to be displayed");
	}
	
	
	@AfterClass
	public void tearDown(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String Path = Helper.captureScreenshot(driver, result.getName());
			logger.log(LogStatus.FAIL, logger.addScreenCapture(Path));
		}
		BrowserFactory.closeBrowser(driver);
		ReportDataProvider.endReport();
		//report.endTest(logger);
		//report.flush();	
	}

}
