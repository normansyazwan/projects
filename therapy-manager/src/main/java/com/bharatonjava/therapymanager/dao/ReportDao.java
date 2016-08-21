package com.bharatonjava.therapymanager.dao;

import java.util.List;

import com.bharatonjava.therapymanager.domain.DailyEarningsDto;

public interface ReportDao {

	public List<DailyEarningsDto> getDailyEarnings();
	
}
