package com.bharatonjava.restservice.cache;

public class Mapping {

	private String field;
	private String column;
	private String datatype;
	private String alias;

	public Mapping() {
	}

	public Mapping(String field, String column, String alias) {
		this.field = field;
		this.column = column;
		this.alias = alias;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getDatatype() {
		return datatype;
	}

	public void setDatatype(String datatype) {
		this.datatype = datatype;
	}

	@Override
	public String toString() {
		return "Mapping [field=" + field + ", column=" + column + ", datatype="
				+ datatype + ", alias=" + alias + "]";
	}

}
