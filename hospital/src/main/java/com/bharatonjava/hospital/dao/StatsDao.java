package com.bharatonjava.hospital.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.VisitStats;

@Repository
public class StatsDao implements IStatsDao {

	private static final Logger log = LoggerFactory.getLogger(StatsDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<VisitStats> getPatientVisitTrend() {

		// select date_format(CREATED_TIMESTAMP, '%d %m %Y'), COUNT(1) from
		// PRESCRIPTION GROUP BY date_format(CREATED_TIMESTAMP, '%d %m %Y');

		Session session = sessionFactory.getCurrentSession();
		String hql = "select cast(p.createdTimestamp as date) as date, count(1) as count from Prescription p "
				+ "group by cast(p.createdTimestamp as date) order by cast(p.createdTimestamp as date) desc";
		Query query = session
				.createQuery(hql);
		query.setResultTransformer(Transformers.aliasToBean(VisitStats.class));
		query.setMaxResults(60);
		List<VisitStats> lst = query.list();
		log.info("{}", lst);
		return lst;
	}

}
