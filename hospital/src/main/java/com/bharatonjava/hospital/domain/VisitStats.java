package com.bharatonjava.hospital.domain;

import java.util.Date;

public class VisitStats {

	private Date date;
	private Long count;
	
	public VisitStats() {
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "VisitStats [date=" + date + ", count=" + count + "]";
	}
	
	
}
