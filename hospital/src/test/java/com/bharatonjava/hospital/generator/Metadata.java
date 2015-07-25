package com.bharatonjava.hospital.generator;

import java.util.HashSet;
import java.util.Set;

public class Metadata {

	private String basePackage;
	private String className;
	private boolean generateCreate;
	private boolean generateRead;
	private boolean generateUpdate;
	private boolean generateDelete;
	private boolean hibernateEnabled;
	
	private Set<Field> fields;

	public Metadata() {
		fields = new HashSet<Field>();
	}

	public String getBasePackage() {
		return basePackage;
	}
	
	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isGenerateCreate() {
		return generateCreate;
	}

	public void setGenerateCreate(boolean generateCreate) {
		this.generateCreate = generateCreate;
	}

	public boolean isGenerateRead() {
		return generateRead;
	}

	public void setGenerateRead(boolean generateRead) {
		this.generateRead = generateRead;
	}

	public boolean isGenerateUpdate() {
		return generateUpdate;
	}

	public void setGenerateUpdate(boolean generateUpdate) {
		this.generateUpdate = generateUpdate;
	}

	public boolean isGenerateDelete() {
		return generateDelete;
	}

	public void setGenerateDelete(boolean generateDelete) {
		this.generateDelete = generateDelete;
	}

	public boolean isHibernateEnabled() {
		return hibernateEnabled;
	}

	public void setHibernateEnabled(boolean hibernateEnabled) {
		this.hibernateEnabled = hibernateEnabled;
	}

	public Set<Field> getFields() {
		return fields;
	}

	public void setFields(Set<Field> fields) {
		this.fields = fields;
	}

}
