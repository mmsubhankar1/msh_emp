package com.msh.service.impl;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msh.dto.Employee;
import com.msh.repository.EmployeeRepository;
import com.msh.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    public Employee saveEmp(Employee employee)
    {
    	return employeeRepository.save(employee);
    }
    
    public void deleteEmp(Employee employee)
    {
    	employeeRepository.delete(employee);
    }
    
    public List<Employee> getEmp(Long empId)
    {
    	List<Employee> employees = null;
    	if(empId>0)
    	{
    		Optional<Employee> employeeOptional = employeeRepository.findById(empId);
    		Employee employee = employeeOptional.get();
    		employees = new LinkedList<>();
    		employees.add(employee);
    	}
    	else
    	{
    		employees = employeeRepository.findAll();
    	}
    	
    	return employees;
    }

}
