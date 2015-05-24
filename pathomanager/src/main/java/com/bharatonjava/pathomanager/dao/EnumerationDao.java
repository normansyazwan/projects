package com.bharatonjava.pathomanager.dao;

import java.util.List;

import com.bharatonjava.pathomanager.domain.AppEnum;

public interface EnumerationDao {
	
	public int saveAppEnum(AppEnum appEnum);
	
	public int updateAppEnum(AppEnum appEnum);
	
	public int deleteAppEnum(AppEnum appEnum);
	
	public int deleteAppEnum(Long enumId);
	
	public List<AppEnum> getAppEnumsByGroup(String enumGroup);
	
	public AppEnum getAppEnumsById(Long enumId);
	
}
