package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFName;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataexcel {
	
	
	public ArrayList<String> dataHub(String testcasename) throws IOException{
	//	String path=System.getProperty("user.dir")+"\\src\\main\\java\\resouces\\TDbook.xlsx";
		//System.out.println(System.getProperty("user.dir")+"\\src\\main\\java\\resouces\\TDbook.xlsx");
		//InputStream fis = this.getClass().getClassLoader().getResourceAsStream("TDbook.xlsx");
		
		FileInputStream fis=new FileInputStream("E:\\Projects\\Selenium\\TDbook.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		for(XSSFName names: workbook.getAllNames())
		System.out.println("Workbook name "+names.getSheetName());
		ArrayList<String> a=new ArrayList<String>();
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++){
			if(workbook.getSheetName(i).equalsIgnoreCase("Testdata")){
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
				while(rows.hasNext()){
					Row firstrow=rows.next();
				Iterator<Cell> ce=	firstrow.cellIterator();
				int k=0;
				int column=0;
					while(ce.hasNext()){
						Cell value=ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("Testdata")){
							column=k;
						}
						k++;
					}
					
					while(rows.hasNext()){
						Row r=rows.next();
						if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename)){
							Iterator<Cell> cv=r.cellIterator();
						 int l=0;
							while(cv.hasNext()){
								if(l==0){
									cv.next();
									l++;
								}
								Cell cvalue=cv.next();
								if (cvalue.getCellTypeEnum()==CellType.STRING){
									a.add(cvalue.getStringCellValue());
								}
								else{
									a.add(NumberToTextConverter.toText(cvalue.getNumericCellValue()));
								}
							}
						}
					}
				}
			}
		}
		return a;
		
		
	}

	
}
