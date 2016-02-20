package com.bharatonjava.restservice.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Cache {

	private static final Logger log = LoggerFactory
			.getLogger(Cache.class);
	private static Cache cache = new Cache();

	private static Map<String, ObjectType> objects;

	private static CacheDao cacheDao;
	
	private Cache() {
		objects = new HashMap<String, ObjectType>();
	}

	public static Cache getCache() {
		return cache;
	}
	
	public void setCacheDao(CacheDao cacheDao) {
		this.cacheDao = cacheDao;
	}
	
	public static void initialize(){
		//ContextUtils.getBean("dataSource");
		log.info("################ Started Initializing cache ################"); 
		/*
		ObjectType objectType = new ObjectType("DEMO",1,"V_DEMO","demo.id");
		Mapping mapping1 = new Mapping("demo.id", "demo_id", "demo_id");
		Mapping mapping2 = new Mapping("demo.version", "demo_version", "demo_version");
		Mapping mapping3 = new Mapping("demo.isin", "demo_isin", "demo_isin");
		objectType.getMappings().add(mapping1);
		objectType.getMappings().add(mapping2);
		objectType.getMappings().add(mapping3);
		
		objects.put("DEMO:1", objectType);
		*/
		
		List<ObjectType> objectTypes = cacheDao.getAllObjectTypes();
		for(ObjectType t : objectTypes){
			
			String key = t.getObjectType()+":"+Integer.toString(t.getSchemaVersion()); 
			objects.put(key, t);
			log.info("{} : {}",key, objects.get(key));
		}
		
		log.info("################ Finished Initializing cache ################");
	}
	
	public ObjectType getObject(String objectName){
		log.info("objectName: {}", objectName);
		ObjectType objectType = objects.get(objectName);
		log.info("objectType: {}", objectType);
		return objectType;
	}
}
