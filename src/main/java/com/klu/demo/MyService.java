package com.klu.demo;
import java.util.ArrayList;
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
import org.springframework.web.servlet.ModelAndView;

@Service
public class MyService 
{
	    private static final Logger logger = LoggerFactory.getLogger("MyService.class");
	    @Autowired
	    private ProfileRepository dao;
	    @Autowired
	    AddJobRepository jobrepo;
	    @Autowired
	    private StudentRespository dao1;
	    @Autowired
	    private ORepository orgrepository;
	    public int saveProfile(Profile model) {
	        try {
	            dao.save(model);
	            return 1;
	        } catch (Exception e) {
	            logger.error("ERROR", e);
	            return 0;
	        }
	    }
	    public List<Profile> getImages(String email) {
	    	
	    	 Configuration cfg=new Configuration();
	 		cfg.configure("hibernate.cfg2.xml");
	 		SessionFactory sf=cfg.buildSessionFactory();// Transient State
	 		Session session=sf.openSession(); 
	 		Query qry3=session.createQuery("from com.klu.demo.Profile where aemail=:v3");
	 		qry3.setParameter("v3",email);
	 		Transaction transaction=session.beginTransaction();
	 		//int n1=qry3.executeUpdate();
	 		List<Profile> list=qry3.list();
	 		System.out.println(list.size());
	 		//System.out.println("hello"+n1);
	 		//System.out.println(n1+"Record Updated"); 
	 	//	List<Profile> imageList= new ArrayList<Profile>();
       //     for (Profile m : new ArrayList<Profile>(list)) {
         //   	byte[] encode = java.util.Base64.getEncoder().encode(m.getPfile());
        //    	m.add("pfile", new String(encode, "UTF-8"));
         //   }
	 		return list;
}
	    
	    
	    public Profile getResume(Long id) {
	        Optional findById = dao.findById(id);
	        if (findById.isPresent()) {
	           Profile getResumeDetails = (Profile) findById.get();
	    logger.info("id= " + getResumeDetails.getId()+ " aemail= " + getResumeDetails.getAemail(),"cname="+getResumeDetails.getCname(),"esname="+getResumeDetails.getEsname(),"fcname="+getResumeDetails.getFcname(),"gscgpa="+getResumeDetails.getGscgpa(),"hccgpa="+getResumeDetails.getHccgpa(),"igcname="+getResumeDetails.getIgcname(),"jbranch="+getResumeDetails.getJbranch(),"kgcgpa="+getResumeDetails.getKgcgpa(),"lspec="+getResumeDetails.getLspec(),"mskills="+getResumeDetails.getMskills(),"nproject="+getResumeDetails.getNproject(),"oexperience="+getResumeDetails.getOexperience(),"qspecs="+getResumeDetails.getQspecs());
	            return getResumeDetails;
	        } 
	        else {
	            return null;
	        }
	    }
	    
	    // View Students
	    
	    public List<Student> getallstudentrecords()
	    {
	      return (List<Student>)dao1.findAll();
	    }
	    
	    //Adding Organization
	    
	    public int saveorganization(Organization model) {
	        try {
	            orgrepository.save(model);
	            return 1;
	        } catch (Exception e) {
	            logger.error("ERROR", e);
	            return 0;
	        }
	    }
	    
	    // View Organization
	    
	    public List<Organization> getallorgrecords()
	    {
	      return (List<Organization>)orgrepository.findAll();
	    }
	    
	    public  void addjob(AddJob addjob)
	    {
	      jobrepo.save(addjob);
	    }
	 
}
