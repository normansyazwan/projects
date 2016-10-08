package com.bharatonjava.matri.utils;

import java.util.ArrayList;
import java.util.List;

public class Utils {

	private static List<String> maritalStatus;
	
	/**
	 * This is a utility class, hence private constructor.
	 */
	private Utils() {
	}
	
	public static List<String> getMaritalStatus(){
		
		if(maritalStatus == null){
			maritalStatus = new ArrayList<>();
			maritalStatus.add("Unmarried");
			maritalStatus.add("Divorcee");
			maritalStatus.add("Widow/Widower");
			return maritalStatus;
		}else{
			return maritalStatus;
		}
	}
}
