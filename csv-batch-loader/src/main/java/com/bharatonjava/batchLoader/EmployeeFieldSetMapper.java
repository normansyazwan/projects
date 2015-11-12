package com.bharatonjava.batchLoader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

public class EmployeeFieldSetMapper implements FieldSetMapper<Employee> {

	public Employee mapFieldSet(FieldSet fieldSet) throws BindException {
		
		Employee e = new Employee();
		e.setId(fieldSet.readInt("id"));
		e.setName(fieldSet.readString("name"));
		e.setAge(fieldSet.readInt("age"));
		e.setSalary(fieldSet.readDouble("salary"));

		System.out.println("fieldSetMapper: "+ e);
		
		return e;
	}

}
