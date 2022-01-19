package com.apolis.emp.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.apolis.emp.entity.Employee;

public interface EmployeeService {

	
	
	Employee saveEmployee(Employee employee);
	
	ResponseEntity<Employee> updateEmployee(Employee employee);
	
	List<Employee> getAllEmployees();
	
	ResponseEntity<Employee> getEmployeeById(Integer empId);
	
	boolean deleteEmplyee(Integer empId);

	ResponseEntity<Employee> findByEmplyeeAddress(Integer empId, String address);
	
}
