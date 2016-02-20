package com.bharatonjava.restservice.cache;

import java.util.ArrayList;
import java.util.List;

public class ObjectType {

	private String objectType;
	private int schemaVersion;
	private String primaryKey;
	private String viewName;
	private List<Mapping> mappings;

	public ObjectType() {
		mappings = new ArrayList<Mapping>();
	}

	public ObjectType(String objectType, int schemaVersion, String viewName,String primaryKey) {
		this();
		this.objectType = objectType;
		this.schemaVersion = schemaVersion;
		this.viewName = viewName;
		this.primaryKey = primaryKey;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public int getSchemaVersion() {
		return schemaVersion;
	}

	public void setSchemaVersion(int schemaVersion) {
		this.schemaVersion = schemaVersion;
	}

	public String getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getViewName() {
		return viewName;
	}
	
	public void setViewName(String viewName) {
		this.viewName = viewName;
	}
	
	public List<Mapping> getMappings() {
		return mappings;
	}

	public void setMappings(List<Mapping> mappings) {
		this.mappings = mappings;
	}

	@Override
	public String toString() {
		return "ObjectType [objectType=" + objectType + ", schemaVersion="
				+ schemaVersion + ", primaryKey=" + primaryKey + ", viewName="
				+ viewName + ", mappings=" + mappings + "]";
	}
	
	
}
