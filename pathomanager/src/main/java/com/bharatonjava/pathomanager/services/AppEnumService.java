package com.bharatonjava.pathomanager.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.pathomanager.dao.EnumerationDao;
import com.bharatonjava.pathomanager.domain.AppEnum;

@Service
public class AppEnumService {

	private static final Logger log = LoggerFactory
			.getLogger(AppEnumService.class);
	private EnumerationDao enumerationDao;

	@Autowired
	public void setEnumerationDao(EnumerationDao enumerationDao) {
		this.enumerationDao = enumerationDao;
	}

	@Transactional
	public List<AppEnum> getAppEnumsByGroup(String enumGroup) {
		return enumerationDao.getAppEnumsByGroup(enumGroup);
	}

	@Transactional
	public int deleteAppEnum(Long enumId) {
		return enumerationDao.deleteAppEnum(enumId);
	}
	
	@Transactional
	public AppEnum getAppEnumsById(Long enumId){
		return enumerationDao.getAppEnumsById(enumId);
	}
}
