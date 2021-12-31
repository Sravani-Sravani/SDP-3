package com.klu.demo;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;

@Entity
@Table(name = "apply")
public class ApplyJob {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    
    private long stuid;

    private String fileName;

    private String fileType;
    
    private String fullname;
    
    private String message;
    
    private String email;

    private String org;
    
    
    private String status;
    
    private String role;
    
    
    public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getOrg() {
		return org;
	}


	public void setOrg(String org) {
		this.org = org;
	}
	
	
	@Lob
    private byte[] data;

   public ApplyJob()
   {
     
   }
   

  public ApplyJob(String fileName, String fileType,byte[] data, long stuid, String fullname, String message, String email) {
    super();
    this.stuid=stuid;
    this.fileName = fileName;
    this.fileType = fileType;
    this.fullname = fullname;
    this.message = message;
    this.email = email;
    this.data = data;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }
  
  public void setStuid(long stuid)
  {
    this.stuid=stuid;
  }
  public long getStuid()
  {
    return stuid;
  }

   
}