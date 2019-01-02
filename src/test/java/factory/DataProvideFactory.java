package factory;

import utility.Helper;
import dataProvider.ConfigDataProvider;
import dataProvider.ExcelDataProvider;
import dataProvider.ReportDataProvider;

public class DataProvideFactory
{
	public static ConfigDataProvider getConfig()
	{
		ConfigDataProvider config = new ConfigDataProvider();
		 return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
		ExcelDataProvider excel = new ExcelDataProvider();
		 return excel;
	}
		
	public static ReportDataProvider getReport()
	{
		ReportDataProvider report = new ReportDataProvider();
		 return report;
	}
}
