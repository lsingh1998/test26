package com.apolis.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apolis.emp.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query(value = "from Employee emp where emp.empId = ?1 and emp.address =?2")
	Employee findByEmployeeAddressAndId(Integer empId,String adress);

}
