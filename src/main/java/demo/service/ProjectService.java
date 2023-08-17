package demo.service;

import java.util.List;
import demo.entity.Employee;
import demo.entity.Project;

public interface ProjectService {
  List<Project> getAllProjects();
  Project addProject(Project project);
  Project getProjectById(Long id);
  List<Employee> getEmployeesInProject(Long projectId);
  
  
}