package org.study.dao;

import java.util.List;

public interface EmployeeService {

	public boolean saveEmployee(Employee e);
	
	public List<Employee> listEmployee();
	
	public Employee listEmployee(int id);
	
	public boolean deleteEmployee(int id);
	
	public boolean updateEmployee(Employee e);
}
