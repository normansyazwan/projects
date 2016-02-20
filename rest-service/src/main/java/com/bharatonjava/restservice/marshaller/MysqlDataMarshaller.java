package com.bharatonjava.restservice.marshaller;

import java.io.OutputStreamWriter;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bharatonjava.restservice.cache.Cache;
import com.bharatonjava.restservice.cache.Mapping;
import com.bharatonjava.restservice.cache.ObjectType;
import com.bharatonjava.restservice.gateway.ProcessingException;
import com.bharatonjava.restservice.gateway.RestRequest;
import com.bharatonjava.restservice.utils.Constants;

import freemarker.template.Template;

public class MysqlDataMarshaller implements DataMarshaller {
	private static final Logger log = LoggerFactory
			.getLogger(MysqlDataMarshaller.class);

	@Override
	public void writeData(RestRequest request) throws ProcessingException {

		log.info("Inside MysqlDataMarshaller..");
		String templateFileName = null;

		 // String[] arr = (String[]) request.getRequestMap().get(Constants.DATA_SCHEMA_VERSION);
		String  schemaVersion = (String) request.getRequestMap().get(Constants.DATA_SCHEMA_VERSION);
		templateFileName = request.getRequestMap().get(Constants.OBJECT_TYPE)
				+ "-" + Integer.parseInt(schemaVersion) + ".ftl";

		Template template = TemplateHelper.getTemplate(templateFileName);

		ResultSet rs = request.getResultSet();
		
		OutputStreamWriter writer = null;
		writer = new OutputStreamWriter(request.getOutputStream());
		int count = 0;
		try {
			//rs.first();
			while (rs.next()) {
		
				Map<Object, Object> rootMap = new HashMap<Object, Object>();
				
				if (rs.isFirst()) {
					rootMap.put("isFirst", "true");
				}
				
				ObjectType obj = Cache.getCache().getObject((String)request.getRequestMap().get(Constants.OBJECTTYPE_WITH_VERSION));
				
				ResultSetMetaData rsmd = rs.getMetaData();
				for(int i = 1; i <= rsmd.getColumnCount(); i++){
					log.info(rsmd.getColumnName(i) + " : "+ rsmd.getColumnType(i) + " : "+ rsmd.getColumnTypeName(i));
				}
				
				for(Mapping m : obj.getMappings()){
					
					
					
					// rootMap.put(m.getField(), )
				
				
				}
				
				rootMap.put("demo_id", rs.getInt("DEMO_ID"));
				rootMap.put("demo_version", rs.getInt("DEMO_VERSION"));
				rootMap.put("demo_isin", rs.getString("DEMO_ISIN"));
				count ++;
				
				if (rs.isLast()) {
					rootMap.put("isLast", "true");
				}
				
				log.debug("RootMap: {}", rootMap);
				
				template.process(rootMap, writer);
				
			}
		} catch (Exception e) {
			log.error("Exception in marshaller while writing to stream.",e);
		} finally {
			try {
				//rs.close();

			} catch (Exception e) {
				log.error("Exception while closing resultset in marshaller.");
			}
		}

		//log.info("template: {}", template);
	}
	
	
	private Object getValueFromResultSet(String columnName, String datatype, ResultSet rs){
		Object returnValue = null;
			switch (datatype) {
			case "string":
				break;
			case "integer":
				break;	
			default:
				break;
			}
		return returnValue;
	}
}
