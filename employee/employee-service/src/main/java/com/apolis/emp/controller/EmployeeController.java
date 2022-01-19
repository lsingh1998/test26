package com.apolis.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.emp.entity.Employee;
import com.apolis.emp.entity.EmployeeData;
import com.apolis.emp.service.EmployeeService;


//Testing push to rep


@RestController
@RequestMapping("/employee-service")
public class EmployeeController {
	
	@Autowired
	EmployeeService  employeeService;
	
	/**
	 * create an employee
	 * @param emp
	 * @return
	 * http://localhost:8080/employee-service/saveEmplyee
	 * {"empId":801,
		 "empName":"Jacob",
		 "empSal":"180000.00",
		 "address":"newyork"
		}
	 */
	@PostMapping("/saveEmplyee")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee emp) {
		Employee employee = null;
		try {
			employee = employeeService.saveEmployee(emp);
			if (employee != null)
				return new ResponseEntity<Employee>(employee, HttpStatus.OK);
			else
				return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.NO_CONTENT);

	}
	/**
	 * Get All Employees
	 * @return
	 * http://localhost:8080/employee-service/getAllEmployees
	 */
	
	@GetMapping("/getAllEmployees")
	public ResponseEntity<EmployeeData>  getAll(){
		EmployeeData data = new EmployeeData();
		try {
			List<Employee> list =   employeeService.getAllEmployees();
			data.setEmployees(list);
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(data.getEmployees() != null)
		return new ResponseEntity<EmployeeData>(data,HttpStatus.OK);
		else
			return new ResponseEntity<EmployeeData>(data,HttpStatus.NO_CONTENT);
	}
	
	/**
	 * update an employee
	 * @param emp
	 * @return
	 * http://localhost:8080/employee-service/updateEmployee
	 * {"empId":804,
		 "empName":"Rajashekar",
		 "empSal":"180000.00",
		 "address":"newyork"
		}
	 */
	@PutMapping("/updateEmployee")
	public  ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		return employeeService.updateEmployee(emp);
	}
	
	/**
	 * @RequestParam example
	 * @param empId
	 * @return
	 * http://localhost:8080/employee-service/getEmployeeById?empId=802
	 */
	@GetMapping("/getEmployeeById")
	public  ResponseEntity<Employee> getEmployeeById(@RequestParam(required = false) Integer empId){
		return employeeService.getEmployeeById(empId);
	}
	
	/**
	 * @PathVariable  example
	 * @param empId
	 * @return
	 * http://localhost:8080/employee-service/getEmployeeById/803
	 */
	@GetMapping("/getEmployeeById/{empId}")
	public  ResponseEntity<Employee> getEmployeeByIdPathParam(@PathVariable(value = "empId") Integer empId){
		return employeeService.getEmployeeById(empId);
	}

	@DeleteMapping("/deleteEmployee/{empId}")
	public  ResponseEntity<Boolean> deleteEmployee(@PathVariable(value = "empId") Integer empId){
		Boolean isDeleted = employeeService.deleteEmplyee(empId);
		return new ResponseEntity<Boolean>(isDeleted,HttpStatus.OK);
	}
	
	@GetMapping("/getEmployeeByAddressAndId")
	public  ResponseEntity<Employee> getEmployeeByAddressAndId(@RequestParam(required = false) Integer empId,@RequestParam(required = false) String address){
		return employeeService.findByEmplyeeAddress(empId,address);
	}
}
