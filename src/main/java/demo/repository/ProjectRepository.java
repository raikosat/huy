package demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import demo.entity.Employee;
import demo.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
  
  @Query(value = "SELECT e.* FROM employee e JOIN project_employee pe ON e.id = pe.employee_id WHERE pe.project_id = :projectId", nativeQuery = true)
  List<Employee> findEmployeesByProjectId(@Param("projectId") Long projectId);

  
  
}
