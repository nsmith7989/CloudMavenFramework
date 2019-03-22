package com.cloud.util;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.cloud.utils.ExcelUtil;
import com.cloud.utils.PropertiesReader;


public class DataProviderRepository {
	
	public static Properties configproperties;
	public static ExcelUtil excel;
	public static List<String> exceltestdrive;
		
	/*@DataProvider(name = "CloudDataProviderUtil")
	public static Object[][] CloudDataProviderUtil(Method method) throws Exception {
		
		configproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path"));
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK");
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());
			if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
			}
		return testDataArray;
	}*/
	
	
	@DataProvider(name = "CloudDataProviderUtil_HCM")
	public static Object[][] CloudDataProviderUtil_HCM(Method method) throws Exception {
		
		configproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_HCM"));
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK");
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());
			if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
			}
		return testDataArray;
	}


	@DataProvider(name = "CloudDataProviderUtil_HCM_Phase2")
	public static Object[][] CloudDataProviderUtil_HCM__Phase2(Method method) throws Exception {
		
		configproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_HCM_Phase2"));
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK");
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());
			if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
			}
		return testDataArray;
	}

	
	
	@DataProvider(name = "CloudDataProviderUtil_Finance")
	public static Object[][] CloudDataProviderUtil_Finance(Method method) throws Exception {
		
		configproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_Finance"));
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK");
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());
			if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
			}
		return testDataArray;
	}
	
	@DataProvider(name = "CloudDataProviderUtil_Finance_Phase2")
	public static Object[][] CloudDataProviderUtil_Finance_Phase2(Method method) throws Exception {
		
		configproperties=PropertiesReader.readProperties("environments.properties");
		excel=new ExcelUtil(System.getProperty("user.dir")+configproperties.getProperty("cloud.excel.path_Finance_Phase2"));
		System.out.println("INTEND TO READ THE TEST DATA USING DATAPROVIDER FROM EXCEL WORKBOOK");
		Object[][] testDataArray = null;
		String sheetname=method.getName();
		System.out.println("READ THE DATA FROM SHEET NAME: "+method.getName());
			if(excel.isSheetExist(sheetname))
			{
				testDataArray = excel.getTestDataAsTwoDimesionalObjectArray(sheetname);
			}
		return testDataArray;
	}

}
