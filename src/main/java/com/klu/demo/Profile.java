package com.klu.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="Profile")
public class Profile 
{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;
	@Column(name = "aemail")
    private String aemail;
	@Column(name = "bgyear")
    private int bgyear;
	@Column(name = "cname")
    private String cname;
	@Column(name = "dgender")
    private String dgender;
	@Column(name = "esname")
    private String esname;
	@Column(name = "fcname")
    private String fcname;
	@Column(name = "gscgpa")
    private double gscgpa;
	@Column(name = "hccgpa")
    private double hccgpa;
	@Column(name = "igcname")
    private String igcname;
	@Column(name = "jbranch")
    private String jbranch;
	@Column(name = "kgcgpa")
    private double kgcgpa;
	@Column(name = "lspec")
    private String lspec;
	@Column(name = "mskills")
    private String mskills;
	@Column(name = "nproject")
    private String nproject;
	@Column(name = "oexperience")
    private String oexperience;
@Lob
@Column(name = "pfile")
private byte[] pfile;
@Column(name = "qspecs")
private String qspecs;
@Transient
private String base64Img;

@Column(name="dt")
private String dt;


public String getDt() {
	return dt;
}

public void setDt(String dt) {
	this.dt = dt;
}

public String getBase64Img() {
	return base64Img;
}

public void setBase64Img(String base64Img) {
	this.base64Img = base64Img;
}

public Profile() {
    super();
   
}

	public Profile(String aemail, int bgyear, String cname, String dgender, String esname, String fcname,
			double gscgpa, double hccgpa, String igcname, String jbranch, double kgcgpa, String lspec, String mskills,
			String nproject, String oexperience, byte[] pfile, String qspecs) {
		super();
		this.aemail = aemail;
		this.bgyear = bgyear;
		this.cname = cname;
		this.dgender = dgender;
		this.esname = esname;
		this.fcname = fcname;
		this.gscgpa = gscgpa;
		this.hccgpa = hccgpa;
		this.igcname = igcname;
		this.jbranch = jbranch;
		this.kgcgpa = kgcgpa;
		this.lspec = lspec;
		this.mskills = mskills;
		this.nproject = nproject;
		this.oexperience = oexperience;
		this.pfile = pfile;
		this.qspecs = qspecs;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getAemail() {
		return aemail;
	}



	public void setAemail(String aemail) {
		this.aemail = aemail;
	}



	public int getBgyear() {
		return bgyear;
	}



	public void setBgyear(int bgyear) {
		this.bgyear = bgyear;
	}



	public String getCname() {
		return cname;
	}



	public void setCname(String cname) {
		this.cname = cname;
	}



	public String getDgender() {
		return dgender;
	}



	public void setDgender(String dgender) {
		this.dgender = dgender;
	}



	public String getEsname() {
		return esname;
	}



	public void setEsname(String esname) {
		this.esname = esname;
	}



	public String getFcname() {
		return fcname;
	}



	public void setFcname(String fcname) {
		this.fcname = fcname;
	}



	public double getGscgpa() {
		return gscgpa;
	}



	public void setGscgpa(double gscgpa) {
		this.gscgpa = gscgpa;
	}



	public double getHccgpa() {
		return hccgpa;
	}



	public void setHccgpa(double hccgpa) {
		this.hccgpa = hccgpa;
	}



	public String getIgcname() {
		return igcname;
	}



	public void setIgcname(String igcname) {
		this.igcname = igcname;
	}



	public String getJbranch() {
		return jbranch;
	}



	public void setJbranch(String jbranch) {
		this.jbranch = jbranch;
	}



	public double getKgcgpa() {
		return kgcgpa;
	}



	public void setKgcgpa(double kgcgpa) {
		this.kgcgpa = kgcgpa;
	}



	public String getLspec() {
		return lspec;
	}



	public void setLspec(String lspec) {
		this.lspec = lspec;
	}



	public String getMskills() {
		return mskills;
	}



	public void setMskills(String mskills) {
		this.mskills = mskills;
	}



	public String getNproject() {
		return nproject;
	}



	public void setNproject(String nproject) {
		this.nproject = nproject;
	}



	public String getOexperience() {
		return oexperience;
	}



	public void setOexperience(String oexperience) {
		this.oexperience = oexperience;
	}



	public byte[] getPfile() {
		return pfile;
	}



	public void setPfile(byte[] pfile) {
		this.pfile = pfile;
	}

	public String getQspecs() {
		return qspecs;
	}

public void setQspecs(String qspecs) {
		this.qspecs = qspecs;
	}
}
