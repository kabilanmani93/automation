package dataProvider;

import java.util.Properties;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class ReportDataProvider {

Properties pro;
static ExtentReports report;
static ExtentTest logger;

//Constructor
	public ReportDataProvider()
	{
		
		report = new ExtentReports("./Reports/LoginPageReport.html",true);
	}

	public ExtentTest startReport(String TCName, String TCDescription)
	{
		logger = report.startTest(TCName,TCDescription);
		return logger;
	}
	
	public static void endReport()
	{
		report.endTest(logger);
		report.flush();	
	}

}
