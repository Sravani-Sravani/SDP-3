package com.klu.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ApplyJobService {

 //   @Autowired
//    private RequesttoDJ addrequest;
    @Autowired
    private ApplyJobRepository dbFileRepository;
    @Autowired
    private AddJobRepository addjob;
    @Autowired
    private SendAcceptedMail sendamail;
    @Autowired
    private SendRejectedMail sendrmail;


    public ApplyJob storeFile(MultipartFile file, String msg, String email, String fname, long stuid,String org,String status,String role) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if(fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            ApplyJob dbFile = new ApplyJob(fileName, file.getContentType(), file.getBytes(),stuid, fname, msg, email);
            dbFile.setOrg(org);
            dbFile.setStatus(status);
            dbFile.setRole(role);
            return dbFileRepository.save(dbFile);
        } catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        }
    }

    public ApplyJob getFile(String fileId) {
        return dbFileRepository.findById(fileId)
                .orElseThrow(() -> new MyFileNotFoundException("File not found with id " + fileId));
    }
    
    
    // View Jobs
    
    public List<AddJob> getjobrecords(	String email)
    {

     	/* Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg2.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
        Query qry=session1.createQuery("from Profile where aemail=:v1");
        qry.setParameter("v1",email);
        List<Profile> l=qry.list();
        int y=0;
        for (Profile m :l)
        {
        	y=m.getBgyear();
        	break;
        }
        System.out.println("Apply Service"+y);
    */
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg2.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(Profile.class)
    		    .setProjection(Projections.projectionList()
    		      .add(Projections.property("bgyear"), "bgyear"))
    		    
    		    .setResultTransformer(Transformers.aliasToBean(Profile.class));
    		  cr.add(Restrictions.eq("aemail",email));

    		  List<Profile> list = cr.list();
    		  int yr=0;
    	      for(Profile p:list)
    	      {
    	    	  yr=p.getBgyear();
    	    	  break;
    	    	  
    	      }
    	
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg3.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from AddJob where yr=:v1");
          qry4.setParameter("v1", yr);
          List<AddJob> list4=qry4.list();
          return list4;
    }
    
    
    // View Org Job Details
    
    public List<AddJob> getorgjobrecords(	String email)
    {
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg5.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(Organization.class)
    			 .setProjection(Projections.projectionList()
    	    		      .add(Projections.property("name"), "name"))
    	    		    
    	    		    .setResultTransformer(Transformers.aliasToBean(Organization.class));
    		  cr.add(Restrictions.eq("email",email));

    		  List<Organization> list = cr.list();
    		  String gor="null";
    	      for(Organization p:list)
    	      {
    	    	  gor=p.getName();
    	    	  break;
    	      }
    	System.out.println(gor);
    	System.out.println(email);
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg3.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from AddJob where org=:v1");
          qry4.setParameter("v1", gor);
          List<AddJob> list4=qry4.list();
          return list4;
    }
    
    // View Applicant Records
    
    public List<AddJob> getviewapplicantrecords(String email)
    {
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg5.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(Organization.class)
    			 .setProjection(Projections.projectionList()
    	    		      .add(Projections.property("name"), "name"))
    	    		    
    	    		    .setResultTransformer(Transformers.aliasToBean(Organization.class));
    		  cr.add(Restrictions.eq("email",email));

    		  List<Organization> list = cr.list();
    		  String gor="null";
    	      for(Organization p:list)
    	      {
    	    	  gor=p.getName();
    	    	  break;
    	      }
    	System.out.println(gor);
    	System.out.println(email);
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg4.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from ApplyJob where org=:v1 and status=:v2");
          qry4.setParameter("v1", gor);
          qry4.setParameter("v2", "PENDING");
          List<AddJob> list4=qry4.list();
          return list4;
    }

    
    // View Job Status
    
    public List<AddJob> viewjobstatus(String email)
    {

         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg4.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
         Query qry4=session.createQuery("from ApplyJob where email=:v1");
         qry4.setParameter("v1", email);
          List<AddJob> list4=qry4.list();
          return list4;
    }
    
    
    // Organization Login
    
    public boolean validateOrg(String uname, String pass)
    {
      try
      {
      Configuration cfg = new Configuration();
      cfg.configure("hibernate.cfg5.xml");
      SessionFactory sf = cfg.buildSessionFactory();
      Session session = sf.openSession();
      
      Query qry = session.createQuery("from Organization where email='"+uname+"' and password='"+pass+"' ");
      int flag=0;
      List<AdminClass> l1 = qry.list();
      /*for(AdminClass admin : l1)
      {
        System.out.println(adm.getUname());
        if(admin.getUname().equals(adm.getUname())&&admin.getPassword().equals(adm.getPassword()))
          flag=1;
       }*/
      System.out.println(l1.size()+" "+uname+" "+pass);
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
    
    
    public List<ApplyJob> acceptrequest(String email,String role,String org) 
    {
  	    Configuration cfg=new Configuration();
  		cfg.configure("hibernate.cfg4.xml");
  		SessionFactory sf=cfg.buildSessionFactory();// Transient State
  		Session session=sf.openSession(); 
  		System.out.println("Service Class");
  		System.out.println(email);
  		Query qry3=session.createQuery("update com.klu.demo.ApplyJob set status=:v2 where email=:v3 and role=:v1");
  		qry3.setParameter("v1",role);
  		qry3.setParameter("v2","ACCEPTED");
  		qry3.setParameter("v3",email);
  		Transaction transaction=session.beginTransaction();
  		int n1=qry3.executeUpdate();
  	//	transaction.commit();
  	
  		System.out.println(n1);
  		
  		Query qry4=session.createQuery("from ApplyJob where status=:v4");
  		qry4.setParameter("v4", "ACCEPTED");
  		List<ApplyJob> l=qry4.list();
  	  sendamail.sendMail(role,email,org);
  	  
		transaction.commit();
  	    session.close();
  	    sf.close();
  		return l;	    
  }
    
    
    // Reject Request
    
    
    public List<ApplyJob> rejectrequest(String email,String role,String org) 
    {
  	    Configuration cfg=new Configuration();
  		cfg.configure("hibernate.cfg4.xml");
  		SessionFactory sf=cfg.buildSessionFactory();// Transient State
  		Session session=sf.openSession(); 
  		System.out.println("Service Class");
  		System.out.println(email);
  		Query qry3=session.createQuery("update com.klu.demo.ApplyJob set status=:v2 where email=:v3 and role=:v1");
  		qry3.setParameter("v1",role);
  		qry3.setParameter("v2","REJECTED");
  		qry3.setParameter("v3",email);
  		Transaction transaction=session.beginTransaction();
  		int n1=qry3.executeUpdate();
  	//	transaction.commit();
  	
  		System.out.println(n1);
  		
  		Query qry4=session.createQuery("from ApplyJob where status=:v4");
  		qry4.setParameter("v4", "REJECTED");
  		List<ApplyJob> l=qry4.list();
  		sendrmail.sendMail(role,email,org);
		transaction.commit();
  	    session.close();
  	    sf.close();
  		return l;	    
  }
    
    
    // View Accepted Students
    
    public List<ApplyJob> viewacceptrequest(	String email) 
    {
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg4.xml");
    	System.out.println(email);
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(ApplyJob.class)
    			 .setProjection(Projections.projectionList()
    	    		      .add(Projections.property("org"), "org"))
    	    		    
    	    		    .setResultTransformer(Transformers.aliasToBean(ApplyJob.class));
    		  cr.add(Restrictions.eq("email",email));

    		  List<ApplyJob> list = cr.list();
    		  String org="null";
    	      for(ApplyJob p:list)
    	      {
    	    	  org=p.getOrg();
    	    	  break;
    	      }
    	System.out.println(org);
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg4.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from ApplyJob where org=:v1 and status=:v2");
          qry4.setParameter("v1", org);
          qry4.setParameter("v2", "ACCEPTED");
          List<ApplyJob> list4=qry4.list();
          System.out.println("SERVICE");
          System.out.println(email);
        
          return list4;
    }
    
    
    // View Rejected Students
    
    public List<ApplyJob> viewrejectrequest(String email)
    {
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg4.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(ApplyJob.class)
    			 .setProjection(Projections.projectionList()
    	    		      .add(Projections.property("org"), "org"))
    	    		    
    	    		    .setResultTransformer(Transformers.aliasToBean(ApplyJob.class));
    		  cr.add(Restrictions.eq("email",email));

    		  List<ApplyJob> list = cr.list();
    		  String org="null";
    	      for(ApplyJob p:list)
    	      {
    	    	  org=p.getOrg();
    	    	  break;
    	      }
    	System.out.println(org);
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg4.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from ApplyJob where org=:v1 and status=:v2");
          qry4.setParameter("v1", org);
          qry4.setParameter("v2", "REJECTED");
          List<ApplyJob> list4=qry4.list();
          return list4;
    }
    
    // View All Jobs
    
    public List<AddJob> getalljobrecords()
    {
      return (List<AddJob>)addjob.findAll();
    }
    
    
    
    // Search by role
    
    
    public List<AddJob> searchbyrole(String search,String email)
    {
    	Configuration cfg2=new Configuration();
    	cfg2.configure("hibernate.cfg4.xml");
    	SessionFactory sf1 = cfg2.buildSessionFactory();
        Session session1 = sf1.openSession();
    	Criteria cr = session1.createCriteria(ApplyJob.class)
    			 .setProjection(Projections.projectionList()
    	    		      .add(Projections.property("org"), "org"))
    	    		    
    	    		    .setResultTransformer(Transformers.aliasToBean(ApplyJob.class));
    		  cr.add(Restrictions.eq("email",email));

    		  List<ApplyJob> list = cr.list();
    		  String org="null";
    	      for(ApplyJob p:list)
    	      {
    	    	  org=p.getOrg();
    	    	  break;
    	      }
    	System.out.println(org);
    	 Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg3.xml");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
          Query qry4=session.createQuery("from AddJob where org=:v1 and role=:v2");
          qry4.setParameter("v1", org);
          qry4.setParameter("v2", search);
          List<AddJob> list4=qry4.list();
          return list4;
    }

    
    // Request to delete Jobs
    
    /*
    public void sendrequesttodelete(int jid,String org,String role)
    {
         Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg6.xml");
         System.out.println("Hii");
         SessionFactory sf = cfg.buildSessionFactory();
         Session session = sf.openSession();
         RequesttoDJ rd=new RequesttoDJ();
         System.out.println(jid+" "+org+" "+role);
         Transaction transaction=session.beginTransaction();
         int id=jid;
         rd.setId(id);
         rd.setOrg(org);
         rd.setRole(role);
 		 session.save(rd);
 		 System.out.println("HIIHello2"+jid+" "+org+" "+role);
 		transaction.commit();
 		System.out.println("Request Saved");
 		session.close();
 		sf.close();	
     }
    
    public void sendrequesttodelete(int jid,String org,String role)
    {
    	RequesttoDJ rd=new RequesttoDJ();
    	rd.setId(jid);
    	rd.setOrg(org);
    	rd.setRole(role);
    	((CrudRepository<RequesttoDJ,String>) addrequest).save(rd);
    	
    }
    // View all deleted Jobs
    public List<RequesttoDJ> getalldeletejobrecords()
    {
      return (List<RequesttoDJ>)((JpaRepository<RequesttoDJ, String>) addrequest).findAll();
    }
  */
}