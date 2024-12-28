package com.Scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import org.apache.poi.xssf.usermodel.*;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	@Test
	public void testFileRead() throws IOException 
	{
		//path of file
		File f1=new File(System.getProperty("user.dir")+"//TestData/testdata.xlsx");

		//read in stream
		FileInputStream fs=new FileInputStream(f1);

		//wb-->sheet-->row--->cell--->data
		XSSFWorkbook wb=new XSSFWorkbook(fs);

		//number of rows
		int rows=wb.getSheet("userdata").getPhysicalNumberOfRows();
		System.out.println("Number of rows: "+rows);//6

		//number of cells
		int cells=wb.getSheet("userdata").getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of columns: "+cells);

		//create an array of same size like file
		Object data[][]=new Object[rows-1][cells];//reading only 5 rows


		//iterate array read data from file and save it in array

		for(int i=1;i<rows;i++)
		{

			for(int j=0;j<cells;j++)
			{
				//array always start with 0 index
				data[i-1][j]=wb.getSheet("userdata").getRow(i).getCell(j).getStringCellValue();
				System.out.print(data[i-1][j]+"  ");
			}
			System.out.println();
		}


	}
}