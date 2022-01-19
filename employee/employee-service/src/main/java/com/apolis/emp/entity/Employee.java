package com.apolis.emp.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "EMPLOYEE")
public class Employee implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Integer empId;
	
	private String empName;
	
	private Double empSal;
	
	private String address;

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee(Integer empId, String empName, Double empSal, String address) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empSal = empSal;
		this.address = address;
	}
	
	
	public Employee() {
		
	}
	
}
