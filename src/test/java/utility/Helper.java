package utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class Helper
{
	
	public static String captureScreenshot(WebDriver driver,String ScreenhotName)
	{
		TakesScreenshot ts =(TakesScreenshot) driver;
		
		File src = ts.getScreenshotAs(OutputType.FILE);
		String dst = "F://Automation//com.learnautomation.hybrid//ScreenShots"+ScreenhotName+ System.currentTimeMillis()+".png";
		try 
		{
			FileUtils.copyFile(src,new File(dst));
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return dst;
	}
	

}
	