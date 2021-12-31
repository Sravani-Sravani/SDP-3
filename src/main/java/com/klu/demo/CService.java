package com.klu.demo;
import java.util.Optional;

import java.awt.Image;
import java.util.List;
import java.util.Optional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CService {
  
  @Autowired
  CRepository sturepository;
  
  @Autowired
  private ProfileRepository dao2;
  
  public  void addstudentrecord(Student stu, String pass)
  {
    stu.setPassword(pass);
    sturepository.save(stu);
  }
//  public boolean validate(String uname, String password)
//  {
//    Configuration cfg = new Configuration();
//    cfg.configure("hibernate.cfg.xml");
//    SessionFactory sf = cfg.buildSessionFactory();
//    Session session = sf.openSession();
//    Query qry = session.createQuery("from admin where uname=? and password=?");
//    qry.setString(0, uname);
//    qry.setString(1, password);
//    List<Admin> l1 = qry.list();
//    for(Admin admin:l1)
//    {
//      if(uname.equals("gayathri")&& password.equals("gayathri"))
//              return true;
//      else
//              return false;
//     }
//    Transaction txt = session.beginTransaction();
//    txt.commit();
//    session.close();
//    sf.close();
//    return true;
//    }
//  
  
  public Profile getuview(Long id)
  {
  	System.out.println("Service Class");
  	System.out.println("ID ID: "+id);
      Optional findById = dao2.findById(id);
      if (findById.isPresent()) {
         Profile getuv= (Profile) findById.get();
          return getuv;
      } 
      else {
          return null;
      }
  }
  
  
  public int updateprofile(Profile model,Long id) 
  {
	  try
	  {
	  Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg2.xml");
		SessionFactory sf=cfg.buildSessionFactory();// Transient State
		Session session=sf.openSession(); 
		System.out.println("Service Class:     "+model.getAemail());
		System.out.println(id+"S"+model.getId());
		Query qry3=session.createQuery("update com.klu.demo.Profile set aemail=:v1,bpwd=:v16,cname=:v2,dgender=:v17,esname=:v3,fcname=:v4,gscgpa=:v5,hccgpa=:v6,igcname=:v7,jbranch=:v8,kgcgpa=:v9,lspec=:v10,mskills=:v11,nproject=:v12,oexperience=:v13,pfile=:v14,qspecs=:v15 where id=:v67");
		qry3.setParameter("v1",model.getAemail());
		qry3.setParameter("v16",model.getBgyear());
		qry3.setParameter("v2",model.getCname());
		qry3.setParameter("v17",model.getDgender());
		qry3.setParameter("v3",model.getEsname());
		qry3.setParameter("v4",model.getFcname());
		qry3.setParameter("v5",model.getGscgpa());
		qry3.setParameter("v6",model.getHccgpa());
		qry3.setParameter("v7",model.getIgcname());
		qry3.setParameter("v8",model.getJbranch());
		qry3.setParameter("v9",model.getKgcgpa());
		qry3.setParameter("v10",model.getLspec());
		qry3.setParameter("v11",model.getMskills());
		qry3.setParameter("v12",model.getNproject());
		qry3.setParameter("v13",model.getOexperience());
		qry3.setParameter("v14",model.getPfile());
		qry3.setParameter("v15",model.getQspecs());
		qry3.setParameter("v67", id);
		
		
		Transaction transaction=session.beginTransaction();
		int n1=qry3.executeUpdate();
		System.out.println("hello"+n1);
		System.out.println(n1+"Record Updated"); 
		transaction.commit();
		session.close(); // Detached State
		sf.close();
		return n1;
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	return 0;
}
  
  

  
  
  
  // Change Password
  
  
  public int changepassword(Student model,String email,String opassword,String npassword) 
  {
	  try
	  {
	    Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg1.xml");
		SessionFactory sf=cfg.buildSessionFactory();// Transient State
		Session session=sf.openSession(); 
		System.out.println("Service Class:     "+model.getName());
		System.out.println("S"+model.getId());
		Query qry3=session.createQuery("update com.klu.demo.Student set password=:v2 where email=:v3 and password=:v1");
		qry3.setParameter("v1",opassword);
		qry3.setParameter("v2",npassword);
		qry3.setParameter("v3",email);
		Transaction transaction=session.beginTransaction();
		int n1=qry3.executeUpdate();
		System.out.println("hello"+n1);
		System.out.println(n1+"Record Updated"); 
		transaction.commit();
		session.close(); // Detached State
		sf.close();
		return n1;
	  }
	  catch(Exception e)
	  {
		  System.out.println(e);
	  }
	return 0;
}
  
}