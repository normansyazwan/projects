package com.bharatonjava.therapymanager.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

	public static Map<Integer, String> monthsMap = new HashMap<Integer, String>();

	static {
		monthsMap.put(1, "January");
		monthsMap.put(2, "February");
		monthsMap.put(3, "March");
		monthsMap.put(4, "April");
		monthsMap.put(5, "May");
		monthsMap.put(6, "June");
		monthsMap.put(7, "July");
		monthsMap.put(8, "August");
		monthsMap.put(9, "September");
		monthsMap.put(10, "October");
		monthsMap.put(11, "November");
		monthsMap.put(12, "December");
	}
	
	private Utils() {}
	
	
	/**
	 * Finds size of collection taking care of null check.
	 * @param list
	 * @return
	 */
	public static int size(List<?> list){
		if(list != null){
			return list.size();
		}else{
			return 0;
		}
	}
	
}
