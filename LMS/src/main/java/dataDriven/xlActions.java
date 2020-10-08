package dataDriven;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlActions {

	public static File file;
	static Workbook excelWorkbook;
	public static Sheet excelSheet;
	public static int rowCount;
	public static Row row;
	public static Cell cell;
	public static String actData;
	// @SuppressWarnings("deprecation")
	@SuppressWarnings("deprecation")
	public static void readExcel(String filePath,String fileName,String sheetName) throws IOException{
		 file =    new File(filePath+"\\"+fileName);

		    //Create an object of FileInputStream class to read excel file

		    FileInputStream inputStream = new FileInputStream(file);

		  excelWorkbook = null;

		    //Find the file extension by splitting file name in substring  and getting only extension name

		    String fileExtensionName = fileName.substring(fileName.indexOf("."));

		    //Check condition if the file is xlsx file

		    if(fileExtensionName.equals(".xlsx")){

		    //If it is xlsx file then create object of XSSFWorkbook class

		    excelWorkbook = new XSSFWorkbook(inputStream);

		    }

		    //Check condition if the file is xls file

		    else if(fileExtensionName.equals(".xls")){

		        //If it is xls file then create object of HSSFWorkbook class

		        excelWorkbook = new HSSFWorkbook(inputStream);

		    }

		    //Read sheet inside the workbook by its name

		    excelSheet = excelWorkbook.getSheet(sheetName);

		    //Find number of rows in excel file

		    rowCount = excelSheet.getLastRowNum()-excelSheet.getFirstRowNum();
		    //System.out.println(rowCount);

		    //Create a loop over all the rows of excel file to read it

		    for (int i = 0; i < rowCount+1; i++) {

		     row = excelSheet.getRow(i);

		        //Create a loop to print cell values in a row

		        for (int j = 0; j < row.getLastCellNum(); j++) {
		        	//System.out.println("Total column is "+row.getLastCellNum());
		            //Print Excel data in console
		        	cell =excelSheet.getRow(i).getCell(j);
		        	System.out.println("Row is "+i+" Column is "+j);
		        	cell.setCellType(CellType.STRING);
		        	actData=cell.getStringCellValue();
		            System.out.print(actData+ "|| ");

		        }

		        System.out.println("Read Operation Completed Successfully for row " +i );
		    } 

	 }
	 
	 @SuppressWarnings("deprecation")
	public static void getDataFromCell(int row, int cellNum){
		 cell =excelSheet.getRow(row).getCell(cellNum);
     	cell.setCellType(CellType.STRING);
     	actData=cell.getStringCellValue();
         System.out.print("Actual Value For the Row " +row+ " Cell " +cellNum+ " is " +actData);
	 }
	 
	 public static void writeData(int rowToWrite, int cellToWrite, String valueToWrite) throws IOException{
		 //int cellNumWrite=cellToWrite+1;
		 System.out.println(cellToWrite);
		 System.out.println("Going to write on the row " +rowToWrite+ "and on the cell "+cellToWrite+" is "+valueToWrite);
		 cell =excelSheet.getRow(rowToWrite).createCell(cellToWrite);
		 cell.setCellValue(valueToWrite);
		 FileOutputStream outputStream = new FileOutputStream(file);

		    //write data in the excel file

		    excelWorkbook.write(outputStream);

		    //close output stream

		    outputStream.close();
	 }
	
}
