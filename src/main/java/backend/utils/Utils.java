package backend.utils;

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

import backend.applications.applicationOne.TestDataMetaAppOneEntity;
import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;

public class Utils
{

	public Date formatDate(String format, Date inputDate)
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
}
