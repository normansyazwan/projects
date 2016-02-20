package com.bharatonjava.restservice.cache;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CacheDaoImpl implements CacheDao{

	private static final Logger logger = LoggerFactory
			.getLogger(CacheDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<ObjectType> getAllObjectTypes() {
		String sql = "select o.objecttype,o.version,o.view_name,m.column_name,m.column_alias,m.field"
				+ " from md_objecttype o join md_mapping m "
				+ " on o.objecttype = m.objecttype and o.version=m.version"
				+ " order by o.objecttype,o.version";
		List<ObjectType> mappings = this.jdbcTemplate.query(sql,new CacheResultsetExtractor());
		logger.info("mappings: {}", mappings);
		return mappings;
	}

}
