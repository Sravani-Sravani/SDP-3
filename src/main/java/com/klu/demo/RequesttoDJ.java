package com.klu.demo;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="requesttodelete")
public class RequesttoDJ 
{
	 @Id
	  @Column(name = "id")	 
	   private int id;
	 @Column(name = "role")
	  private String role;
		@Column(name = "org")
		  private String org;
	 public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getOrg() {
		return org;
	}
	public void setOrg(String org) {
		this.org = org;
	}
	public RequesttoDJ() {
		super();
	}
	public RequesttoDJ(int id, String role, String org) {
		super();
		this.id = id;
		this.role = role;
		this.org = org;
	}

}