package com.msh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.msh.dto.Employee;
import com.msh.service.EmployeeService;
import com.msh.util.ResponseObject;

@Controller
@RequestMapping("/emp")
public class MainController {
	
	@Autowired
	EmployeeService employeeService; 
	
	
    @PostMapping("/create-emp")
    public ResponseEntity<ResponseObject> createEmployee(@RequestBody Employee employee) {
    	ResponseObject responseObject = new ResponseObject();
    	try {
    		Employee employee2 = employeeService.saveEmp(employee);
    		responseObject.setResObject(employee2);
    		responseObject.setResult(1);
    		responseObject.populateMsg("Data saved successfully");
    	}
    	catch (Exception e) {
    		responseObject.setResult(0);
    		responseObject.populateMsg("Error at the time of save data");
		}
    	return ResponseEntity.accepted().body(responseObject);
    }

    @PostMapping("/update-emp")
    public ResponseEntity<ResponseObject> updateEmployee(@RequestBody Employee employee) {
    	ResponseObject responseObject = new ResponseObject();
    	try {
    		employeeService.saveEmp(employee);
    		responseObject.setResObject(employee);
    		responseObject.setResult(1);
    		responseObject.populateMsg("Data updated successfully");
    	}
    	catch (Exception e) {
    		responseObject.setResult(0);
    		responseObject.populateMsg("Error at the time of update data");
		}
    	return ResponseEntity.accepted().body(responseObject);
    }
    @PostMapping("/delete-emp")
    public ResponseEntity<ResponseObject> deleteEmployee(@RequestBody Employee employee) {
    	ResponseObject responseObject = new ResponseObject();
    	try {
    		employeeService.deleteEmp(employee);
    		responseObject.setResult(1);
    		responseObject.populateMsg("Data deleted successfully");
    	}
    	catch (Exception e) {
    		responseObject.setResult(0);
    		responseObject.populateMsg("Error at the time of delete data");
		}
    	return ResponseEntity.accepted().body(responseObject);
    }
    
    @GetMapping("/get-emp")
    public ResponseEntity<ResponseObject>  getEmployee(Long empId) {
    	ResponseObject responseObject = new ResponseObject();
    	try {
    		List<Employee> employees = employeeService.getEmp(empId);
    		responseObject.setResObject(employees);
    		responseObject.setResult(1);
    	}
    	catch (Exception e) {
    		responseObject.setResult(0);
    		responseObject.populateMsg("Error at the time of fetch data");
		}
    	return ResponseEntity.accepted().body(responseObject);
    }
}
