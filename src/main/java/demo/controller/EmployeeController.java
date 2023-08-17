package demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import demo.entity.Employee;
import demo.repository.EmployeeRepository;
import demo.service.EmployeeService;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("employee")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;
  
  @Autowired
  private EmployeeRepository employeeRepository; 
  
  @GetMapping("/list")
  public ResponseEntity<List<Employee>> getListEmployee(){
    List<Employee> result = employeeService.getAllEmployees();
    return ResponseEntity.ok(result);
  }

  @PostMapping("/add")
  public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
    return ResponseEntity.ok(employeeService.addEmployee(employee));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long id) {
    return ResponseEntity.ok(employeeService.getEmployeeById(id));
  }
  
  @PostMapping("/update/{id}")
  public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employee )  { 
    Employee employee1 = employeeService.getEmployeeById(id);
    employee1.setFullName(employee.getFullName());
    employee1.setAddress(employee.getAddress());
    employee1.setPhone(employee.getPhone());
    employee1.setYearsOfExperience(employee.getYearsOfExperience());
    employee1.setBirthday(employee.getBirthday());
    employee1.setGender(employee.getGender());
    employee1.setOffice(employee.getOffice());
    employee1.setDateStartWork(employee.getDateStartWork());
    employee1.setDateOffWork(employee.getDateOffWork());
    employeeRepository.save(employee1);
    
    return ResponseEntity.ok(employee1);

   
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
      Employee employee = employeeService.getEmployeeById(id);
      employeeRepository.delete(employee);
      return ResponseEntity.ok(employee);
  }
  
}
