package com.bharatonjava.hospital.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IPatientDao;
import com.bharatonjava.hospital.dao.IStatsDao;
import com.bharatonjava.hospital.domain.VisitStats;

@Service
public class StatsService {

	
	private IPatientDao patientDao;
	private IStatsDao statsDao;
	
	public StatsService() {
	}
	
	@Autowired
	public void setPatientDao(IPatientDao patientDao) {
		this.patientDao = patientDao;
	}
	
	@Autowired
	public void setStatsDao(IStatsDao statsDao) {
		this.statsDao = statsDao;
	}
	
	@Transactional
	public List<VisitStats> getPatientVisitTrend(){
		return statsDao.getPatientVisitTrend();
	}
	
}
