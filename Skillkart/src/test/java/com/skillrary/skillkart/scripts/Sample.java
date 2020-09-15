package com.skillrary.skillkart.scripts;

import com.skillrary.skillkart.generic.AutoConstants;
import com.skillrary.skillkart.generic.ExcelLibrary;

public class Sample implements AutoConstants
{
	public static void main(String[] args) 
	{
		Object[][] arr = ExcelLibrary.getExcelData(XL_PATH, "TC002");
		for(Object[] a: arr)
		{
			for(Object obj:a)
			{
				System.out.print(obj);
			}
			System.out.println();
		}
	}
}
