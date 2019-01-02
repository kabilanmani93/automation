package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigDataProvider 
{
	Properties pro;
	
	public ConfigDataProvider()
	{
		File src = new File("./Configuration/config.properties");
			
		try 
		{
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
			pro.load(fis);
		} 
		catch (Exception e) 
		{
			System.out.println("Exception is: "+ e.getMessage());
	
		}		
	}
	
	public String getFireFoxPath()
	{
		String FireFoxPath = pro.getProperty("FireFoxPath");
		return FireFoxPath;
	}
	
	public String getChromePath()
	{
		String ChromePath = pro.getProperty("chromePath");
		return ChromePath;
	}
	
	public String getIEPath()
	{
		String IEPath = pro.getProperty("IEPath");
		return IEPath;
	}
	
	public String getApplicationUrl()
	{
		String Url = pro.getProperty("URL");
		return Url;
	}
	
	public String getDatePickerURL()
	{
		String Url = pro.getProperty("DatePickerURL");
		return Url;
	}
	
	

}
