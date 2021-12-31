package com.klu.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CController {
  
	 private static final Logger logger = LoggerFactory.getLogger("CController.class");

  @Autowired
  CService stuservice;
  @Autowired
  AService admservice;
  @Autowired
  SendEmail sndmail;
  @Autowired
  private CService uservice;
  
  @GetMapping("/home")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView home()
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("home");
    return mv;
  }
  
  
  


  @PostMapping("/checkuser")
  public ModelAndView auth1(@RequestParam("uname") String username,@RequestParam("pwd") String password,HttpServletRequest request )
  {
    HttpSession session=request.getSession(); // creating session variable as same as servlet
  //uname and pwd will have values given in form
  // check login logic using HQL
    ModelAndView mv=new ModelAndView();
    System.out.println(username);
    if((username.equals("gayathri")&&password.equals("gayathri"))||(username.equals("sravani")&&password.equals("sravani"))||(username.equals("supraja")&&password.equals("supraja")))
    {
    mv.setViewName("adminhome");
    }
    else
      mv.setViewName("adminloginfail");
    return mv;
  // other code
  }
  
  @GetMapping("/adminhome")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView addstu() 
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("adminhome");
    return mv;
  }
  
  @GetMapping("/adminlogin")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView admlogin()
  {
    //emp-req obj of type Employee
    return new ModelAndView("AdminLogin1","adm",new AdminClass());
    
  }
  
  @PostMapping("/adminlogincheck")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView admlogin(@RequestParam("uname") String uname,@RequestParam("password") String password)
  {
    boolean val=admservice.validate(uname,password);
    ModelAndView mv=new ModelAndView();
    if(val==true)
    {
      mv.setViewName("adminhome");
      mv.addObject("name",uname);
    }
    else
    {
      mv.setViewName("adminloginfail");
    }
    return mv;
  }
  
  @PostMapping("/submitstudata")
  public ModelAndView submitempdata(@RequestParam("id") int id,@RequestParam("name") String name,@RequestParam("email") String email)
  {  
	Student stu=new Student();
	stu.setId(id);
	stu.setName(name);
	stu.setEmail(email);
    String str=sndmail.sendMail(stu); 
    stuservice.addstudentrecord(stu,str);
    System.out.println(str);
    ModelAndView mv=new ModelAndView();
    mv.setViewName("AddSuccess");
    mv.addObject("name",stu.getName());
    return mv;
  }
   
  @GetMapping("/addstudent")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView addstudent()
  {
    //emp-req obj of type Employee
    return new ModelAndView("AddStudent");
  }
  
  @GetMapping("/viewstu")
  public ModelAndView viewdata()
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("ViewStudents");
    return mv;
  }
  
  
  
  @GetMapping("/viewstudents")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView viewstudents()
  {
    ModelAndView mv=new ModelAndView();
    mv.setViewName("ViewStudents");
    return mv;
  }
  
  @PostMapping("/userlogincheck")// resp method gets executed, this is known as Handler Mapping
  public ModelAndView userlogin(@RequestParam("aemail") String email,@RequestParam("apassword") String password)
  {
    boolean val=admservice.checklogin(email,password);
    ModelAndView mv=new ModelAndView();
    if(val==true)
    {
      mv.setViewName("userhome");
     // mv.addObject("name",stu.getName());
     // System.out.println(stu.getName());
      mv.addObject("email",email);
    }
    else
    {
      mv.setViewName("adminloginfail");
    }
    return mv;
  }
  
  // Update Profile View
  
  @GetMapping("/updateprofileview/{id}")
  public String updateprofile(@PathVariable String id, Model model)
  {
  	 try 
  	 {
	            logger.info("Id= " + id);
	            Profile uv= uservice.getuview(Long.parseLong(id));
	            System.out.println(id);
	            System.out.println(uv.getAemail());
	            System.out.println("Controller Class");
	            model.addAttribute("id", uv.getId());
	            model.addAttribute("aemail",uv.getAemail());
	            model.addAttribute("cname",uv.getCname());
	            model.addAttribute("esname", uv.getEsname());
	            model.addAttribute("fcname",uv.getFcname());
	            model.addAttribute("gscgpa",uv.getGscgpa());
	            model.addAttribute("hccgpa",uv.getHccgpa());
	            model.addAttribute("igcname",uv.getIgcname());
	            model.addAttribute("jbranch",uv.getJbranch());
	            model.addAttribute("kgcgpa",uv.getKgcgpa());
	            model.addAttribute("lspec",uv.getLspec());
	            model.addAttribute("mskills",uv.getMskills());
	            model.addAttribute("nproject",uv.getNproject());
	            model.addAttribute("oexperience",uv.getOexperience());
	            model.addAttribute("qspecs",uv.getQspecs());
	           
	            byte[] encode = java.util.Base64.getEncoder().encode(uv.getPfile());
	            model.addAttribute("pfile", new String(encode, "UTF-8"));
	            return "updateprofile";
	        } catch (Exception e) {
	            logger.error("Error", e);
	            model.addAttribute("message", "Error in getting image");
	            return "redirect:/";
	        }
  }
  
  
  @PostMapping("/updateprofilecheck/{id}")
  public String fileUpload(@PathVariable String id,@RequestParam("email") String email,@RequestParam("bgyear") int bgyear,@RequestParam("name") String name,@RequestParam("gender") String gender,@RequestParam("sname") String sname,@RequestParam("cname") String cname, @RequestParam("scgpa") double scgpa,@RequestParam("ccgpa") double ccgpa,@RequestParam("gcname") String gcname,@RequestParam("branch") String branch,@RequestParam("gcgpa") double gcgpa,@RequestParam("spec") String spec,@RequestParam("skills") String skills,@RequestParam("project") String project,@RequestParam("experience") String experience,@RequestParam("file") MultipartFile file,@RequestParam("specs") String specs) {
      try {
          logger.info("Name= " + name);
          byte[] file1 = file.getBytes();
          Profile model = new Profile(email,bgyear,name,gender,sname,cname,scgpa,ccgpa,gcname,branch,gcgpa,spec,skills,project,experience,file1,specs);
          int saveProfile = uservice.updateprofile(model,Long.parseLong(id));
          if (saveProfile == 1) {
              return "success";
          } 
          else 
          {
              return "error";
          }
      } catch (Exception e) {
         // logger.error("ERROR", e);
          return "error";
      }
  }
  
  
  // Change Password View
  
  
  @GetMapping("/changepasswordview/{email}")
  public String changepasswordview(@PathVariable String email, Model model)
  {
  	 try 
  	 {
	            System.out.println("Controller Class");
	            model.addAttribute("email",email);      
	            return "changepassword";
	        } catch (Exception e) {
	            logger.error("Error", e);
	            model.addAttribute("message", "Error in getting image");
	            return "redirect:/";
	        }
  }
  
  
  
// Change Password
  
  
  @PostMapping("/changepassword/{email}")
  public String changepassword(@PathVariable String email,@RequestParam("oldpassword") String opassword,@RequestParam("newpassword") String npassword) {
      try {
          Student model = new Student();
          int saveProfile = uservice.changepassword(model,email,opassword,npassword);
          if (saveProfile == 1) {
              return "userhome";
          } 
          else 
          {
              return "error";
          }
      } catch (Exception e) {
         // logger.error("ERROR", e);
          return "error";
      }
  }
  
}