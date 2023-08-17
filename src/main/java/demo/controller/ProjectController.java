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
import demo.entity.Project;
import demo.repository.ProjectRepository;
import demo.service.ProjectService;

@CrossOrigin(origins = "http://localhost:4200/", maxAge = 3600)
@RestController
@RequestMapping("project")
public class ProjectController {

  @Autowired
  private ProjectService projectService;
  
  @Autowired
  private ProjectRepository projectRepository;
  
  
  @GetMapping("/list")
  public ResponseEntity<List<Project>> getListProject(){
    List<Project> result = projectService.getAllProjects();
    return ResponseEntity.ok(result);
  }
  
  @PostMapping("/add")
  public ResponseEntity<Project> addProject(@RequestBody Project project) {
    return ResponseEntity.ok(projectService.addProject(project));
  }
  
  @GetMapping("/{id}")
  public ResponseEntity<Project> getProjectById(@PathVariable("id") long id) {
    return ResponseEntity.ok(projectService.getProjectById(id));
  }
  
  @PostMapping("/update/{id}")
  public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project project )  { 
    Project project1 = projectService.getProjectById(id);
    project1.setNameProject(project.getNameProject());
    project1.setDateStart(project.getDateStart());
    project1.setDateEnd(project.getDateEnd());
    projectRepository.save(project1);
    return ResponseEntity.ok(project1);
  }
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Project> deleteProject(@PathVariable Long id) {
      Project project = projectService.getProjectById(id);
      projectRepository.delete(project);
      return ResponseEntity.ok(project);
  }
  
  @GetMapping("/{projectId}/employees")
  public ResponseEntity<List<Employee>> getEmployeesInProject(@PathVariable Long projectId) {
    List<Employee> employees = projectService.getEmployeesInProject(projectId);
    
    if (employees.isEmpty()) {
        return ResponseEntity.noContent().build();
    }

    return ResponseEntity.ok(employees);
}
  
}
