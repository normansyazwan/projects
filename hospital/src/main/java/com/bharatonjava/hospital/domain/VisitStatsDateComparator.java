package com.bharatonjava.hospital.domain;

import java.util.Comparator;

public class VisitStatsDateComparator implements Comparator<VisitStats> {

	@Override
	public int compare(VisitStats o1, VisitStats o2) {
		if (o1.getDate().after(o2.getDate())) {
			return -1;
		} else if (o1.getDate().before(o2.getDate())) {
			return 1;
		}else{
			return 0;
		}
	}

}
