package demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "employee")
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "full_name")
  private String fullName;

  @Column(name = "address")
  private String address;

  @Column(name = "phone")
  private String phone;

  @Column(name = "years_of_experience")
  private Integer yearsOfExperience;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "birthday")
  private Date birthday;

  @Column(name = "gender")
  private String gender;

  @Column(name = "office")
  private String office;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_start_work")
  private Date dateStartWork;

  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name = "date_off_work")
  private Date dateOffWork;

  @Column(name = "photo")
  private String photo;
  
  @Column(name = "status")
  private Integer status;
  
  @ManyToMany(mappedBy = "employees")
  @JsonIgnore
  private List<Project> projects = new ArrayList<>();
 

 


}
