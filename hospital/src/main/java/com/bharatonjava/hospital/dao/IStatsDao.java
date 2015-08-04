package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.VisitStats;

public interface IStatsDao {

	public List<VisitStats> getPatientVisitTrend();
}
