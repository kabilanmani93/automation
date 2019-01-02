package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BrowserFactory;
import factory.DataProvideFactory;
import pages.DatePicker;
import pages.LoginPage;

public class DatePicketTest {

	WebDriver driver;
	WebDriverWait wait;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUP()
	{
		report = new ExtentReports("./Reports/DatePicker.html",true);
		logger = report.startTest("Verify Login Page","This Page will verify the Profile img after login");
		
		driver = BrowserFactory.getBrowser("Chrome");		
		driver.get(DataProvideFactory.getConfig().getDatePickerURL());
		
		logger.log(LogStatus.INFO,"Application is up an running");
	}
	
	@Test(dataProvider = "inputDates")
    public void dateTest(String ipDate, String opDate) 
	{		
		DatePicker DatePicker=PageFactory.initElements(driver,DatePicker.class);	
		DatePicker.setDate(ipDate);
        Assert.assertEquals(DatePicker.getSelectedDate(),opDate);
	}
	
    @DataProvider(name = "inputDates")
    public static Object[][] getDates()
    {
        return new Object[][] 
        {
            {  
            	"25 May 2017",
                "05/25/2017" 
            	}, 
                
            {
                "01 Dec 2016",
                "12/01/2016"
            }, 
            {
                "29 Feb 2016",
                "02/29/2016"
            }, 
            {
                "20 Nov 2018",
                "11/20/2018"
            }
        };
    }
}