package com.apolis.emp.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.apolis.emp.entity.Employee;
import com.apolis.emp.repository.EmployeeRepository;
import com.apolis.emp.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public ResponseEntity<Employee> updateEmployee(Employee employee) {
		Employee emp = null;
		try {
			 emp = employeeRepository.save(employee);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(emp != null) {
			return new ResponseEntity<Employee>(emp,HttpStatus.OK);
		}else {
			return new ResponseEntity<Employee>(emp,HttpStatus.NO_CONTENT);	
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public ResponseEntity<Employee> getEmployeeById(Integer empId) {
		Optional<Employee> emp =  employeeRepository.findById(empId);
		return new ResponseEntity<Employee>(emp.get(),HttpStatus.OK);
	}

	@Override
	public boolean deleteEmplyee(Integer empId) {
		 employeeRepository.deleteById(empId);
		 return true;
	}

	@Override
	public ResponseEntity<Employee> findByEmplyeeAddress(Integer empId, String address) {
		
		Employee emp = employeeRepository.findByEmployeeAddressAndId(empId, address);
		return new ResponseEntity<Employee>(emp,HttpStatus.OK);
	}



}
