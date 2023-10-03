package com.csv.helper;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.csv.model.Product;

public class MyExcelHelper {
	
	
	public static boolean checkExcelFormate(MultipartFile file) {
		
		String contentType = file.getContentType();
		
		 return contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") ;
			 
	}
	
	
	//convert excel to list 
	
	public static List<Product> convertExcelToList(InputStream is){
		
		List<Product> ls=new ArrayList<>();
		
		
		try {
			XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
			XSSFSheet sheet = xssfWorkbook.getSheetAt(0);
			int rowNumber=0;
			Iterator<Row> iterator=sheet.iterator();
			while(iterator.hasNext()) {
				
				Row row = iterator.next();
				if(rowNumber==0) {
					
					rowNumber++;
					continue;
				}
				
				
				Iterator<Cell> cell = row.iterator();
				int cid=0;
				
				Product p=new Product();
				while(cell.hasNext()) {
					
					Cell cellValue = cell.next();	
					
					switch(cid) {
					
					case 0 :
						p.setId((long)cellValue.getNumericCellValue());
						break;
					case 1 :
						p.setProductName(cellValue.getStringCellValue());
						break;
					case 2 :
						p.setProductDescription(cellValue.getStringCellValue());
						break;
					case 3 :
						p.setPrice((double)cellValue.getNumericCellValue());
						break;
					default :
						break;
					}
					
					cid++;
						
					}
				ls.add(p);
			
				}
			
			
				
				
			
			
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		
		
		
		
		return ls;
		
	}

}
