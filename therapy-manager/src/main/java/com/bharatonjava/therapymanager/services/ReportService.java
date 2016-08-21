package com.bharatonjava.therapymanager.services;

import java.util.Calendar;
import java.util.Date;
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
	public List<DailyEarningsDto> getEarnings(Integer year, Integer month){
		
		// if nothing is selected in UI dropdowns then select current year and month
		if((month == null && year == null)||(month == 0 && year == 0)){
			Calendar cal = Calendar.getInstance();
			year = cal.get(Calendar.YEAR);
			month = cal.get(Calendar.MONTH) + 1;
		}
		
		return reportDao.getEarnings(year, month);
	}
	
	@Transactional
	public List<Long> getYearsForSittings(){
		return reportDao.getYearsForSittings();
	}
	
	@Transactional
	public List<DailyEarningsDto> getEarningsPerDay(Date date){
		return reportDao.getEarningsPerDay(date);
	}
}
