package com.bharatonjava.restservice.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bharatonjava.restservice.gateway.ProcessingException;
import com.bharatonjava.restservice.gateway.RestRequest;
import com.bharatonjava.restservice.gateway.ServiceStatus;
import com.bharatonjava.restservice.marshaller.MysqlDataMarshaller;
import com.bharatonjava.restservice.queryBuilder.MysqlQueryBuilder;
import com.bharatonjava.restservice.queryBuilder.QueryBuilder;
import com.bharatonjava.restservice.utils.ContextUtils;
import com.bharatonjava.restservice.validations.RequestValidator;

public class DefaultDataService {

	private static final Logger log = LoggerFactory
			.getLogger(DefaultDataService.class);

	

	public DefaultDataService() {

	}

	public void getData(RestRequest request, ServiceStatus status) throws ProcessingException {

		log.info("Inside getData.. to get data");
		
		
		// validate request
		if(!validateRequest(request, status)){
			throw new ProcessingException("Invalid Request!!");
		}
		
		// build query
		QueryBuilder queryBuilder = new MysqlQueryBuilder();
		String sql = queryBuilder.getQueryForRequest(request);

		// execute query
		DataSource dataSource = (DataSource) ContextUtils.getBean("dataSource");
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			executeQuery(request, sql, conn);

			// write data to stream
			MysqlDataMarshaller marshaller = new MysqlDataMarshaller();
			marshaller.writeData(request);
		} catch (SQLException e) {
			throw new ProcessingException(
					"Error while getting executing query", e);
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				log.error("Error while closing connection in Service.", e);
			}
		}

	}

	public boolean validateRequest(RestRequest request, ServiceStatus status){
		
		boolean isValidRequest = true;
		if(!RequestValidator.validateObjectType(request, status)){
			log.info("Object Type is invalid");
			isValidRequest = false;
		}
		return isValidRequest;
	}
	
	private void executeQuery(RestRequest request, String sql, Connection conn) {

		ResultSet rs = null;
		Statement stmt = null;

		try {

			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
			request.setResultSet(rs);
		} catch (Exception e) {
			log.error("Exception occured while executing query.", e);
		} finally {
			try {
				// stmt.close();
				// conn.close();
			} catch (Exception e) {
				log.error("Exception while closing connection in dataDataService.");
			}
		}

	}

}
