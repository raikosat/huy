package demo.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.entity.Employee;
import demo.repository.EmployeeRepository;


public interface EmployeeService {
  
 List<Employee> getAllEmployees();
 Employee addEmployee(Employee employee);
 Employee getEmployeeById(Long id);

    

}