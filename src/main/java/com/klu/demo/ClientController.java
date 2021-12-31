package com.klu.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ClientController 
{

	@Autowired
    private AService myService;
	 @Autowired
	 private MyService stuservice;
	
	
	@RequestMapping(value="/userlogin")
	public ModelAndView userlogin()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userlogin");
		return mv;
	}
	@RequestMapping(value="/profile")
	public ModelAndView profile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("profile");
		return mv;
	}
	
	
	@RequestMapping(value="/userhome")
	public ModelAndView userhome()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userhome");
		return mv;
	}
	@RequestMapping(value="/viewprofile")
	public ModelAndView viewprofile()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("viewprofile");
		return mv;
	}
	@RequestMapping(value="/userhome1")
	public ModelAndView userhome1()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("userhome1");
		return mv;
	}
	@RequestMapping(value="/resume")
	public ModelAndView resume()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("resumee");
		return mv;
	}
	@RequestMapping(value="/checkstudents1")
	public ModelAndView checkstudents()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("checkstudents");
		return mv;
	}
	
	// Login View Students
	
	 @GetMapping("/loginviewstudents")
	    public ModelAndView viewemployees()
	    {
	  	  List<Student> students= myService.getloginstudentrecords();
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("ViewStudents");
	  	  mv.addObject("studentdata",students);
	  	  return mv;
	    }
	 
	 // Not Login Students
	 
	 @GetMapping("/loginnotviewstudents")
	    public ModelAndView viewnotloginstudents()
	    {
	  	  List<Student> students= myService.getnotloginstudentrecords();
	  	  ModelAndView mv=new ModelAndView();
	  	  mv.setViewName("ViewStudents");
	  	  mv.addObject("studentdata",students);
	  	  return mv;
	    }
	 
	 // Add Jobs
	 
	 
	 @GetMapping("/addjob/{email}")// resp method gets executed, this is known as Handler Mapping
	  public ModelAndView addjob(@PathVariable String email)
	  {
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("AddJob");
	    mv.addObject(email);
	    return mv;
	  }
	 
	 @PostMapping("/submitjobdata")
	  public ModelAndView submitjobdata(@ModelAttribute("job") AddJob job,@RequestParam("org") String org, @RequestParam("jtitle") String jtitle, @RequestParam("loc") String loc, @RequestParam("tp") int tp, @RequestParam("amt") double amt, @RequestParam("yr") int yr)//mthod name can be anything
	  {
	    
	    AddJob add=new AddJob();
	    add.setOrg(org);
	    add.setRole(jtitle);
	    add.setLoc(loc);
	    add.setTp(tp);
	    add.setAmt(amt);
	    add.setYr(yr);
	    
	    stuservice.addjob(add);
	    
	    ModelAndView mv=new ModelAndView();
	    mv.setViewName("AddSuccess");
	    return mv;
	  }
	 
	 
	 // ORGANIZATION HOME PAGE
	 
	 @RequestMapping(value="/orghome")
		public ModelAndView orghome()
		{
			ModelAndView mv=new ModelAndView();
			mv.setViewName("orghome");
			return mv;
		}
	 
}