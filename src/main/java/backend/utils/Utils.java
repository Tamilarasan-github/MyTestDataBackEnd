package backend.utils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;

@Component
public class Utils
{

	public static Date formatDate(String format, Date inputDate)
	{
	SimpleDateFormat formatter = new SimpleDateFormat(format);
	Date date = inputDate;
	String dateAsString = formatter.format(date);
	Date outputDate =null;
	try
	{
		outputDate = new SimpleDateFormat(format).parse(dateAsString);
	} catch (ParseException e)
	{
		e.printStackTrace();
	}
	return outputDate;
	}
	
	public void callSetter(Object obj, String fieldName, Object value){
		  PropertyDescriptor pd;
		  try {
		   pd = new PropertyDescriptor(fieldName, obj.getClass());
		   pd.getWriteMethod().invoke(obj, value);
		  } catch (IntrospectionException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		 }
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
