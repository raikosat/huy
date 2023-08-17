package demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.entity.Employee;
import demo.repository.EmployeeRepository;
import demo.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService {
  
  @Autowired
  private EmployeeRepository employeeRepository;

  @Override
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @Override
  public Employee addEmployee(Employee employee) {
    return employeeRepository.save(employee);
  }

  @Override
  public Employee getEmployeeById(Long id) {
    return employeeRepository.findById(id).get();
  }

  
  

  

}
