package demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "project")
public class Project {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name_project")
  private String nameProject;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_start")
  private Date dateStart;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_end")
  private Date dateEnd;
  
  

  @ManyToMany
  @JoinTable(
      name = "project_employee",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name = "employee_id")
  )
  private List<Employee> employees = new ArrayList<>();
  
  public List<Employee> getEmployees() {
    return employees;
}

}
