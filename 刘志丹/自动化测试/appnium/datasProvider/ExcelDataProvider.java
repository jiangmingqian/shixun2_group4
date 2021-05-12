package datasProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.model.RecordStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
   public static  Object[][] getData(String filename) throws IOException{
	File file=new File(filename);  
	FileInputStream fisStream=new FileInputStream(file);
	String fileExtensionName =filename.substring((filename.indexOf(".")));
	Workbook wbook=null;
	if(fileExtensionName.equals(".xls")) {
		wbook=new HSSFWorkbook(fisStream);
	}else if(fileExtensionName.equals(".xlsx")){
		wbook=new XSSFWorkbook(fisStream);
	}
	Sheet sheet=wbook.getSheet("Sheet1");
	int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	System.out.println("最后一行"+sheet.getLastRowNum());
	System.out.println("第一行"+sheet.getFirstRowNum());
	//逐行读取数据 放进容器
	List<Object[]> records=new ArrayList<Object[]>();
	for(int i=1;i<rowCount+1;i++) {
		
		Row row=sheet.getRow(i);
		//把每行数据提取出来存进数组
		Object[] filed=new Object[row.getLastCellNum()];
		for(int j=0;j<row.getLastCellNum();j++) {
			Cell cell=row.getCell(j);
			switch(cell.getCellType()) {
			 case STRING:
			   filed[j]=cell.getStringCellValue();
			   break;
			 case NUMERIC:
			   filed[j]=String.valueOf(cell.getNumericCellValue());
			   break;
			 case BOOLEAN:
			   filed[j]=String.valueOf(cell.getBooleanCellValue());
			   break;
			 default:
			   break;
				 
			}
		}
	
		records.add(filed);
	}

	 Object[][] data=new Object[records.size()][];
	 for(int i=0;i<records.size();i++) {
		 data[i]=records.get(i);
	 }
	 return data;
   
   }
}

