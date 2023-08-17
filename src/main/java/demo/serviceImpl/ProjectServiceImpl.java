package demo.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import demo.entity.Employee;
import demo.entity.Project;
import demo.repository.ProjectRepository;
import demo.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  public ProjectRepository projectRepository;

  @Override
  public List<Project> getAllProjects() {
    return projectRepository.findAll();
  }

  @Override
  public Project addProject(Project project) {
    return projectRepository.save(project);
  }

  @Override
  public Project getProjectById(Long id) {
    return projectRepository.findById(id).get();
  }

  @Override
  public List<Employee> getEmployeesInProject(Long projectId) {
    return projectRepository.findEmployeesByProjectId(projectId);
  }

 
    
}
