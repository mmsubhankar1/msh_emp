package net.javaguides.springboot.springsecurity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.msh.controller.MainController;
import com.msh.dto.Department;
import com.msh.dto.Employee;
import com.msh.dto.Organization;
import com.msh.service.EmployeeService;
import com.msh.util.ResponseObject;
@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class ApplicationTests {

	@InjectMocks
	MainController mainController;
	@Mock
	EmployeeService employeeService;
	
	@Test
    public void testAddEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Employee employee = new Employee();
        employee.setName("subhankar");
        Department department = new Department();
        department.setName("D1");
        Organization organization = new Organization();
        organization.setName("O1");
        department.setOrganization(organization);
        employee.setDepartment(department);
        ResponseEntity<ResponseObject> responseEntity = mainController.createEmployee(employee);
        ResponseObject object = responseEntity.getBody();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(object.getResult()).isEqualTo(1);
    }
	@Test
    public void testUpdateEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setName("xyz");
        ResponseEntity<ResponseObject> responseEntity = mainController.updateEmployee(employee);
        ResponseObject object = responseEntity.getBody();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(object.getResult()).isEqualTo(1);
    }
	@Test
    public void testDeleteEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Employee employee = new Employee();
        employee.setId(1L);
        ResponseEntity<ResponseObject> responseEntity = mainController.deleteEmployee(employee);
        ResponseObject object = responseEntity.getBody();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(object.getResult()).isEqualTo(1);
    }
	@Test
    public void testGetEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<ResponseObject> responseEntity = mainController.getEmployee(1L);
        ResponseObject object = responseEntity.getBody();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
        assertThat(object.getResult()).isEqualTo(1);
    }

}
