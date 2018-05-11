package org.study.dao;

import java.util.List;

public interface EmployeeService {//interface는 추상 메소드만 있다.
	
	public boolean SaveEmployee(Employee e);
	
	public  List<Employee> ListEmployee();
	
	public boolean DeleteEmployee(int id); 
	
	public boolean UpdateEmployee(Employee e);

}
