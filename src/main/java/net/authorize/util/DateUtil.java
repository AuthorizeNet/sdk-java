package net.authorize.util;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateUtil{
	public static Date getDateFromFormattedDate(String dateStr,String format){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			if(dateStr!=null && !"XXXX".equals(dateStr)){
				Date date=sdf.parse(dateStr);
				return date;
			}
		}
		catch(ParseException pe){
			System.out.println("Exception: " + pe);
		}
		return new Date(0);
	}

	public static String getFormattedDate(Date date, String format){
		try{
			SimpleDateFormat sdf=new SimpleDateFormat(format);
			return sdf.format(date);
		}
		catch(Exception e){
			System.out.println(e);
		}
		return null;
	}
}
