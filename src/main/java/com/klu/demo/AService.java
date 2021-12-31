package com.klu.demo;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klu.demo.Student;

@Service
public class AService {
  
  @Autowired
  ARepository admrepository;
  
  
  public boolean validate(String uname,String password)
  {
    try
    {
    Configuration cfg = new Configuration();
    cfg.configure("hibernate.cfg.xml");
    SessionFactory sf = cfg.buildSessionFactory();
    Session session = sf.openSession();
    //String uname=adm.getUname();
   // String pass=adm.getPassword();
    
    Query qry = session.createQuery("from AdminClass where uname='"+uname+"' and password='"+password+"' ");
    int flag=0;
    List<AdminClass> l1 = qry.list();
    /*for(AdminClass admin : l1)
    {
      System.out.println(adm.getUname());
      if(admin.getUname().equals(adm.getUname())&&admin.getPassword().equals(adm.getPassword()))
        flag=1;
     }*/
    System.out.println(l1.size()+" "+uname+" "+password);
    Transaction txt = session.beginTransaction();
    txt.commit();
    session.close();
    sf.close();
    if(l1.size()>0)
      return true;
    else
      return false;
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return false;
  }
 public boolean checklogin(String email,String password)
 {
	  try
	    {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg1.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Query qry = session.createQuery("from Student where email='"+email+"' and password='"+password+"' ");
	    int flag=0;
	    List<AdminClass> l1 = qry.list();
	    System.out.println(l1.size()+" "+email+" "+password);
	    Transaction txt = session.beginTransaction();
	
	    if(l1.size()>0)
	    {
	    	Query qry2=session.createQuery("update com.klu.demo.Student set status=:s1 where email=:e1");
			qry2.setString("s1","TRUE");
	    	qry2.setString("e1",email);
	    	System.out.println(email);
			int n1=qry2.executeUpdate();
			System.out.println(n1+"Record Updated");
		    txt.commit();
			 session.close();
			    sf.close();
	    	return true;
	    }
	    else
	    {
	    	 session.close();
			    sf.close();
	      return false;
	    }
	    }
	    catch(Exception e)
	    {
	      System.out.println(e);
	    }
	    return false;
	 
 }
 public List<Student> getloginstudentrecords()
 {

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg1.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Query qry4=session.createQuery("from Student where status=:v");
	      qry4.setParameter("v","TRUE");
	     List<Student> list4=qry4.list();
	     return list4;
 }  
 
 public List<Student> getnotloginstudentrecords()
 {

	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg1.xml");
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session session = sf.openSession();
	    Query qry4=session.createQuery("from Student where status IS NULL ");
	     // qry4.setParameter("v","TRUE");
	     List<Student> list4=qry4.list();
	     return list4;
 }  
 
 
 
}
