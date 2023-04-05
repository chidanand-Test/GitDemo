import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testName) throws FileNotFoundException {
		// Identify Testcases column by scanning the entire row
		// once column is identified then scan entire test cases column to identify purchanse  test case row

		ArrayList<String> a=new ArrayList<String>();	
		FileInputStream fis=new FileInputStream("D:\\DemoData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++)
		{
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
			   XSSFSheet sheet=workbook.getSheetAt(i);
			// Identify Testcases column by scanning the entire row
			   
			  Iterator<Row> rows=sheet.iterator();  // sheet is collection of rows
			  Row firstRow=rows.next();
			  Iterator<Cell> ce=firstRow.cellIterator(); // row is collection of cells
			  int k=0;
			  int column=0;
			  while(ce.hasNext())
			  {
				  Cell values=ce.next();
				  if(values.getStringCellValue().equalsIgnoreCase("Testcases"))
				  {
					  column=k;
				  }
				  k++;
			  }
			  System.out.println(column);
			  
			// once column is identified then scan entire test cases column to identify purchanse  test case row
			  
			  while(rows.hasNext())
			  {
				  Row r=rows.next();
				  if(r.getCell(column).getStringCellValue().equalsIgnoreCase("testName"))
				  {
					 Iterator<Cell> cv=r.cellIterator(); 
					 while(cv.hasNext())
					 {
					   a.add(cv.next().getStringCellValue());
					 }
				  }
				 
			  }
			  
			  
			}
			
			
			
		}
		return a;
	}
	

}
