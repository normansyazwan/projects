package com.bharatonjava.batchLoader;

import org.springframework.batch.item.ItemProcessor;

public class EmployeeProcessor implements ItemProcessor<Employee, Employee>{

	public Employee process(Employee e) throws Exception {
		if(e != null){
			doProcessing(e);
		}
		return e;
	}
	
	private Employee doProcessing(Employee e){
		// convert name to upper case;
		if(e.getName() != null){
			e.setName(e.getName().toUpperCase());
		}
		return e;
	}
	
}
