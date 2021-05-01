package com.msh.service;

import java.util.List;

import com.msh.dto.Employee;

public interface EmployeeService {
	Employee saveEmp(Employee employee);
	void deleteEmp(Employee employee);
	List<Employee> getEmp(Long empId);
}
