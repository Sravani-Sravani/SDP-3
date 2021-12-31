package com.klu.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student_table")
public class Student {
  
  @Id
  @Column(name="stu_id")
  private int id;
  @Column(name="stu_name")
  private String name;
  @Column(name="stu_email")
  private String email;
  @Column(name="stu_pass")
  private String password;
  @Column(name="stu_status",columnDefinition = "varchar(255) default 'FALSE'")
  private String status;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  
  public void setStatus(String status)
  {
    this.status=status;
  }
  public String getPassword()
  {
    return password;
  }
  
  public void setPassword(String password)
  {
    this.password=password;
  }
  public String getStatus()
  {
    return status;
  }
  
  

}
