package com.klu.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addjob_table")
public class AddJob {
  
  
  @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id")
  private int id;
  @Column(name = "org")
  private String org;
  @Column(name = "role")
  private String role;
  @Column(name = "loc")
  private String loc;
  @Column(name = "tp")
  private int tp;
  @Column(name = "amt")
  private double amt;
  @Column(name = "yr")
  private int yr;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getOrg() {
    return org;
  }
  public void setOrg(String org) {
    this.org = org;
  }
  public String getRole() {
    return role;
  }
  public void setRole(String role) {
    this.role = role;
  }
  public String getLoc() {
    return loc;
  }
  public void setLoc(String loc) {
    this.loc = loc;
  }
  public int getTp() {
    return tp;
  }
  public void setTp(int tp) {
    this.tp = tp;
  }
  public double getAmt() {
    return amt;
  }
  public void setAmt(double amt) {
    this.amt = amt;
  }
  public int getYr() {
    return yr;
  }
  public void setYr(int yr) {
    this.yr = yr;
  }
  
  
  

}