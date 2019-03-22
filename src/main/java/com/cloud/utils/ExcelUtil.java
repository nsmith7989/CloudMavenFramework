package com.cloud.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
//import java.util.Date;
import java.util.List;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
//import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Hyperlink;
//import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
		public  String ExcelFileWithPath=null;
		public  FileInputStream ExcelFileInput;
		public  FileOutputStream fileOut =null;
		private static Workbook workbook = null;
		public Sheet sheet = null;
		private Row row   =null;
		private Cell cell = null;
		private HSSFCell hcell = null;
		public static  String fileExtensionName;
		public String cellval;
		private transient Object[][] data;
		public List<String> flagsheet;
		public List<String> flagcolumnsdata;
		public List<String> excelList;
		public HashMap<Integer, String> excelMap;
		//private String[] flagsheetnames_array;
		private static DataFormatter objDefaultFormat;
		private static FormulaEvaluator objFormulaEvaluator;
		public List<String> testcaseNameWithYFlag;
		
		
		//This constructor method is used to initialize the workbook based on extension 
		public ExcelUtil(String ExcelFileWithPath)  
		{
			
			this.ExcelFileWithPath=ExcelFileWithPath;
			
			//Create an object of File class to open xlsx file
		    File file =    new File(ExcelFileWithPath);
		    try
		    {
			    //Create an object of FileInputStream class to read excel file
			    FileInputStream ExcelFileInput = new FileInputStream(file);
			    
			    //Find the file extension by splitting file name in substring  and getting only extension name
			    fileExtensionName = ExcelFileWithPath.substring(ExcelFileWithPath.indexOf("."));
			    //System.out.println("fileExtensionName is " +fileExtensionName);
	
			    //Check condition if the file is xlsx file
			    if(fileExtensionName.equals(".xlsx"))
			    {
	 			    workbook = new XSSFWorkbook(ExcelFileInput);
			    }else if(fileExtensionName.equals(".xls"))
			    {
			      workbook = new HSSFWorkbook(ExcelFileInput);
				}
			   }catch (Exception e) {
				e.printStackTrace();
			} 
									
		}
		
		// This method returns the row count in a sheet
		public int getRowCount(String sheetName)
		{
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return 0;
			else
			{
				sheet = workbook.getSheetAt(index);
				int number=sheet.getLastRowNum()+1;
				return number;
			}
		}
		
		// This method will returns the data from a cell based on rownum and colname
		public String getCellData(String sheetName,String colName,int rowNum)
		{
			try
			{
				if(rowNum <=0)
					return "";
					int index = workbook.getSheetIndex(sheetName);
					int col_Num=-1;
					if(index==-1)
						return "";
						sheet = workbook.getSheetAt(index);
						row=sheet.getRow(0);
						for(int i=0;i<row.getLastCellNum();i++)
						{
								if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
									col_Num=i;
						}
					if(col_Num==-1)
						return "";
					sheet = workbook.getSheetAt(index);
					row = sheet.getRow(rowNum-1);
					if(row==null)
						return "";
					cell = row.getCell(col_Num);
					
					if(cell==null)
						return "";
					
					if(cell.getCellTypeEnum()==CellType.STRING)
						  return cell.getStringCellValue();
					else if(cell.getCellTypeEnum()==CellType.NUMERIC || cell.getCellTypeEnum()==CellType.FORMULA){
						  
						  String cellText  = String.valueOf(cell.getNumericCellValue());
						  if (HSSFDateUtil.isCellDateFormatted(cell)) {
					           // format in form of M/D/YY
							  double d = cell.getNumericCellValue();
		
							  Calendar cal =Calendar.getInstance();
							  cal.setTime(HSSFDateUtil.getJavaDate(d));
					            cellText =
					             (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					           cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
					                      cal.get(Calendar.MONTH)+1 + "/" + 
					                      cellText;
				      }
					  return cellText;
					  }else if(cell.getCellTypeEnum()==CellType.BLANK)
					      return ""; 
					  else 
						  return String.valueOf(cell.getBooleanCellValue());
					}
					catch(Exception e){
				
					e.printStackTrace();
					return "row "+rowNum+" or column "+colName +" does not exist in xls";
			}
		}
			
		// This method will returns the data from a cell based on row number and column number
		/*public String getCellData(String Sheetname,int rownum,int colnum) 
		{
			try
			{
				sheet=workbook.getSheet(Sheetname);
				row=sheet.getRow(rownum);
				cell=row.getCell(colnum);
				cellval=cell.getStringCellValue();
			}
			catch(NullPointerException npe)
			{
				npe.printStackTrace();
			}
			return cellval;
			
		}*/
		
		// This method will returns the data from a cell based on row number and column number
				public String getCellData(String Sheetname,int rownum,int colnum) 
				{
					try
					{
						sheet=workbook.getSheet(Sheetname);
						row=sheet.getRow(rownum);
						cell=row.getCell(colnum);
						cellval=cell.getStringCellValue();
						
					}
					catch(NullPointerException npe)
					{
						npe.printStackTrace();
					}
					return cellval;
					
				}
		
		// This method returns true if data is set successfully else false
		public boolean setCellData(String sheetName,String colName,int rowNum, String data){
			if(fileExtensionName.equals(".xlsx"))
			{
				try{
					ExcelFileInput = new FileInputStream(ExcelFileWithPath); 
					workbook = new XSSFWorkbook(ExcelFileInput);

					if(rowNum<=0)
						return false;
					
					int index = workbook.getSheetIndex(sheetName);
					int colNum=-1;
					if(index==-1)
						return false;
						sheet = workbook.getSheetAt(index);
						row=sheet.getRow(0);
					for(int i=0;i<row.getLastCellNum();i++)
					{
						if(row.getCell(i).getStringCellValue().trim().equals(colName))
							colNum=i;
					}
					if(colNum==-1)
						return false;

					sheet.autoSizeColumn(colNum); 
					row = sheet.getRow(rowNum-1);
					if (row == null)
						row = sheet.createRow(rowNum-1);
					
					cell = row.getCell(colNum);	
					if (cell == null)
				        cell = row.createCell(colNum);

				    cell.setCellValue(data);

				    fileOut = new FileOutputStream(ExcelFileWithPath);

					workbook.write(fileOut);

				    fileOut.close();	
					}
					catch(Exception e){
						e.printStackTrace();
						return false;
					}
			}
			else if(fileExtensionName.equals(".xls"))
			{
				try{
							ExcelFileInput = new FileInputStream(ExcelFileWithPath); 
							workbook = new HSSFWorkbook(ExcelFileInput);
							if(rowNum<=0)
								return false;
							int index = workbook.getSheetIndex(sheetName);
							int colNum=-1;
							if(index==-1)
								return false;
							sheet = workbook.getSheetAt(index);
							row=sheet.getRow(0);
							for(int i=0;i<row.getLastCellNum();i++){
								//System.out.println(row.getCell(i).getStringCellValue().trim());
								if(row.getCell(i).getStringCellValue().trim().equals(colName))
									colNum=i;
							}
							if(colNum==-1)
								return false;
							sheet.autoSizeColumn(colNum); 
							row = sheet.getRow(rowNum-1);
							if (row == null)
								row = sheet.createRow(rowNum-1);
							hcell = (HSSFCell) row.getCell(colNum);	
							if (hcell == null)
								hcell = (HSSFCell) row.createCell(colNum);
							hcell.setCellValue(data);

						    fileOut = new FileOutputStream(ExcelFileWithPath);

							workbook.write(fileOut);
						    fileOut.close();	
							}
							catch(Exception e){
								e.printStackTrace();
								return false;
							}
					}
					return true;
					
			}

		
		// This method returns true if data is set successfully else false
		public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){
			try{
			ExcelFileInput = new FileInputStream(ExcelFileWithPath); 
			workbook = new XSSFWorkbook(ExcelFileInput);

			if(rowNum<=0)
				return false;
			
			int index = workbook.getSheetIndex(sheetName);
			int colNum=-1;
			if(index==-1)
				return false;
			
			
			sheet = workbook.getSheetAt(index);
			//System.out.println("A");
			row=sheet.getRow(0);
			for(int i=0;i<row.getLastCellNum();i++){
				if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
					colNum=i;
			}
			
			if(colNum==-1)
				return false;
			sheet.autoSizeColumn(colNum); 
			row = sheet.getRow(rowNum-1);
			if (row == null)
				row = sheet.createRow(rowNum-1);
			
			cell = row.getCell(colNum);	
			if (cell == null)
		        cell = row.createCell(colNum);
				
		    cell.setCellValue(data);
		    CreationHelper createHelper = workbook.getCreationHelper();

		    CellStyle hlink_style = workbook.createCellStyle();
		    Font hlink_font = workbook.createFont();
		    hlink_font.setUnderline(Font.U_SINGLE);
		    hlink_font.setColor(IndexedColors.BLUE.getIndex());
		    hlink_style.setFont(hlink_font);
		    Hyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
		    link.setAddress(url);
		    cell.setHyperlink(link);
		    cell.setCellStyle(hlink_style);
		      
		    fileOut = new FileOutputStream(ExcelFileWithPath);
			workbook.write(fileOut);

		    fileOut.close();	

			}
						
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		//This method returns true if sheet is created successfully else false
		public boolean addSheet(String  sheetname)
		{		
			FileOutputStream fileOut;
			try {
				 workbook.createSheet(sheetname);	
				 fileOut = new FileOutputStream(ExcelFileWithPath);
				 workbook.write(fileOut);
			     fileOut.close();		    
			} catch (Exception e) {			
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		// This method returns true if sheet is removed successfully else false if sheet does not exist
		public boolean removeSheet(String sheetName)
		{		
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1)
				return false;
			
			FileOutputStream fileOut;
			try {
				workbook.removeSheetAt(index);
				fileOut = new FileOutputStream(ExcelFileWithPath);
				workbook.write(fileOut);
			    fileOut.close();		    
			} catch (Exception e) {			
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		// This method returns true if column is created successfully
		public boolean addColumn(String sheetName,String colName)
		{
			try{				
				ExcelFileInput = new FileInputStream(ExcelFileWithPath); 
				workbook = new XSSFWorkbook(ExcelFileInput);
				int index = workbook.getSheetIndex(sheetName);
				if(index==-1)
					return false;
				
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			sheet=workbook.getSheetAt(index);
			row = sheet.getRow(0);
			if (row == null)
				row = sheet.createRow(0);
			if(row.getLastCellNum() == -1)
				cell = row.createCell(0);
			else
				cell = row.createCell(row.getLastCellNum());
		        cell.setCellValue(colName);
		        cell.setCellStyle(style);
		        fileOut = new FileOutputStream(ExcelFileWithPath);
				workbook.write(fileOut);
			    fileOut.close();		    
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
		}
		
		// removes a column and all the contents
		public boolean removeColumn(String sheetName, int colNum) 
		{
			try{
			if(!isSheetExist(sheetName))
				return false;
			ExcelFileInput = new FileInputStream(ExcelFileWithPath); 
			workbook = new XSSFWorkbook(ExcelFileInput);
			sheet=workbook.getSheet(sheetName);
			CellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(HSSFColor.GREY_40_PERCENT.index);
			CreationHelper createHelper = workbook.getCreationHelper();
			for(int i =0;i<getRowCount(sheetName);i++){
				row=sheet.getRow(i);	
				if(row!=null){
					cell=row.getCell(colNum);
					if(cell!=null){
						cell.setCellStyle(style);
						row.removeCell(cell);
					}
				}
			}
			fileOut = new FileOutputStream(ExcelFileWithPath);
			workbook.write(fileOut);
		    fileOut.close();
			}
			catch(Exception e){
				e.printStackTrace();
				return false;
			}
			return true;
			
		}
	  // find whether sheets exists	
		public boolean isSheetExist(String sheetName){
			int index = workbook.getSheetIndex(sheetName);
			if(index==-1){
				index=workbook.getSheetIndex(sheetName.toUpperCase());
					if(index==-1)
						return false;
					else
						return true;
			}
			else
				return true;
		}
		
		// It returns number of columns in a sheet	
		public int getColumnCount(String sheetName)
		{
			// check if sheet exists
			if(!isSheetExist(sheetName))
			 return -1;
			
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			
			if(row==null)
				return -1;
			
			return row.getLastCellNum();
		}
		
		/*//String sheetName, String testCaseName,String keyword ,String URL,String message
		public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){
			//System.out.println("ADDING addHyperLink******************");
			
			url=url.replace('\\', '/');
			if(!isSheetExist(sheetName))
				 return false;
			
		    sheet = workbook.getSheet(sheetName);
		    
		    for(int i=2;i<=getRowCount(sheetName);i++){
		    	if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){
		    		//System.out.println("**caught "+(i+index));
		    		setCellData(sheetName, screenShotColName, i+index, message,url);
		    		break;
		    	}
		    }


			return true; 
		}
		public int getRowNum(String sheetName,String colName,String cellValue){
			
			for(int i=2;i<=getRowCount(sheetName);i++){
		    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
		    		return i;
		    	}
		    }
			return -1;
			
		}*/
			
		//It will return row number based on col name
		public int getCellRowNum(String sheetName,String colName,String cellValue)
		{
			for(int i=2;i<=getRowCount(sheetName);i++){
		    	if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
		    		return i;
		    	}
		    }
			return -1;
			
		}
		
		//It will return first cell data from a given column
		public String getFirstCellData(int columnnum)
		{
			//int firstrow=sheet.getFirstRowNum();
			row=sheet.getRow(1);
			cell=row.getCell(columnnum);
			return cell.getStringCellValue();
		}
		
		//This method will return list of sheets
		public List<String> getSheetName()
		{
			List<String> sheetNames = new ArrayList<String>();
			for (int i=0; i<workbook.getNumberOfSheets(); i++)
			{
			    sheetNames.add( workbook.getSheetName(i) );
			}
			return sheetNames;
		}
		
		//This method will return specified sheet based on given index
		public String getSheetName(int index)
		{
			sheet=workbook.getSheetAt(index);
			return sheet.getSheetName();
		}
		
		//This method returns number of sheets
		public int getSheetCount()
		{
			int sheetscount=workbook.getNumberOfSheets();
			
			return sheetscount;
			
		}
		
		//This method returns index of given sheet
		public int getSheetIndex(String sheetName)
		{
			return workbook.getSheetIndex(sheetName);
		}
		
		public Object[][] getData() 
		{
	        return data;

	    }
	    		
		
		//This method will returns the data from the specified XLSX sheet with execution flag is Y from the given sheet 
		Object[][] getDataFromXSSFSpreadSheet(String sheetName) throws Exception
		    {
			 		ExcelFileInput=new FileInputStream(ExcelFileWithPath);
		            workbook = new XSSFWorkbook(ExcelFileInput);
		            sheet = workbook.getSheet(sheetName);
		            row = sheet.getRow(0);
		            cell=row.getCell(0);
		            int rowcount=sheet.getLastRowNum()+1;
		            int colcount=row.getLastCellNum();
		          
		            Object[][] obj1=new Object[rowcount][colcount];
		            for(int r=0;r<rowcount;r++)
		            {
		                  row = sheet.getRow(r);
		                  for(int c=0;c<colcount;c++)
		                  {
		                          cell=row.getCell(c);
		                          obj1[r][c]=cell.getStringCellValue();
		                          
		                          
		                  }
		                  
		            }
		            
		            Object[][] data=new Object[sheet.getLastRowNum()][row.getLastCellNum()];//[2][2]
		           
		            for(int rol=1;rol<rowcount;rol++)
		            {
		                  for(int c1=0;c1<colcount;c1++)
		                  {
		                         
		                         data[rol-1][c1]=obj1[rol][c1];
		                  }
		            }
		           
		                    return data; 
		    }
		
		//This method will returns the data from the specified XLS sheet with execution flag is Y from the given sheet 
		 Object[][] getDataFromHSSFSpreadSheet(String sheetName) throws IOException
	    {
				ExcelFileInput=new FileInputStream(ExcelFileWithPath);
	            workbook = new HSSFWorkbook(ExcelFileInput);
	            sheet = workbook.getSheet(sheetName);
	            row =sheet.getRow(0);
	            hcell=(HSSFCell) row.getCell(0);
	            int rowcount=sheet.getLastRowNum()+1;
	            int colcount=row.getLastCellNum();
	          
	            Object[][] obj1=new Object[rowcount][colcount];
	            
	            for(int r=0;r<rowcount;r++)
	            {
	            		row = sheet.getRow(r);
	                  for(int c=0;c<colcount;c++)
	                  {
	                	  	  hcell=(HSSFCell) row.getCell(c);
	                          obj1[r][c]=hcell.getStringCellValue();
	                          
	                  }
	                  
	            }
	            
	            Object[][] data=new Object[sheet.getLastRowNum()][row.getLastCellNum()];//[2][2]
	           
	            for(int rol=1;rol<rowcount;rol++)
	            {
	                  for(int c1=0;c1<colcount;c1++)
	                  {
	                         
	                         data[rol-1][c1]=obj1[rol][c1];
	                  }
	            }
	           
	                    return data; 
	    }
		
		//This method will returns the data from XLS/XLSX sheet with execution flag is Y from the given sheet
		 public Object[][] getDataFromSpreadSheet(String sheetName) throws IOException
		{
			if(fileExtensionName.equals(".xlsx"))
			{
				try {
					data=getDataFromXSSFSpreadSheet(sheetName);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}else if(fileExtensionName.equals(".xls")){
				
				data=getDataFromHSSFSpreadSheet(sheetName);
				
			}
			return data;
		}
		
		//This method returns list of sheets with execution flag is Y from the given sheet 
		public List<String> getSheetNamesByFlag(String SheetName,String FlagDependentColumn,String FlagColumnName,String Flag)
	    {
	    	
	    				List<String> flagdependentcolumn=new ArrayList<String>();
	    				
	                    for(int i=0;i<=getRowCount(SheetName);i++)
	                    {
	                                    if(getCellData(SheetName, FlagColumnName,i).equals(Flag))
	                                    {

	                                    	flagdependentcolumn.add(getCellData(SheetName, FlagDependentColumn, i));
	                                    }

	                    }
	                    
	                    for(String flagsheets:flagdependentcolumn)
	                    {
	                    	if(isSheetExist(flagsheets)==true)
	                    	{
	                    		flagsheet=flagdependentcolumn;
	                    	} 
	                    	
	                    }
	  
	              return flagsheet;	                    	
	    
	    }
		
		//This method returns list of column values based on flag from the given sheet 
		public List<String> getColumnValuesByFlag(String SheetName,String FlagDependentColumn,String FlagColumnName,String Flag)
	    {
	    		flagcolumnsdata=new ArrayList<String>();
	    		
	            for(int i=0;i<=getRowCount(SheetName);i++)
	            {
	                            if(getCellData(SheetName, FlagColumnName,i).equals(Flag))
	                            {

	                            	flagcolumnsdata.add(getCellData(SheetName, FlagDependentColumn, i));
	                            }

	            }
	    	
	    	return flagcolumnsdata;
	    }
		
		//This method is used to read the cell value
		public static String getCellValue(Cell cell) throws Exception 
		{
			String cellValue = "";
			try {
				objDefaultFormat = new DataFormatter();
				if(fileExtensionName.equals(".xlsx"))
				{
					objFormulaEvaluator = new XSSFFormulaEvaluator((XSSFWorkbook) workbook);
					
				} else  if(fileExtensionName.equals(".xls")) {
					objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
					
				} else {
					throwException("FILE FORMAT SEEMS TO BE INCORRECT" + "\n");
				}
				objFormulaEvaluator.evaluate(cell);
				cellValue = objDefaultFormat.formatCellValue(cell, objFormulaEvaluator);
			} catch (Exception e) {
				
				throwException("UNABLE TO READ CELL VALUE\n" + e.getMessage() + "\n");
			}
			
			return cellValue;
		}
		
		
		//This method is used to read the cell value based on row and column number
		public String getCellGenericData(String Sheetname,int rownum,int colnum) throws Exception 
		{	
			try
			{
				sheet=workbook.getSheet(Sheetname);
				row=sheet.getRow(rownum);
				cell=row.getCell(colnum);
				
				cellval=getCellValue(cell);
			}
			catch(NullPointerException npe)
			{
				npe.printStackTrace();
			}
			return cellval;
		}
		
		//This method is used to INTEND TO READ THE TEST DATA AS TWO DIMENSIONAL OBJECT ARRAY
		public  Object[][] getTestDataAsTwoDimesionalObjectArray(String sheetName) throws Exception {
			FileInputStream ExcelFileInput = new FileInputStream(ExcelFileWithPath);
			Object[][] excelObjectArray = null;
			if(fileExtensionName.equals(".xlsx"))
		    {
 			    workbook = new XSSFWorkbook(ExcelFileInput);
		    }else if(fileExtensionName.equals(".xls"))
		    {
		      workbook = new HSSFWorkbook(ExcelFileInput);
			}
			Sheet sheet = workbook.getSheet(sheetName);
	        Row row = sheet.getRow(0);
	       	int rowcount = sheet.getLastRowNum();
			int colcount = sheet.getRow(0).getLastCellNum();
			          
			            excelObjectArray=new Object[rowcount][colcount];
			            String cellValue = "";
			            int k = 0;
			            for(int r=1;r<=rowcount;r++,k++)
			            {
			                  row = sheet.getRow(r);
			                  int l=0;
			                  for(int c=0;c<colcount;c++,l++)
			                  {
			                	  if (row.getCell(c) != null) 
			                	  {
			                          cell=row.getCell(c);
			                          cellValue=ExcelUtil.getCellValue(cell);
			                          excelObjectArray[k][l] =cellValue;
			                          System.out.println(excelObjectArray[k][l]);
			                	  }else {
										cellValue = "";
										excelObjectArray[k][l] = cellValue;
			                	  }
			                  }
			            }
			  return excelObjectArray;
		}

		
		//This method is INTEND TO READ THE TEST DATA AS LIST
		public  List<String> getTestDataAsList(String sheetName)
				throws Exception {

			FileInputStream ExcelFileInput = new FileInputStream(ExcelFileWithPath);
				if(fileExtensionName.equals(".xlsx"))
			    {
	 			    workbook = new XSSFWorkbook(ExcelFileInput);
			    }else if(fileExtensionName.equals(".xls"))
			    {
			      workbook = new HSSFWorkbook(ExcelFileInput);
				}
				Sheet sheet = workbook.getSheet(sheetName);
					int rowCount = sheet.getLastRowNum();
					int colCount = sheet.getRow(0).getLastCellNum();
						excelList = new ArrayList<String>();
						String cellValue = "";
						for (int i = 1; i <= rowCount; i++) {
							row = sheet.getRow(i);
							for (int j = 0; j < colCount; j++) {
								if (row.getCell(j) != null) {
									cell = row.getCell(j);
									cellValue = getCellValue(cell);
									excelList.add(cellValue);
								
							}
						}
					} 
			return excelList;
		}


		//This method is INTEND TO READ THE TEST DATA AS HASHMAP
				public  HashMap<Integer, String> getTestDataAsHashMap(String sheetName)
						throws Exception {

					FileInputStream ExcelFileInput = new FileInputStream(ExcelFileWithPath);
						if(fileExtensionName.equals(".xlsx"))
					    {
			 			    workbook = new XSSFWorkbook(ExcelFileInput);
					    }else if(fileExtensionName.equals(".xls"))
					    {
					      workbook = new HSSFWorkbook(ExcelFileInput);
						}
						Sheet sheet = workbook.getSheet(sheetName);
							int rowCount = sheet.getLastRowNum();
							int colCount = sheet.getRow(0).getLastCellNum();
							excelMap = new HashMap<Integer, String>();
							int counter = 0;
							String cellValue = "";
							for (int i = 1; i <= rowCount; i++) {
								row = sheet.getRow(i);
								for (int j = 0; j < colCount; j++) {
									if (row.getCell(j) != null) {
										cell = row.getCell(j);
										cellValue = getCellValue(cell);
										excelMap.put(counter, cellValue);
										counter++;
									} else {
										cellValue = "";
										excelMap.put(counter, cellValue);
										counter++;
									}
								}
							}
					return excelMap;
				}

				
				//This method returns list of test case names based on flag from the given sheet 
				public List<String> getTCColumnValuesByFlag(String SheetName,String TestCaseName,String TestName,String Execution_Flag,String ExecFlag) throws Exception
			    {
					testcaseNameWithYFlag=new ArrayList<String>();
			            for(int i=0;i<=getRowCount(SheetName);i++)
			            {
			            	row=sheet.getRow(i);
			            	for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
								if (row.getCell(j) != null) {
									cell = row.getCell(j);
									TestCaseName = getCellValue(cell);
									} 
			                            if((getCellData(SheetName, Execution_Flag,i).equals(ExecFlag))& (TestCaseName.equalsIgnoreCase(getCellValue(cell))))
			                            {
			                            	testcaseNameWithYFlag.add(getCellData(SheetName, TestName, i));
			                            }
			            }
			            }
			    	return testcaseNameWithYFlag;
			    }

		
		public static void throwException(String message) throws Exception {
			throw new Exception(message);
		}


		
		

}