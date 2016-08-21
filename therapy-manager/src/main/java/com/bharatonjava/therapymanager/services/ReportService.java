package com.bharatonjava.therapymanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.therapymanager.dao.ReportDao;
import com.bharatonjava.therapymanager.domain.DailyEarningsDto;

@Service
public class ReportService {

	private ReportDao reportDao;
	
	@Autowired
	public void setReportDao(ReportDao reportDao) {
		this.reportDao = reportDao;
	}
	
	@Transactional
	public List<DailyEarningsDto> getDailyEarnings(){
		return reportDao.getDailyEarnings();
	}
}
