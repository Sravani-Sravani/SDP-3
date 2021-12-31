package com.klu.demo;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="org")
public class Organization 
{  
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="sno")
  private int sno;
  @Lob
  
  @Column(name="img")
  private byte[] img;
  @Column(name="name")
  private String name;
  @Column(name="email")
  private String email;
  @Column(name="password")
  private String password;
  public int getSno() {
    return sno;
  }
  public void setSno(int sno) {
    this.sno = sno;
  }
  public byte[] getImg() {
    return img;
  }
  public void setImg(byte[] img) {
    this.img = img;
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
  public String getPassword() {
    return password;
  }
  public Organization(byte[] img, String name, String email, String password) {
	super();
	this.img = img;
	this.name = name;
	this.email = email;
	this.password = password;
}
public Organization() {
	super();
}
public void setPassword(String password) {
    this.password = password;
  }
}